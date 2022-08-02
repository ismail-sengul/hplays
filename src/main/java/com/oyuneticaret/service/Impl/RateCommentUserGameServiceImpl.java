package com.oyuneticaret.service.Impl;

import com.oyuneticaret.dao.RateCommentUserGameDao;
import com.oyuneticaret.model.RateCommentUserGame;
import com.oyuneticaret.service.RateCommentUserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RateCommentUserGameServiceImpl implements RateCommentUserGameService {

    @Autowired
    RateCommentUserGameDao rateCommentUserGameDao;

    @Override
    @Transactional
    public void save(RateCommentUserGame rateCommentUserGame) {
        rateCommentUserGameDao.save(rateCommentUserGame);
    }

    @Override
    public List<RateCommentUserGame> findRatesAndComments(Long gameId, Long userId, Integer rate) {
        return rateCommentUserGameDao.findRatesAndComments(gameId,userId,rate);
    }

    @Override
    public RateCommentUserGame findRatesAndCommentsById(Long id) {
        return rateCommentUserGameDao.findRatesAndCommentsById(id);
    }

    @Override
    @Transactional
    public void delete(RateCommentUserGame rateCommentUserGame) {
        rateCommentUserGameDao.delete(rateCommentUserGame);
    }
}
