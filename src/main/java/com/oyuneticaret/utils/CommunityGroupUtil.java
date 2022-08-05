package com.oyuneticaret.utils;

import com.oyuneticaret.dto.communitygroup.CommunityGroupDTO;
import com.oyuneticaret.dto.communitygroup.CommunityGroupFindSuccessDTO;
import com.oyuneticaret.dto.communitygroup.CommunityGroupSuccessDTO;
import com.oyuneticaret.model.CommunityGroup;

import java.util.ArrayList;
import java.util.List;

public class CommunityGroupUtil {

    UserUtil userUtil = new UserUtil();

    public CommunityGroupSuccessDTO createCommunityGroupSuccessDTO(CommunityGroup communityGroup,String message){
        CommunityGroupSuccessDTO communityGroupSuccessDTO = new CommunityGroupSuccessDTO();
        communityGroupSuccessDTO.setId(communityGroup.getId());
        communityGroupSuccessDTO.setCreatorUser(userUtil.convertUserDTO(communityGroup.getCreator()));
        communityGroupSuccessDTO.setGroupDescription(communityGroup.getGroupDescription());
        communityGroupSuccessDTO.setGroupName(communityGroup.getGroupName());
        communityGroupSuccessDTO.setMessage(message);

        return communityGroupSuccessDTO;
    }


    public CommunityGroupFindSuccessDTO createCommunityGroupFindSuccessDTO(List<CommunityGroup> communityGroups){
        CommunityGroupFindSuccessDTO communityGroupFindSuccessDTO = new CommunityGroupFindSuccessDTO();
        List<CommunityGroupDTO> communityGroupDTOS = new ArrayList<>();

        for(CommunityGroup communityGroup : communityGroups){
            CommunityGroupDTO communityGroupDTO = new CommunityGroupDTO();
            communityGroupDTO.setId(communityGroup.getId());
            communityGroupDTO.setCreatorUser(userUtil.convertUserDTO(communityGroup.getCreator()));
            communityGroupDTO.setGroupDescription(communityGroup.getGroupDescription());
            communityGroupDTO.setGroupName(communityGroup.getGroupName());
            communityGroupDTOS.add(communityGroupDTO);
        }
        communityGroupFindSuccessDTO.setCommunityGroupDTOS(communityGroupDTOS);
        communityGroupFindSuccessDTO.setMessage("Listeleme İşlemi Başarılı.");

        return communityGroupFindSuccessDTO;
    }


}
