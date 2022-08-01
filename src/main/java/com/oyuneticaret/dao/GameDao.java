package com.oyuneticaret.dao;

import com.oyuneticaret.model.Game;

import java.util.List;

public interface GameDao {
    void save(Game game);
    List<Game> findAllGames();
    List<Game> findGamesByName(String name);
    Game findGameById(Long id);
    void delete(Game game);
}
