package com.oyuneticaret.dao;

import com.oyuneticaret.dto.achievement.AchievementFindDTO;
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
    public List<Achievement> findAchievements(AchievementFindDTO achievementFindDao) {

        return null;
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
