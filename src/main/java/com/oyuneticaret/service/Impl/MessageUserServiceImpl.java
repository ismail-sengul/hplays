package com.oyuneticaret.service.Impl;

import com.oyuneticaret.dao.MessageUserDao;
import com.oyuneticaret.model.MessageUserToUser;
import com.oyuneticaret.service.MessageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MessageUserServiceImpl implements MessageUserService {

    @Autowired
    MessageUserDao messageUserDao;


    @Override
    @Transactional
    public void save(MessageUserToUser messageUserToUser) {
        messageUserDao.save(messageUserToUser);
    }

    @Override
    public MessageUserToUser listMessagesById(Long id) {
        return messageUserDao.listMessagesById(id);
    }

    @Override
    public List<MessageUserToUser> listMessages(Long receiverId, Long senderId, String message) {
        return messageUserDao.listMessages(receiverId,senderId,message);
    }

    @Override
    @Transactional
    public void delete(MessageUserToUser messageUserToUser) {
        messageUserDao.delete(messageUserToUser);
    }
}
