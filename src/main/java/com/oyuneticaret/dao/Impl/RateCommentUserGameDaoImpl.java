package com.oyuneticaret.dao.Impl;

import com.oyuneticaret.dao.RateCommentUserGameDao;
import com.oyuneticaret.model.RateCommentUserGame;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RateCommentUserGameDaoImpl implements RateCommentUserGameDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(RateCommentUserGame rateCommentUserGame) {
        getCurrentSession().save(rateCommentUserGame);
    }

    @Override
    public List<RateCommentUserGame> findRatesAndComments(Long gameId, Long userId, Integer rate) {
        StringBuilder query = new StringBuilder("SELECT * FROM RATE_COMMENT_USER_GAME AS RC WHERE 1=1");

        if(gameId != null){
            query.append(" AND RC.GAME_ID = "+gameId);
        }
        if(userId != null){
            query.append(" AND RC.USER_ID = "+userId);
        }
        if(rate != null){
            query.append(" AND RC.RATE = "+rate);
        }

        return getCurrentSession().createNativeQuery(query.toString()).addEntity(RateCommentUserGame.class).getResultList();
    }

    @Override
    public RateCommentUserGame findRatesAndCommentsById(Long id) {
        return getCurrentSession().get(RateCommentUserGame.class,id);
    }

    @Override
    public void delete(RateCommentUserGame rateCommentUserGame) {
        getCurrentSession().delete(rateCommentUserGame);
    }
}
