package com.oyuneticaret.service;

import com.oyuneticaret.dto.user.UserFindDTO;
import com.oyuneticaret.model.User;

import java.util.List;

public interface UserService {

    void save(User user);
    List<User> findUsers(UserFindDTO userFindDTO);
    User findUserById(Long id);
    void delete(User user);

}
