package com.hplays.service.Impl;

import com.hplays.dao.RateCommentUserGameDao;
import com.hplays.model.RateCommentUserGame;
import com.hplays.service.RateCommentUserGameService;
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
