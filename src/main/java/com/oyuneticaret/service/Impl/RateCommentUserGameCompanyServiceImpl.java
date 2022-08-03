package com.oyuneticaret.service.Impl;

import com.oyuneticaret.dao.RateCommentUserGameCompanyDao;
import com.oyuneticaret.dao.RateCommentUserGameDao;
import com.oyuneticaret.model.RateCommentUserGame;
import com.oyuneticaret.model.RateCommentUserGameCompany;
import com.oyuneticaret.service.RateCommentUserGameCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RateCommentUserGameCompanyServiceImpl implements RateCommentUserGameCompanyService {


    @Autowired
    RateCommentUserGameCompanyDao rateCommentUserGameCompanyDao;

    @Override
    @Transactional
    public void save(RateCommentUserGameCompany rateCommentUserGameCompany) {
        rateCommentUserGameCompanyDao.save(rateCommentUserGameCompany);
    }

    @Override
    public List<RateCommentUserGameCompany> findRatesAndComments(Long gameCompanyId, Long userId, Integer rate) {
        return rateCommentUserGameCompanyDao.findRatesAndComments(gameCompanyId,userId,rate);
    }

    @Override
    public RateCommentUserGameCompany findRatesAndCommentsById(Long id) {
        return rateCommentUserGameCompanyDao.findRatesAndCommentsById(id);
    }

    @Override
    @Transactional
    public void delete(RateCommentUserGameCompany rateCommentUserGameCompany) {
        rateCommentUserGameCompanyDao.delete(rateCommentUserGameCompany);
    }
}
