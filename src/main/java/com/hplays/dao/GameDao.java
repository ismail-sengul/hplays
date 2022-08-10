package com.hplays.dao;

import com.hplays.model.Game;

import java.math.BigDecimal;
import java.util.List;

public interface GameDao {
    void save(Game game);
    List<Game> findGames(String name,BigDecimal price,Long gameCompanyId);
    Game findGameById(Long id);
    void delete(Game game);
}
