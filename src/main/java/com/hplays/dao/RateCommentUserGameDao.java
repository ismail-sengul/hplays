package com.hplays.dao;

import com.hplays.model.RateCommentUserGame;

import java.util.List;

public interface RateCommentUserGameDao {

    void save(RateCommentUserGame rateCommentUserGame);
    List<RateCommentUserGame> findRatesAndComments(Long gameId,Long userId,Integer rate);
    RateCommentUserGame findRatesAndCommentsById(Long id);
    void delete(RateCommentUserGame rateCommentUserGame);

}
