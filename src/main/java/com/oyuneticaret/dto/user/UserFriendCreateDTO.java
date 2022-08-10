package com.oyuneticaret.dto.user;

import java.io.Serializable;

public class UserFriendCreateDTO implements Serializable {

    private Long userId;
    private Long friendId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }
}
