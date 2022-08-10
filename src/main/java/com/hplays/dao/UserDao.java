package com.hplays.dao;

import com.hplays.model.User;

import java.util.List;

public interface UserDao {

    void save(User user);
    List<User> findUsers(String firstName,String lastName,String nickname);
    User findUserById(Long id);
    void delete(User user);

}
