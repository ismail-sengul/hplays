package com.hplays.service;

import com.hplays.model.MessageUserToUser;

import java.util.List;

public interface MessageUserService {
    void save(MessageUserToUser messageUserToUser);
    MessageUserToUser listMessagesById(Long id);
    List<MessageUserToUser> listMessages(Long receiverId, Long senderId, String message);
    void delete(MessageUserToUser messageUserToUser);
}
