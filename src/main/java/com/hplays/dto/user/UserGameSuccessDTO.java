package com.hplays.dto.user;

import com.hplays.dto.game.GameDTO;

public class UserGameSuccessDTO {

    private UserDTO user;
    private GameDTO game;
    private String message;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public GameDTO getGame() {
        return game;
    }

    public void setGame(GameDTO game) {
        this.game = game;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
