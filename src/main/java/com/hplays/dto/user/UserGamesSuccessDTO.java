package com.hplays.dto.user;

import com.hplays.dto.game.GameDTO;

import java.io.Serializable;
import java.util.List;

public class UserGamesSuccessDTO implements Serializable {

    private UserDTO user;
    private List<GameDTO> games;
    private String message;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

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
