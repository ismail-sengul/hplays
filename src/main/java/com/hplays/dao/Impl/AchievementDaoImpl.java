package com.hplays.dao.Impl;

import com.hplays.dao.AchievementDao;
import com.hplays.model.Achievement;
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
    public Achievement save(Achievement achievement) {
        getCurrentSession().save(achievement);
        return achievement;
    }

    @Override
    public List<Achievement> findAchievements(String name, Long gameId) {
        StringBuilder query = new StringBuilder("SELECT * FROM ACHIEVEMENT AS A");

        if(name != null || gameId != null){
            query.append(" WHERE 1=1");
            if(name !=null){
                query.append(" AND A.NAME LIKE '%"+name+"%'");
            }
            if(gameId != null){
                query.append(" AND A.GAME_ID = "+gameId);
            }

        }
        return getCurrentSession().createNativeQuery(query.toString()).addEntity(Achievement.class).getResultList();
    }

    @Override
    public Achievement findAchievementById(Long id) {
        return getCurrentSession().get(Achievement.class,id);
    }

    @Override
    public Achievement delete(Achievement achievement) {
        getCurrentSession().delete(achievement);
        return achievement;
    }
}
