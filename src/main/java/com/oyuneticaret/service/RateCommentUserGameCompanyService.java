package com.oyuneticaret.service;

import com.oyuneticaret.model.RateCommentUserGameCompany;

import java.util.List;

public interface RateCommentUserGameCompanyService {

    void save(RateCommentUserGameCompany rateCommentUserGameCompany);
    List<RateCommentUserGameCompany> findRatesAndComments(Long gameCompanyId, Long userId, Integer rate);
    RateCommentUserGameCompany findRatesAndCommentsById(Long id);
    void delete(RateCommentUserGameCompany rateCommentUserGameCompany);
}
