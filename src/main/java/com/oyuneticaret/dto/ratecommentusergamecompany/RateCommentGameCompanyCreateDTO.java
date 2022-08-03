package com.oyuneticaret.dto.ratecommentusergamecompany;

import java.io.Serializable;

public class RateCommentGameCompanyCreateDTO implements Serializable {

    private Long userId;
    private Long gameCompanyId;
    private Integer rate;
    private String comment;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGameCompanyId() {
        return gameCompanyId;
    }

    public void setGameCompanyId(Long gameCompanyId) {
        this.gameCompanyId = gameCompanyId;
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
