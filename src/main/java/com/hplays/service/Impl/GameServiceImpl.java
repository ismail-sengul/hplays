package com.hplays.service.Impl;

import com.hplays.dao.GameDao;
import com.hplays.model.Game;
import com.hplays.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
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
