package com.oyuneticaret.dto.messageusertouser;

import com.oyuneticaret.dto.user.UserDTO;

public class MessageUserToUserDTO {

    private Long id;
    private UserDTO senderUser;
    private UserDTO receiverUser;
    private String messageUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getSenderUser() {
        return senderUser;
    }

    public void setSenderUser(UserDTO senderUser) {
        this.senderUser = senderUser;
    }

    public UserDTO getReceiverUser() {
        return receiverUser;
    }

    public void setReceiverUser(UserDTO receiverUser) {
        this.receiverUser = receiverUser;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }
}
