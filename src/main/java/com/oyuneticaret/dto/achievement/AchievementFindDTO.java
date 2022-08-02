package com.oyuneticaret.dto.achievement;


import java.io.Serializable;

public class AchievementFindDTO implements Serializable {

    private String name;
    private Long gameId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
}
