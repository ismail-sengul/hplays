package com.hplays.service;

import com.hplays.model.RateCommentUserGame;

import java.util.List;

public interface RateCommentUserGameService {

    void save(RateCommentUserGame rateCommentUserGame);
    List<RateCommentUserGame> findRatesAndComments(Long gameId, Long userId, Integer rate);
    RateCommentUserGame findRatesAndCommentsById(Long id);
    void delete(RateCommentUserGame rateCommentUserGame);
}
