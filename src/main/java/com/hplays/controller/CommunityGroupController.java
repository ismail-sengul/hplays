package com.hplays.controller;


import com.hplays.dto.communitygroup.CommunityGroupCreateDTO;
import com.hplays.dto.communitygroup.CommunityGroupUpdateDTO;
import com.hplays.model.CommunityGroup;
import com.hplays.model.User;
import com.hplays.service.CommunityGroupService;
import com.hplays.service.UserService;
import com.hplays.utils.CommunityGroupUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/communitygroup")
public class CommunityGroupController {

    @Autowired
    CommunityGroupService communityGroupService;

    @Autowired
    UserService userService;

    CommunityGroupUtil communityGroupUtil = new CommunityGroupUtil();

    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody CommunityGroupCreateDTO communityGroupCreateDTO){

        if(communityGroupCreateDTO.getCreatorId() == null){
            throw new IllegalArgumentException("Grup kurucusu bilgisi girilmedi.");
        }else if(communityGroupCreateDTO.getGroupName() == null){
            throw new IllegalArgumentException("Grup adı girilmedi.");
        }

        CommunityGroup communityGroup = new CommunityGroup();
        User creatorUser = userService.findUserById(communityGroupCreateDTO.getCreatorId());

        if(creatorUser == null){
            throw new IllegalArgumentException("Kullanıcı Bulunamadı.");
        }
        communityGroup.setCreator(creatorUser);
        communityGroup.setGroupName(communityGroupCreateDTO.getGroupName());
        communityGroup.setGroupDescription(communityGroupCreateDTO.getGroupDescription());

        communityGroupService.save(communityGroup);

        return ResponseEntity.ok(communityGroupUtil.createCommunityGroupSuccessDTO(communityGroup,"Ekleme İşlemi Başarılı."));
    }

    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public ResponseEntity<?> findGroups(@RequestParam(required = false) Long creatorId,
                                        @RequestParam(required = false) String groupName,
                                        @RequestParam(required = false) String groupDescription){
        List<CommunityGroup> communityGroups = communityGroupService.findCommunityGroups(creatorId,groupName,groupDescription);
        return ResponseEntity.ok(communityGroupUtil.createCommunityGroupFindSuccessDTO(communityGroups));
    }

    @RequestMapping(value = "/get?{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findGroupById(@PathVariable(value = "id") Long id){
        CommunityGroup communityGroup = communityGroupService.findCommunityGroupById(id);

        if(communityGroup == null){
            throw new IllegalArgumentException("Grup Bulunamadı.");
        }
        return ResponseEntity.ok(communityGroupUtil.createCommunityGroupSuccessDTO(communityGroup,"İşlem Başarılı"));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateGroup(@RequestBody CommunityGroupUpdateDTO communityGroupUpdateDTO){
        CommunityGroup communityGroup = communityGroupService.findCommunityGroupById(communityGroupUpdateDTO.getId());

        if(communityGroup == null){
            throw new IllegalArgumentException("Grup Bulunamadı.");
        }
        User creatorUser = userService.findUserById(communityGroupUpdateDTO.getCreatorId());
        if(creatorUser != null){
            communityGroup.setCreator(creatorUser);
        }
        if(communityGroupUpdateDTO.getGroupDescription() != null){
            communityGroup.setGroupDescription(communityGroupUpdateDTO.getGroupDescription());
        }
        if(communityGroupUpdateDTO.getGroupName() != null){
            communityGroup.setGroupName(communityGroupUpdateDTO.getGroupName());
        }

        communityGroupService.save(communityGroup);

        return ResponseEntity.ok(communityGroupUtil.createCommunityGroupSuccessDTO(communityGroup,"Güncelleme İşlemi Başarılı."));
    }


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteGroup(@RequestParam Long id){
        CommunityGroup communityGroup = communityGroupService.findCommunityGroupById(id);

        if(communityGroup == null){
            throw new IllegalArgumentException("Grup Bulunamadı.");
        }
        communityGroupService.delete(communityGroup);
        return ResponseEntity.ok(communityGroupUtil.createCommunityGroupSuccessDTO(communityGroup,"Silme İşlemi Başarılı."));
    }



}
