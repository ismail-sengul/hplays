package com.oyuneticaret.dao.Impl;

import com.oyuneticaret.dao.GameDao;
import com.oyuneticaret.model.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class GameDaoImpl implements GameDao {

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
    public List<Game> findGames(String name, BigDecimal price, Long gameCompanyId) {
        StringBuilder query = new StringBuilder("SELECT * FROM GAME AS G WHERE 1=1");
        if(name != null){
            query.append(" AND G.NAME LIKE '"+name+"%'");
        }
        if(price != null){
            query.append(" AND G.PRICE = "+price);
        }
        if(gameCompanyId != null){
            query.append(" AND G.GAME_COMPANY_ID = "+gameCompanyId);
        }

        return getCurrentSession().createNativeQuery(query.toString()).addEntity(Game.class).getResultList();
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
