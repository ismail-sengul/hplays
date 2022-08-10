package com.hplays.dto.ratecommentusergamecompany;

import java.io.Serializable;
import java.util.List;

public class RateCommentGameCompanyFindSuccessDTO implements Serializable {

    private List<RateCommentGameCompanyDTO> ratesAndComments;
    private String message;

    public List<RateCommentGameCompanyDTO> getRatesAndComments() {
        return ratesAndComments;
    }

    public void setRatesAndComments(List<RateCommentGameCompanyDTO> ratesAndComments) {
        this.ratesAndComments = ratesAndComments;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
