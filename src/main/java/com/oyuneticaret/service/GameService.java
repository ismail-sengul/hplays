package com.oyuneticaret.service;

import com.oyuneticaret.dto.game.GameFindDTO;
import com.oyuneticaret.model.Game;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface GameService {
    void save(Game game);
    List<Game> findGames(String name,BigDecimal price,Long gameCompanyId);
    Game findGameById(Long id);
    void delete(Game game);
}
