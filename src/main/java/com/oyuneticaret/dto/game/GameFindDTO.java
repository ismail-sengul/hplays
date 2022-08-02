package com.oyuneticaret.dto.game;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GameFindDTO implements Serializable {

    private String name;
    private BigDecimal price;

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

}
