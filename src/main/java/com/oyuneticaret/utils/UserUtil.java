package com.oyuneticaret.utils;

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

}
