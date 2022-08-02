package com.oyuneticaret.service;

import com.oyuneticaret.dao.UserDao;
import com.oyuneticaret.dto.user.UserFindDTO;
import com.oyuneticaret.model.User;
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
    public List<User> findUsers(UserFindDTO userFindDTO) {
        return userDao.findUsers(userFindDTO);
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
