package com.hplays.dao.Impl;

import com.hplays.dao.RateCommentUserGameCompanyDao;
import com.hplays.model.RateCommentUserGameCompany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RateCommentUserGameCompanyDaoImpl implements RateCommentUserGameCompanyDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(RateCommentUserGameCompany rateCommentUserGameCompany) {
        getCurrentSession().save(rateCommentUserGameCompany);
    }

    @Override
    public List<RateCommentUserGameCompany> findRatesAndComments(Long gameCompanyId, Long userId, Integer rate) {
        StringBuilder query = new StringBuilder("SELECT * FROM RATE_COMMENT_USER_GAME_COMPANY AS RC WHERE 1=1");

        if(gameCompanyId != null){
            query.append(" AND RC.GAME_COMPANY_ID = "+gameCompanyId);
        }
        if(userId != null){
            query.append(" AND RC.USER_ID = "+userId);
        }
        if(rate != null){
            query.append(" AND RC.RATE = "+rate);
        }

        return getCurrentSession().createNativeQuery(query.toString()).addEntity(RateCommentUserGameCompany.class).getResultList();
    }

    @Override
    public RateCommentUserGameCompany findRatesAndCommentsById(Long id) {
        return getCurrentSession().get(RateCommentUserGameCompany.class,id);
    }

    @Override
    public void delete(RateCommentUserGameCompany rateCommentUserGameCompany) {
        getCurrentSession().delete(rateCommentUserGameCompany);
    }
}
