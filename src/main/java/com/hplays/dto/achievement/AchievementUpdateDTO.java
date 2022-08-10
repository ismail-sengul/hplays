package com.hplays.dto.achievement;

import java.io.Serializable;

public class AchievementUpdateDTO implements Serializable {

    private Long id;
    private Long gameId;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
