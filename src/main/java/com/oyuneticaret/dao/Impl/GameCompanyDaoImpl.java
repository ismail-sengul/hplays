package com.oyuneticaret.dao.Impl;

import com.oyuneticaret.dao.GameCompanyDao;
import com.oyuneticaret.model.GameCompany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GameCompanyDaoImpl implements GameCompanyDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(GameCompany gameCompany) {
        getCurrentSession().save(gameCompany);
    }

    @Override
    public List<GameCompany> findAllGameCompanies() {
        return getCurrentSession().createQuery("from GameCompany").getResultList();
    }

    @Override
    public List<GameCompany> findGameCompaniesByName(String companyName) {
        Query query = getCurrentSession().createQuery("from GameCompany as G where G.companyName like :companyName");
        return query.setParameter("companyName","%"+companyName+"%").getResultList();
    }

    @Override
    public GameCompany findGameCompanyById(Long id) {
        return getCurrentSession().get(GameCompany.class,id);
    }

    @Override
    public void delete(GameCompany gameCompany) {
        getCurrentSession().delete(gameCompany);
    }
}
