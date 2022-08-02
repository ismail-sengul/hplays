package com.oyuneticaret.dto.ratecommentusergame;

import java.io.Serializable;
import java.util.List;

public class RateCommentGameFindSuccessDTO implements Serializable {

    private List<RateCommentGameDTO> ratesAndComments;
    private String message;

    public List<RateCommentGameDTO> getRatesAndComments() {
        return ratesAndComments;
    }

    public void setRatesAndComments(List<RateCommentGameDTO> ratesAndComments) {
        this.ratesAndComments = ratesAndComments;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
