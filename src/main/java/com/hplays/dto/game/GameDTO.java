package com.hplays.dto.game;

import com.hplays.dto.gamecompany.GameCompanyDTO;

import java.math.BigDecimal;
import java.util.Date;

public class GameDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private Date releaseDate;
    private GameCompanyDTO gameCompany;
    private String gameDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public GameCompanyDTO getGameCompany() {
        return gameCompany;
    }

    public void setGameCompany(GameCompanyDTO gameCompany) {
        this.gameCompany = gameCompany;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }
}
