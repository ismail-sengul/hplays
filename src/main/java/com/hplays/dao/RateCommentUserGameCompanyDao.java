package com.hplays.dao;

import com.hplays.model.RateCommentUserGameCompany;

import java.util.List;

public interface RateCommentUserGameCompanyDao {

    void save(RateCommentUserGameCompany rateCommentUserGameCompany);
    List<RateCommentUserGameCompany> findRatesAndComments(Long gameCompanyId, Long userId, Integer rate);
    RateCommentUserGameCompany findRatesAndCommentsById(Long id);
    void delete(RateCommentUserGameCompany rateCommentUserGameCompany);

}
