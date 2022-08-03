package com.oyuneticaret.dao.Impl;

import com.oyuneticaret.dao.UserDao;
import com.oyuneticaret.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(User user) {
        getCurrentSession().save(user);
    }

    @Override
    public List<User> findUsers(String firstName,String lastName, String nickname) {
        StringBuilder query = new StringBuilder("SELECT * FROM USERS AS U WHERE 1=1");

        if(firstName != null){
            query.append(" AND U.FIRST_NAME LIKE '"+firstName+"%'");
        }
        if(lastName != null){
            query.append(" AND U.LAST_NAME LIKE '"+lastName+"%'");
        }
        if(nickname != null){
            query.append(" AND U.NICKNAME LIKE '%"+nickname+"%'");
        }

        return getCurrentSession().createNativeQuery(query.toString()).addEntity(User.class).getResultList();
    }

    @Override
    public User findUserById(Long id) {
        return getCurrentSession().get(User.class,id);
    }

    @Override
    public void delete(User user) {
        getCurrentSession().delete(user);
    }
}
