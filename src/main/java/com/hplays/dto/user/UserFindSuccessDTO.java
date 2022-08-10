package com.hplays.dto.user;

import java.io.Serializable;
import java.util.List;

public class UserFindSuccessDTO implements Serializable {

    private List<UserDTO> users;
    private String message;

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
