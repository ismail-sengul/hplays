package com.hplays.dto.achievement;

import java.io.Serializable;

public class AchievementCreateDTO implements Serializable {

    private Long gameId;
    private String name;

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
