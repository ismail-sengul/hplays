package com.oyuneticaret.dto.game;

import java.io.Serializable;

public class GameTypeCreateDTO implements Serializable {

    private Long gameId;
    private Long typeId;

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
}
