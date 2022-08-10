package com.hplays.dto.game;

import com.hplays.dto.type.TypeDTO;

import java.io.Serializable;
import java.util.List;

public class GameTypeFindSuccessDTO implements Serializable {

    private GameDTO game;
    private List<TypeDTO> types;
    private String message;

    public GameDTO getGame() {
        return game;
    }

    public void setGame(GameDTO game) {
        this.game = game;
    }

    public List<TypeDTO> getTypes() {
        return types;
    }

    public void setTypes(List<TypeDTO> types) {
        this.types = types;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
