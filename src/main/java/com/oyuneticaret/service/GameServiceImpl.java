package com.oyuneticaret.service;

import com.oyuneticaret.dao.GameDao;
import com.oyuneticaret.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameDao gameDao;

    @Override
    @Transactional
    public void save(Game game) {
        gameDao.save(game);
    }

    @Override
    @Transactional
    public List<Game> findAllGames() {
        return gameDao.findAllGames();
    }

    @Override
    @Transactional
    public List<Game> findGamesByName(String name) {
        return gameDao.findGamesByName(name);
    }

    @Override
    @Transactional
    public Game findGameById(Long id) {
        return gameDao.findGameById(id);
    }

    @Override
    @Transactional
    public void delete(Game game) {
        gameDao.delete(game);
    }
}
