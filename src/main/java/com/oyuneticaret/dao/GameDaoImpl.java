package com.oyuneticaret.dao;

import com.oyuneticaret.dto.game.GameFindDTO;
import com.oyuneticaret.model.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public class GameDaoImpl implements GameDao{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Game game) {
        getCurrentSession().save(game);
    }

    @Override
    public List<Game> findGames(GameFindDTO gameFindDTO) {
        StringBuilder query = new StringBuilder("from Game as G");
        if(gameFindDTO.getName()!= null || gameFindDTO.getPrice() != null){
            query.append(" where ");

            if(gameFindDTO.getName()!= null){
                query.append("G.name = '"+gameFindDTO.getName()+"'");
            }
            if(gameFindDTO.getPrice()!= null){
                query.append(" G.price = "+gameFindDTO.getPrice());
            }
        }
        return getCurrentSession().createQuery(query.toString()).getResultList();
    }


    @Override
    public Game findGameById(Long id) {
        return getCurrentSession().get(Game.class,id);
    }

    @Override
    public void delete(Game game) {
        getCurrentSession().delete(game);
    }
}
