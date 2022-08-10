package com.hplays.utils;

import com.hplays.dto.messageusertouser.MessageUserFindSuccessDTO;
import com.hplays.dto.messageusertouser.MessageUserSuccessDTO;
import com.hplays.dto.messageusertouser.MessageUserToUserDTO;
import com.hplays.model.MessageUserToUser;

import java.util.ArrayList;
import java.util.List;

public class MessageUserUtil {

    private UserUtil userUtil = new UserUtil();

    public MessageUserSuccessDTO createMessageUserSuccessDTO(MessageUserToUser messageUserToUser,String message){

        MessageUserSuccessDTO messageUserSuccessDTO = new MessageUserSuccessDTO();
        messageUserSuccessDTO.setId(messageUserToUser.getId());
        messageUserSuccessDTO.setMessageUser(messageUserToUser.getMessage());
        messageUserSuccessDTO.setReceiverUser(userUtil.convertUserDTO(messageUserToUser.getReceiverUser()));
        messageUserSuccessDTO.setSenderUser(userUtil.convertUserDTO(messageUserToUser.getSenderUser()));
        messageUserSuccessDTO.setMessageTransaction(message);

        return messageUserSuccessDTO;

    }

    public MessageUserFindSuccessDTO createMessageUserFindSuccessDTO(List<MessageUserToUser> messageUserToUsers){
        MessageUserFindSuccessDTO messageUserFindSuccessDTO = new MessageUserFindSuccessDTO();

        List<MessageUserToUserDTO> messageUserToUserDTOS = new ArrayList<>();

        for (MessageUserToUser messageUserToUser : messageUserToUsers){
            MessageUserToUserDTO messageUserToUserDTO = new MessageUserToUserDTO();
            messageUserToUserDTO.setId(messageUserToUser.getId());
            messageUserToUserDTO.setMessageUser(messageUserToUser.getMessage());
            messageUserToUserDTO.setReceiverUser(userUtil.convertUserDTO(messageUserToUser.getReceiverUser()));
            messageUserToUserDTO.setSenderUser(userUtil.convertUserDTO(messageUserToUser.getSenderUser()));
            messageUserToUserDTOS.add(messageUserToUserDTO);
        }
        messageUserFindSuccessDTO.setMessages(messageUserToUserDTOS);
        messageUserFindSuccessDTO.setMessageTransaction("Listeleme İşlemi Başarılı.");
        return messageUserFindSuccessDTO;
    }
}
