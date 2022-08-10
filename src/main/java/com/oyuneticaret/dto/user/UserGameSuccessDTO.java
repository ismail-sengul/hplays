package com.oyuneticaret.dto.user;

import com.oyuneticaret.dto.game.GameDTO;
import com.oyuneticaret.dto.user.UserDTO;

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
