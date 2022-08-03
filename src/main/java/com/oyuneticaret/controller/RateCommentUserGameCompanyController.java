package com.oyuneticaret.controller;


import com.oyuneticaret.dto.ratecommentusergame.RateCommentGameCreateDTO;
import com.oyuneticaret.dto.ratecommentusergame.RateCommentGameUpdateDTO;
import com.oyuneticaret.dto.ratecommentusergamecompany.RateCommentGameCompanyCreateDTO;
import com.oyuneticaret.dto.ratecommentusergamecompany.RateCommentGameCompanyDTO;
import com.oyuneticaret.dto.ratecommentusergamecompany.RateCommentGameCompanyUpdateDTO;
import com.oyuneticaret.model.*;
import com.oyuneticaret.service.*;
import com.oyuneticaret.utils.RateCommentGameCompanyUtil;
import com.oyuneticaret.utils.RateCommentGameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ratecommentusergamecompany")
public class RateCommentUserGameCompanyController {

    @Autowired
    private RateCommentUserGameCompanyService rateCommentUserGameCompanyService;

    @Autowired
    private GameCompanyService gameCompanyService;

    @Autowired
    private UserService userService;

    private RateCommentGameCompanyUtil rateCommentGameCompanyUtil = new RateCommentGameCompanyUtil();

    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody RateCommentGameCompanyCreateDTO rateCommentGameCompanyCreateDTO){
        GameCompany gameCompany = gameCompanyService.findGameCompanyById(rateCommentGameCompanyCreateDTO.getGameCompanyId());
        User user = userService.findUserById(rateCommentGameCompanyCreateDTO.getUserId());

        if(gameCompany == null){
            throw new IllegalArgumentException("Oyun Şirketi bulunamadı.");
        }else if(user == null){
            throw new IllegalArgumentException("Kullanıcı bulunamadı");
        }else if(rateCommentGameCompanyCreateDTO.getRate() == null){
            throw new IllegalArgumentException("Değerlendirme puanı girilmedi.");
        }else if(rateCommentGameCompanyCreateDTO.getRate() > 5 || rateCommentGameCompanyCreateDTO.getRate() < 0){
            throw new IllegalArgumentException("Değerlendirme puanı 0 ile 5 arasında olmalıdır");
        }
        RateCommentUserGameCompany rateCommentUserGameCompany = new RateCommentUserGameCompany();
        rateCommentUserGameCompany.setGameCompany(gameCompany);
        rateCommentUserGameCompany.setUser(user);
        rateCommentUserGameCompany.setComment(rateCommentGameCompanyCreateDTO.getComment());
        rateCommentUserGameCompany.setRate(rateCommentGameCompanyCreateDTO.getRate());

        rateCommentUserGameCompanyService.save(rateCommentUserGameCompany);

        return ResponseEntity.ok(rateCommentGameCompanyUtil.createRateCommentGameCompanySuccessDTO(rateCommentUserGameCompany,
                "Ekleme İşlemi Başarılı."));
    }

    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public ResponseEntity<?> findRatesAndComments(@RequestParam(required = false) Long gameCompanyId,
                                                  @RequestParam(required = false) Long userId,
                                                  @RequestParam(required = false) Integer rate){
        List<RateCommentUserGameCompany> ratesAndComments = rateCommentUserGameCompanyService
                .findRatesAndComments(gameCompanyId,userId,rate);
        return ResponseEntity.ok(rateCommentGameCompanyUtil.createRateCommentGameCompanyFindSuccessDTO(ratesAndComments));
    }

    @RequestMapping(value = "/get?{id}",method = RequestMethod.GET)
    public ResponseEntity<?> findRateAndCommentById(@PathVariable(value = "id") Long id){
        RateCommentUserGameCompany rateCommentUserGameCompany = rateCommentUserGameCompanyService.findRatesAndCommentsById(id);

        if(rateCommentUserGameCompany == null){
            throw new IllegalArgumentException("Oyun Şirketi İçin Değerlendirme bulunamadı.");
        }
        return ResponseEntity.ok(rateCommentGameCompanyUtil
                .createRateCommentGameCompanySuccessDTO(rateCommentUserGameCompany,"İşlem Başarılı."));
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ResponseEntity<?> updateRateAndComment(@RequestBody RateCommentGameCompanyUpdateDTO rateCommentGameCompanyUpdateDTO){
        RateCommentUserGameCompany rateCommentUserGameCompany = rateCommentUserGameCompanyService
                .findRatesAndCommentsById(rateCommentGameCompanyUpdateDTO.getId());

        if(rateCommentUserGameCompany == null){
            throw new IllegalArgumentException("Oyun Şirketi İçin Değerlendirme bulunamadı.");
        }
        GameCompany gameCompany = gameCompanyService.findGameCompanyById(rateCommentGameCompanyUpdateDTO.getGameCompanyId());
        if(gameCompany != null){
            rateCommentUserGameCompany.setGameCompany(gameCompany);
        }

        User user = userService.findUserById(rateCommentGameCompanyUpdateDTO.getUserId());
        if(user != null){
            rateCommentUserGameCompany.setUser(user);
        }

        if(rateCommentGameCompanyUpdateDTO.getRate() != null){
            rateCommentUserGameCompany.setRate(rateCommentGameCompanyUpdateDTO.getRate());
        }
        if(rateCommentGameCompanyUpdateDTO.getComment() != null){
            rateCommentUserGameCompany.setComment(rateCommentGameCompanyUpdateDTO.getComment());
        }
        rateCommentUserGameCompanyService.save(rateCommentUserGameCompany);
        return ResponseEntity.ok(rateCommentGameCompanyUtil
                .createRateCommentGameCompanySuccessDTO(rateCommentUserGameCompany,"Güncelleme İşlemi Başarılı."));
    }

    //TODO ilk 5 satır util içerisinden çağırılabilir.
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRateAndComment(@RequestParam Long id){
        RateCommentUserGameCompany rateCommentUserGameCompany = rateCommentUserGameCompanyService.findRatesAndCommentsById(id);

        if(rateCommentUserGameCompany == null){
            throw new IllegalArgumentException("Oyun Şirketi İçin Değerlendirme bulunamadı.");
        }
        rateCommentUserGameCompanyService.delete(rateCommentUserGameCompany);
        return ResponseEntity.ok(rateCommentGameCompanyUtil
                .createRateCommentGameCompanySuccessDTO(rateCommentUserGameCompany,"Silme İşlemi Başarılı."));
    }

}
