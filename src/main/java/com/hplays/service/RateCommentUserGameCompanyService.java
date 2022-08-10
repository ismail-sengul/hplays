package com.hplays.service;

import com.hplays.model.RateCommentUserGameCompany;

import java.util.List;

public interface RateCommentUserGameCompanyService {

    void save(RateCommentUserGameCompany rateCommentUserGameCompany);
    List<RateCommentUserGameCompany> findRatesAndComments(Long gameCompanyId, Long userId, Integer rate);
    RateCommentUserGameCompany findRatesAndCommentsById(Long id);
    void delete(RateCommentUserGameCompany rateCommentUserGameCompany);
}
