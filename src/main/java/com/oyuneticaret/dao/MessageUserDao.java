package com.oyuneticaret.dao;

import com.oyuneticaret.model.MessageUserToUser;

import java.util.List;

public interface MessageUserDao {

    void save(MessageUserToUser messageUserToUser);
    MessageUserToUser listMessagesById(Long id);
    List<MessageUserToUser> listMessages(Long receiverId,Long senderId,String message);
    void delete(MessageUserToUser messageUserToUser);
}
