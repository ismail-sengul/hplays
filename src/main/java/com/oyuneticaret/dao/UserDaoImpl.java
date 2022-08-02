package com.oyuneticaret.dao;

import com.oyuneticaret.dto.user.UserFindDTO;
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
    public List<User> findUsers(UserFindDTO userFindDTO) {
        StringBuilder query = new StringBuilder("from User as U");

        if(userFindDTO.getFirstName() != null || userFindDTO.getLastName() != null || userFindDTO.getNickname() != null){
            query.append(" where ");

            if(userFindDTO.getFirstName() != null){
                query.append("U.firstName = '"+userFindDTO.getFirstName()+"'");
            }
            if(userFindDTO.getLastName() != null){
                query.append("U.lastName = '"+userFindDTO.getLastName()+"'");
            }
            if(userFindDTO.getNickname() != null){
                query.append("U.nickname = '"+userFindDTO.getNickname()+"'");
            }
        }
        return getCurrentSession().createQuery(query.toString()).getResultList();
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
