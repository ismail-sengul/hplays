package com.hplays.dto.ratecommentusergamecompany;

import com.hplays.dto.gamecompany.GameCompanyDTO;
import com.hplays.dto.user.UserDTO;

import java.io.Serializable;

public class RateCommentGameCompanySuccessDTO implements Serializable {

    private Long id;
    private UserDTO user;
    private GameCompanyDTO gameCompany;
    private Integer rate;
    private String comment;
    private String message;

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

    public GameCompanyDTO getGameCompany() {
        return gameCompany;
    }

    public void setGameCompany(GameCompanyDTO gameCompany) {
        this.gameCompany = gameCompany;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
