package com.hplays.service.Impl;

import com.hplays.dao.UserDao;
import com.hplays.model.User;
import com.hplays.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> findUsers(String firstName, String lastName, String nickname) {
        return userDao.findUsers(firstName,lastName,nickname);
    }


    @Override
    public User findUserById(Long id) {
        return userDao.findUserById(id);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }
}
