package com.oyuneticaret.dao.Impl;

import com.oyuneticaret.dao.TypeDao;
import com.oyuneticaret.model.Types;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TypeDaoImpl implements TypeDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void save(Types types) {
        getCurrentSession().save(types);
    }

    @Override
    public List<Types> listTypes() {
        return getCurrentSession().createQuery("from Types").getResultList();
    }

    @Override
    public Types listTypesById(Long id) {
        return getCurrentSession().get(Types.class,id);
    }

    @Override
    public List<Types> listTypesByName(String name) {
        Query query = getCurrentSession().createQuery("from Types as T where T.name = :name ");
        return query.setParameter("name",name)
                    .getResultList();
    }

    @Override
    public void delete(Types type) {
        getCurrentSession().delete(type);
    }

}
