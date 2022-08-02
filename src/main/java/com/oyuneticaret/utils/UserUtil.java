package com.oyuneticaret.utils;

import com.oyuneticaret.dto.user.UserDTO;
import com.oyuneticaret.dto.user.UserSuccessDTO;
import com.oyuneticaret.model.User;

public class UserUtil {

    public UserSuccessDTO createUserSuccessDTO(User user,String message){
        UserSuccessDTO userSuccessDTO = new UserSuccessDTO();
        userSuccessDTO.setId(user.getId());
        userSuccessDTO.setFirstName(user.getFirstName());
        userSuccessDTO.setLastName(user.getLastName());
        userSuccessDTO.setAddress(user.getAddress());
        userSuccessDTO.setNickname(user.getNickname());
        userSuccessDTO.setBirthOfDate(user.getBirthOfDate());
        userSuccessDTO.setEmail(user.getEmail());
        userSuccessDTO.setMessage(message);

        return userSuccessDTO;
    }
    public UserDTO convertUserDTO(User user){
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setLastName(user.getLastName());
        userDTO.setBirthOfDate(user.getBirthOfDate());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setNickname(user.getNickname());
        userDTO.setAddress(user.getAddress());
        return userDTO;
    }

}
