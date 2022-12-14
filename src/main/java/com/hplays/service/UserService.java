package com.hplays.service;

import com.hplays.model.User;

import java.util.List;

public interface UserService {

    void save(User user);
    List<User> findUsers(String firstName,String lastName,String nickname);
    User findUserById(Long id);
    void delete(User user);

}
