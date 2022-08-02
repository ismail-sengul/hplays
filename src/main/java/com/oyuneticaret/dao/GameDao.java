package com.oyuneticaret.dao;

import com.oyuneticaret.dto.game.GameFindDTO;
import com.oyuneticaret.model.Game;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface GameDao {
    void save(Game game);
    List<Game> findGames(GameFindDTO gameFindDTO);
    Game findGameById(Long id);
    void delete(Game game);
}
