package com.oyuneticaret.service;

import com.oyuneticaret.model.Game;

import java.util.List;

public interface GameService {
    void save(Game game);
    List<Game> findAllGames();
    List<Game> findGamesByName(String name);
    Game findGameById(Long id);
    void delete(Game game);
}
