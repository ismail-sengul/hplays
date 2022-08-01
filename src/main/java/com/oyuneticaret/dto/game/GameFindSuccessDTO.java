package com.oyuneticaret.dto.game;

import java.util.List;

public class GameFindSuccessDTO {

    private List<GameDTO> games;
    private String message;

    public List<GameDTO> getGames() {
        return games;
    }

    public void setGames(List<GameDTO> games) {
        this.games = games;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
