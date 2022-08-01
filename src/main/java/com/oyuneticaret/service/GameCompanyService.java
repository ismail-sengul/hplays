package com.oyuneticaret.service;

import com.oyuneticaret.model.GameCompany;

import java.util.List;

public interface GameCompanyService {
    void save(GameCompany gameCompany);
    List<GameCompany> findAllGameCompanies();
    List<GameCompany> findGameCompaniesByName(String companyName);
    GameCompany findGameCompanyById(Long id);
    void delete(GameCompany gameCompany);
}
