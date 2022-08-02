package com.oyuneticaret.dto.achievement;

import com.oyuneticaret.dto.game.GameDTO;

import java.io.Serializable;

public class AchievementDTO implements Serializable {

    private Long id;
    private GameDTO gameDTO;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GameDTO getGameDTO() {
        return gameDTO;
    }

    public void setGameDTO(GameDTO gameDTO) {
        this.gameDTO = gameDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
