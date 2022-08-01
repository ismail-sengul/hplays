package com.oyuneticaret.dao;

import com.oyuneticaret.model.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public List<Game> findAllGames() {
        return getCurrentSession().createQuery("from Game").getResultList();
    }

    @Override
    public List<Game> findGamesByName(String name) {
        Query query = getCurrentSession().createQuery("from Game as T where T.name = :name ");
        return query.setParameter("name",name)
                .getResultList();
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
