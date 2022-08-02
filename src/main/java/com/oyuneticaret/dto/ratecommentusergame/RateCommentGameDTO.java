package com.oyuneticaret.dto.ratecommentusergame;

import com.oyuneticaret.dto.game.GameDTO;
import com.oyuneticaret.dto.user.UserDTO;

import java.io.Serializable;

public class RateCommentGameDTO implements Serializable {
    private Long id;
    private UserDTO user;
    private GameDTO game;
    private Integer rate;
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
