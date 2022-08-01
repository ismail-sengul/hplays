package com.oyuneticaret.dto.gamecompany;

import java.io.Serializable;
import java.util.List;

public class GameCompanyFindSuccessDTO implements Serializable {

    private List<GameCompanyDTO> gameCompanies;
    private String message;

    public List<GameCompanyDTO> getGameCompanies() {
        return gameCompanies;
    }

    public void setGameCompanies(List<GameCompanyDTO> gameCompanies) {
        this.gameCompanies = gameCompanies;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
