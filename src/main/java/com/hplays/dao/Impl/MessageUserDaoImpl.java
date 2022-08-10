package com.hplays.dao.Impl;

import com.hplays.dao.MessageUserDao;
import com.hplays.model.MessageUserToUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageUserDaoImpl implements MessageUserDao {

    @Autowired
    SessionFactory sessionFactory;

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(MessageUserToUser messageUserToUser) {
        getCurrentSession().save(messageUserToUser);
    }

    @Override
    public MessageUserToUser listMessagesById(Long id) {
        return getCurrentSession().get(MessageUserToUser.class,id);
    }

    @Override
    public List<MessageUserToUser> listMessages(Long receiverId, Long senderId, String message) {
        StringBuilder query = new StringBuilder("SELECT * FROM MESSAGE_USER_TO_USER AS M WHERE 1=1");

        if(receiverId != null){
            query.append(" AND M.RECEIVER_ID = "+receiverId);
        }if(senderId != null){
            query.append(" AND M.SENDER_ID = "+senderId);
        }if(message != null){
            query.append(" AND M.MESSAGE LIKE %"+message+"%");
        }
        return getCurrentSession().createNativeQuery(query.toString()).addEntity(MessageUserToUser.class).getResultList();
    }

    @Override
    public void delete(MessageUserToUser messageUserToUser) {
        getCurrentSession().delete(messageUserToUser);
    }
}
