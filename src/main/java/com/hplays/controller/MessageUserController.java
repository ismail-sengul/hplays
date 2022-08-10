package com.hplays.controller;


import com.hplays.dto.messageusertouser.MessageUserCreateDTO;
import com.hplays.dto.messageusertouser.MessageUserUpdateDTO;
import com.hplays.model.MessageUserToUser;
import com.hplays.model.User;
import com.hplays.service.MessageUserService;
import com.hplays.service.UserService;
import com.hplays.utils.MessageUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/messages")
public class MessageUserController {

    @Autowired
    MessageUserService messageUserService;

    @Autowired
    UserService userService;


    MessageUserUtil messageUserUtil = new MessageUserUtil();

    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody MessageUserCreateDTO messageUserCreateDTO){
        if(messageUserCreateDTO.getReceiverId() == messageUserCreateDTO.getSenderId()){
            throw new IllegalArgumentException("Alıcı kullanıcı ile gönderen kullanıcı aynı olamaz.");
        }
        User receiverUser = userService.findUserById(messageUserCreateDTO.getReceiverId());
        User senderUser = userService.findUserById(messageUserCreateDTO.getSenderId());

        MessageUserToUser message = new MessageUserToUser();
        message.setMessage(messageUserCreateDTO.getMessage());
        message.setReceiverUser(receiverUser);
        message.setSenderUser(senderUser);

        messageUserService.save(message);

        return ResponseEntity.ok(messageUserUtil.createMessageUserSuccessDTO(message,"Ekleme İşlemi Başarılı."));

    }

    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public ResponseEntity<?> findMessages(@RequestParam(required = false) Long receiverId,
                                          @RequestParam(required = false) Long senderId,
                                          @RequestParam(required = false) String message){

        List<MessageUserToUser> messages = messageUserService.listMessages(receiverId,senderId,message);
        return ResponseEntity.ok(messageUserUtil.createMessageUserFindSuccessDTO(messages));
    }

    @RequestMapping(value = "/get?{id}" , method = RequestMethod.GET)
    public ResponseEntity<?> findMessageById(@PathVariable(value = "id") Long id){
        MessageUserToUser messageUserToUser = messageUserService.listMessagesById(id);

        if(messageUserToUser == null){
            throw new IllegalArgumentException("Mesaj bulunamadı.");
        }

        return ResponseEntity.ok(messageUserUtil.createMessageUserSuccessDTO(messageUserToUser,"İşlem Başarılı."));
    }

    @RequestMapping(value = "/update" , method = RequestMethod.PUT)
    public ResponseEntity<?> updateMessage(@RequestBody MessageUserUpdateDTO messageUserUpdateDTO){
        MessageUserToUser messageUserToUser = messageUserService.listMessagesById(messageUserUpdateDTO.getId());

        if(messageUserToUser == null){
            throw new IllegalArgumentException("Mesaj bulunamadı.");
        }
        if(messageUserUpdateDTO.getReceiverId() != null){
            User receiverUser = userService.findUserById(messageUserUpdateDTO.getReceiverId());
            messageUserToUser.setReceiverUser(receiverUser);
        }
        if(messageUserUpdateDTO.getSenderId() != null){
            User senderUser = userService.findUserById(messageUserUpdateDTO.getSenderId());
            messageUserToUser.setReceiverUser(senderUser);
        }
        if(messageUserUpdateDTO.getMessage() != null){
            messageUserToUser.setMessage(messageUserUpdateDTO.getMessage());
        }
        messageUserService.save(messageUserToUser);

        return ResponseEntity.ok(messageUserUtil.createMessageUserSuccessDTO(messageUserToUser,"Update İşlemi Başarılı."));
    }

    @RequestMapping(value = "/delete" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMessage(@RequestParam Long id){
        MessageUserToUser messageUserToUser = messageUserService.listMessagesById(id);

        if(messageUserToUser == null){
            throw new IllegalArgumentException("Mesaj bulunamadı.");
        }
        messageUserService.delete(messageUserToUser);

        return ResponseEntity.ok(messageUserUtil.createMessageUserSuccessDTO(messageUserToUser,"Silme İşlemi Başarılı."));
    }
}
