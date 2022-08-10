package com.hplays.dto.messageusertouser;

import java.io.Serializable;
import java.util.List;

public class MessageUserFindSuccessDTO implements Serializable {

    private List<MessageUserToUserDTO> messages;
    private String messageTransaction;

    public List<MessageUserToUserDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageUserToUserDTO> messages) {
        this.messages = messages;
    }

    public String getMessageTransaction() {
        return messageTransaction;
    }

    public void setMessageTransaction(String messageTransaction) {
        this.messageTransaction = messageTransaction;
    }
}
