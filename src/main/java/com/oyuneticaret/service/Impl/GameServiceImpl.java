package com.oyuneticaret.service.Impl;

import com.oyuneticaret.dao.GameDao;
import com.oyuneticaret.dto.game.GameFindDTO;
import com.oyuneticaret.model.Game;
import com.oyuneticaret.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
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
    public List<Game> findGames(String name, BigDecimal price, Long gameCompanyId) {
        return gameDao.findGames(name,price,gameCompanyId);
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
