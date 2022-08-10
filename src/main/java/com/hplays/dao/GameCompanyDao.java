package com.hplays.dao;

import com.hplays.model.GameCompany;

import java.util.List;

public interface GameCompanyDao {
    void save(GameCompany gameCompany);
    List<GameCompany> findAllGameCompanies();
    List<GameCompany> findGameCompaniesByName(String companyName);
    GameCompany findGameCompanyById(Long id);
    void delete(GameCompany gameCompany);
}
