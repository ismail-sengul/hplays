package com.oyuneticaret.dto.messageusertouser;

import java.io.Serializable;

public class MessageUserCreateDTO implements Serializable {

    private Long receiverId;
    private Long senderId;
    private String message;

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
