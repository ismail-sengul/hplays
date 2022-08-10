package com.hplays.dto.user;

import java.io.Serializable;

public class GameBasketDTO implements Serializable {

    private Long userId;
    private Long gameId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
}
