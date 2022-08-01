package com.oyuneticaret.service;

import com.oyuneticaret.dao.GameCompanyDao;
import com.oyuneticaret.model.GameCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GameCompanyServiceImpl implements GameCompanyService {

    @Autowired
    private GameCompanyDao gameCompanyDao;


    @Override
    @Transactional
    public void save(GameCompany gameCompany) {
        gameCompanyDao.save(gameCompany);
    }

    @Override
    @Transactional
    public List<GameCompany> findAllGameCompanies() {
        return gameCompanyDao.findAllGameCompanies();
    }

    @Override
    @Transactional
    public List<GameCompany> findGameCompaniesByName(String companyName) {
        return gameCompanyDao.findGameCompaniesByName(companyName);
    }

    @Override
    @Transactional
    public GameCompany findGameCompanyById(Long id) {
        return gameCompanyDao.findGameCompanyById(id);
    }

    @Override
    @Transactional
    public void delete(GameCompany gameCompany) {
        gameCompanyDao.delete(gameCompany);
    }
}
