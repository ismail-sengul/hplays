package com.oyuneticaret.utils;

import com.oyuneticaret.dto.ratecommentusergamecompany.RateCommentGameCompanyDTO;
import com.oyuneticaret.dto.ratecommentusergamecompany.RateCommentGameCompanyFindSuccessDTO;
import com.oyuneticaret.dto.ratecommentusergamecompany.RateCommentGameCompanySuccessDTO;
import com.oyuneticaret.model.RateCommentUserGameCompany;

import java.util.ArrayList;
import java.util.List;

public class RateCommentGameCompanyUtil {

    private GameCompanyUtil gameCompanyUtil = new GameCompanyUtil();
    private UserUtil userUtil = new UserUtil();

    public RateCommentGameCompanySuccessDTO createRateCommentGameCompanySuccessDTO(RateCommentUserGameCompany rateCommentUserGameCompany,
                                                                     String message){
        RateCommentGameCompanySuccessDTO rateCommentGameCompanySuccessDTO = new RateCommentGameCompanySuccessDTO();
        rateCommentGameCompanySuccessDTO.setComment(rateCommentUserGameCompany.getComment());
        rateCommentGameCompanySuccessDTO.setGameCompany(gameCompanyUtil.convertGameCompanyDTO(rateCommentUserGameCompany.getGameCompany()));
        rateCommentGameCompanySuccessDTO.setUser(userUtil.convertUserDTO(rateCommentUserGameCompany.getUser()));
        rateCommentGameCompanySuccessDTO.setRate(rateCommentUserGameCompany.getRate());
        rateCommentGameCompanySuccessDTO.setMessage(message);

        return rateCommentGameCompanySuccessDTO;
    }

    public RateCommentGameCompanyFindSuccessDTO createRateCommentGameCompanyFindSuccessDTO(List<RateCommentUserGameCompany> ratesAndComments){
        RateCommentGameCompanyFindSuccessDTO rateCommentGameCompanyFindSuccessDTO = new RateCommentGameCompanyFindSuccessDTO();
        List<RateCommentGameCompanyDTO> rateCommentGameCompanyDTOS = new ArrayList<>();
        for (RateCommentUserGameCompany rateCommentUserGame:ratesAndComments){
            RateCommentGameCompanyDTO rateCommentGameCompanyDTO = new RateCommentGameCompanyDTO();
            rateCommentGameCompanyDTO.setComment(rateCommentUserGame.getComment());
            rateCommentGameCompanyDTO.setRate(rateCommentUserGame.getRate());
            rateCommentGameCompanyDTO.setGameCompany(gameCompanyUtil.convertGameCompanyDTO(rateCommentUserGame.getGameCompany()));
            rateCommentGameCompanyDTO.setUser(userUtil.convertUserDTO(rateCommentUserGame.getUser()));
            rateCommentGameCompanyDTOS.add(rateCommentGameCompanyDTO);
        }
        rateCommentGameCompanyFindSuccessDTO.setRatesAndComments(rateCommentGameCompanyDTOS);
        rateCommentGameCompanyFindSuccessDTO.setMessage("Listeleme İşlemi Başarılı.");
        return rateCommentGameCompanyFindSuccessDTO;
    }
}
