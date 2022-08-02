package com.oyuneticaret.service.Impl;

import com.oyuneticaret.dao.UserDao;
import com.oyuneticaret.dto.user.UserFindDTO;
import com.oyuneticaret.model.User;
import com.oyuneticaret.service.UserService;
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
