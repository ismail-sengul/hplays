package com.oyuneticaret.dto.game;

import com.oyuneticaret.dto.gamecompany.GameCompanyDTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GameCreateDTO implements Serializable {

    private String name;
    private BigDecimal price;
    private Date releaseDate;
    private Long gameCompanyId;
    private String gameDescription;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getGameCompanyId() {
        return gameCompanyId;
    }

    public void setGameCompanyId(Long gameCompanyId) {
        this.gameCompanyId = gameCompanyId;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }
}
