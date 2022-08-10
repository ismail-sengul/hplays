package com.hplays.dto.gamecompany;

import java.io.Serializable;
import java.util.Date;

public class GameCompanyUpdateDTO implements Serializable {

    private Long id;
    private String companyName;
    private Date foundationYear;
    private String companyDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
