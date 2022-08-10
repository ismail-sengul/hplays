package com.oyuneticaret.dto.user;

import java.io.Serializable;

public class UserFriendSuccessDTO implements Serializable {

    private UserDTO mainUser;
    private UserDTO friendUser;
    private String message;

    public UserDTO getMainUser() {
        return mainUser;
    }

    public void setMainUser(UserDTO mainUser) {
        this.mainUser = mainUser;
    }

    public UserDTO getFriendUser() {
        return friendUser;
    }

    public void setFriendUser(UserDTO friendUser) {
        this.friendUser = friendUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
