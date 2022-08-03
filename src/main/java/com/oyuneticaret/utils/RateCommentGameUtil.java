package com.oyuneticaret.utils;

import com.oyuneticaret.dto.ratecommentusergame.RateCommentGameDTO;
import com.oyuneticaret.dto.ratecommentusergame.RateCommentGameFindSuccessDTO;
import com.oyuneticaret.dto.ratecommentusergame.RateCommentGameSuccessDTO;
import com.oyuneticaret.model.RateCommentUserGame;

import java.util.ArrayList;
import java.util.List;

public class RateCommentGameUtil {

    private GameUtil gameUtil = new GameUtil();
    private UserUtil userUtil = new UserUtil();

    public RateCommentGameSuccessDTO createRateCommentGameSuccessDTO(RateCommentUserGame rateCommentUserGame,
                                                                        String message){
        RateCommentGameSuccessDTO rateCommentGameSuccessDTO = new RateCommentGameSuccessDTO();
        rateCommentGameSuccessDTO.setComment(rateCommentUserGame.getComment());
        rateCommentGameSuccessDTO.setGame(gameUtil.convertGameDTO(rateCommentUserGame.getGame()));
        rateCommentGameSuccessDTO.setUser(userUtil.convertUserDTO(rateCommentUserGame.getUser()));
        rateCommentGameSuccessDTO.setRate(rateCommentUserGame.getRate());
        rateCommentGameSuccessDTO.setMessage(message);

        return rateCommentGameSuccessDTO;
    }

    public RateCommentGameFindSuccessDTO createRateCommentGameFindSuccessDTO(List<RateCommentUserGame> ratesAndComments){
        RateCommentGameFindSuccessDTO rateCommentGameFindSuccessDTO = new RateCommentGameFindSuccessDTO();
        List<RateCommentGameDTO> rateCommentGameDTOS = new ArrayList<>();
        for (RateCommentUserGame rateCommentUserGame:ratesAndComments){
            RateCommentGameDTO rateCommentGameDTO = new RateCommentGameDTO();
            rateCommentGameDTO.setComment(rateCommentUserGame.getComment());
            rateCommentGameDTO.setRate(rateCommentUserGame.getRate());
            rateCommentGameDTO.setGame(gameUtil.convertGameDTO(rateCommentUserGame.getGame()));
            rateCommentGameDTO.setUser(userUtil.convertUserDTO(rateCommentUserGame.getUser()));
            rateCommentGameDTOS.add(rateCommentGameDTO);
        }
        rateCommentGameFindSuccessDTO.setRatesAndComments(rateCommentGameDTOS);
        rateCommentGameFindSuccessDTO.setMessage("Listeleme İşlemi Başarılı.");
        return rateCommentGameFindSuccessDTO;
    }

}
