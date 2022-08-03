package com.oyuneticaret.dto.ratecommentusergamecompany;

public class RateCommentGameCompanyUpdateDTO {

    private Long id;
    private Long gameCompanyId;
    private Long userId;
    private Integer rate;
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGameCompanyId() {
        return gameCompanyId;
    }

    public void setGameCompanyId(Long gameCompanyId) {
        this.gameCompanyId = gameCompanyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
