package com.oyuneticaret.dto.gamecompany;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;

public class GameCompanyCreateDTO implements Serializable {

    private String companyName;
    private Date foundationYear;
    private String companyDescription;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(Date foundationYear) {
        this.foundationYear = foundationYear;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }
}
