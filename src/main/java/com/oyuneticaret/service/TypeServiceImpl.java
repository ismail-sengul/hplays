package com.oyuneticaret.service;

import com.oyuneticaret.dao.TypeDao;
import com.oyuneticaret.model.Types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    @Qualifier(value = "typeDaoImpl")
    private TypeDao typeDao;

    @Override
    @Transactional
    public void save(Types types) {
        typeDao.save(types);
    }

    @Override
    @Transactional
    public List<Types> listTypes() {
       return typeDao.listTypes();
    }

    @Override
    @Transactional
    public Types listTypesById(Long id) {
        return typeDao.listTypesById(id);
    }

    @Override
    @Transactional
    public List<Types> listTypesByName(String name) {
        return typeDao.listTypesByName(name);
    }

    @Override
    @Transactional
    public void delete(Types type) {
        typeDao.delete(type);
    }
}
