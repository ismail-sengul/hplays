package com.hplays.controller;

import com.hplays.dto.ratecommentusergame.RateCommentGameCreateDTO;
import com.hplays.dto.ratecommentusergame.RateCommentGameUpdateDTO;
import com.hplays.model.Game;
import com.hplays.model.RateCommentUserGame;
import com.hplays.model.User;
import com.hplays.service.GameService;
import com.hplays.service.RateCommentUserGameService;
import com.hplays.service.UserService;
import com.hplays.utils.RateCommentGameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratecommentusergame")
public class RateCommentUserGameController {

    @Autowired
    private RateCommentUserGameService rateCommentUserGameService;

    @Autowired
    private GameService gameService;

    @Autowired
    private UserService userService;

    private RateCommentGameUtil rateCommentGameUtil = new RateCommentGameUtil();

    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody RateCommentGameCreateDTO rateCommentGameCreateDTO){
        Game game = gameService.findGameById(rateCommentGameCreateDTO.getGameId());
        User user = userService.findUserById(rateCommentGameCreateDTO.getUserId());

        if(game == null){
            throw new IllegalArgumentException("Oyun bulunamadı.");
        }else if(user == null){
            throw new IllegalArgumentException("Kullanıcı bulunamadı");
        }else if(rateCommentGameCreateDTO.getRate() == null){
            throw new IllegalArgumentException("Değerlendirme puanı girilmedi.");
        }else if(rateCommentGameCreateDTO.getRate() > 5 || rateCommentGameCreateDTO.getRate() < 0){
            throw new IllegalArgumentException("Değerlendirme puanı 0 ile 5 arasında olmalıdır");
        }
        RateCommentUserGame rateCommentUserGame = new RateCommentUserGame();
        rateCommentUserGame.setGame(game);
        rateCommentUserGame.setUser(user);
        rateCommentUserGame.setComment(rateCommentGameCreateDTO.getComment());
        rateCommentUserGame.setRate(rateCommentGameCreateDTO.getRate());

        rateCommentUserGameService.save(rateCommentUserGame);

        return ResponseEntity.ok(rateCommentGameUtil.createRateCommentGameSuccessDTO(rateCommentUserGame,
                "Ekleme İşlemi Başarılı."));
    }

    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public ResponseEntity<?> findRatesAndComments(@RequestParam(required = false) Long gameId,
                                                  @RequestParam(required = false) Long userId,
                                                  @RequestParam(required = false) Integer rate){
        List<RateCommentUserGame> ratesAndComments = rateCommentUserGameService
                .findRatesAndComments(gameId,userId,rate);
        return ResponseEntity.ok(rateCommentGameUtil.createRateCommentGameFindSuccessDTO(ratesAndComments));
    }

    @RequestMapping(value = "/get?{id}",method = RequestMethod.GET)
    public ResponseEntity<?> findRateAndCommentById(@PathVariable(value = "id") Long id){
        RateCommentUserGame rateCommentUserGame = rateCommentUserGameService.findRatesAndCommentsById(id);

        if(rateCommentUserGame == null){
            throw new IllegalArgumentException("Oyun İçin Değerlendirme bulunamadı.");
        }
        return ResponseEntity.ok(rateCommentGameUtil
                .createRateCommentGameSuccessDTO(rateCommentUserGame,"İşlem Başarılı."));
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ResponseEntity<?> updateRateAndComment(@RequestBody RateCommentGameUpdateDTO rateCommentGameUpdateDTO){
        RateCommentUserGame rateCommentUserGame = rateCommentUserGameService
                .findRatesAndCommentsById(rateCommentGameUpdateDTO.getId());

        if(rateCommentUserGame == null){
            throw new IllegalArgumentException("Oyun İçin Değerlendirme bulunamadı.");
        }
        Game game = gameService.findGameById(rateCommentGameUpdateDTO.getGameId());
        if(game != null){
            rateCommentUserGame.setGame(game);
        }

        User user = userService.findUserById(rateCommentGameUpdateDTO.getUserId());
        if(user != null){
            rateCommentUserGame.setUser(user);
        }

        if(rateCommentGameUpdateDTO.getRate() != null){
            rateCommentUserGame.setRate(rateCommentGameUpdateDTO.getRate());
        }
        if(rateCommentGameUpdateDTO.getComment() != null){
            rateCommentUserGame.setComment(rateCommentGameUpdateDTO.getComment());
        }
        rateCommentUserGameService.save(rateCommentUserGame);
        return ResponseEntity.ok(rateCommentGameUtil
                .createRateCommentGameSuccessDTO(rateCommentUserGame,"Güncelleme İşlemi Başarılı."));
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRateAndComment(@RequestParam Long id){
        RateCommentUserGame rateCommentUserGame = rateCommentUserGameService.findRatesAndCommentsById(id);

        if(rateCommentUserGame == null){
            throw new IllegalArgumentException("Oyun İçin Değerlendirme bulunamadı.");
        }
        rateCommentUserGameService.delete(rateCommentUserGame);
        return ResponseEntity.ok(rateCommentGameUtil
                .createRateCommentGameSuccessDTO(rateCommentUserGame,"Silme İşlemi Başarılı."));
    }
}
