package com.hplays.dto.game;

import com.hplays.dto.type.TypeDTO;

import java.io.Serializable;

public class GameTypeSuccessDTO implements Serializable {

    private GameDTO game;
    private TypeDTO type;
    private String message;

    public GameDTO getGame() {
        return game;
    }

    public void setGame(GameDTO game) {
        this.game = game;
    }

    public TypeDTO getType() {
        return type;
    }

    public void setType(TypeDTO type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
