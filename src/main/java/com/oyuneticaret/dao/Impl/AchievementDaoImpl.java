package com.oyuneticaret.dao.Impl;

import com.oyuneticaret.dao.AchievementDao;
import com.oyuneticaret.model.Achievement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AchievementDaoImpl implements AchievementDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Achievement achievement) {
        getCurrentSession().save(achievement);
    }

    //TODO gameId ile nasıl bağlayacağım?
    @Override
    public List<Achievement> findAchievements(String name, Long gameId) {
        StringBuilder query = new StringBuilder("SELECT * FROM ACHIEVEMENT AS A");

        if(name != null || gameId != null){
            query.append(" WHERE 1=1");
            if(name !=null){
                query.append(" AND A.NAME = '"+name+"'");
            }
            if(gameId != null){
                query.append(" AND A.GAME_ID = "+gameId);
            }

        }
        return getCurrentSession().createNativeQuery(query.toString()).getResultList();
    }

    @Override
    public Achievement findAchievementById(Long id) {
        return getCurrentSession().get(Achievement.class,id);
    }

    @Override
    public void delete(Achievement achievement) {
        getCurrentSession().delete(achievement);
    }
}
