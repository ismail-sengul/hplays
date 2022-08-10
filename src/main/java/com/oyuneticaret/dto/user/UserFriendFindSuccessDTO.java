package com.oyuneticaret.dto.user;

import java.io.Serializable;
import java.util.List;

public class UserFriendFindSuccessDTO implements Serializable {

    private UserDTO user;
    private List<UserDTO> friends;
    private String message;

    public List<UserDTO> getFriends() {
        return friends;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public void setFriends(List<UserDTO> friends) {
        this.friends = friends;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
