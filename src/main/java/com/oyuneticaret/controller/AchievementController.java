package com.oyuneticaret.controller;

import com.oyuneticaret.dto.achievement.AchievementCreateDTO;
import com.oyuneticaret.dto.achievement.AchievementDTO;
import com.oyuneticaret.dto.achievement.AchievementSuccessDTO;
import com.oyuneticaret.dto.achievement.AchievementUpdateDTO;
import com.oyuneticaret.model.Achievement;
import com.oyuneticaret.model.Game;
import com.oyuneticaret.service.AchievementService;
import com.oyuneticaret.service.GameService;
import com.oyuneticaret.utils.AchievementUtil;
import com.oyuneticaret.utils.GameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/achievement")
public class AchievementController {

    @Autowired
    AchievementService achievementService;

    @Autowired
    GameService gameService;

    AchievementUtil achievementUtil = new AchievementUtil();

    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody AchievementCreateDTO achievementCreateDTO){
        Game game = gameService.findGameById(achievementCreateDTO.getGameId());

        if(game == null){
            throw new IllegalArgumentException("Oyun bulunamadı.");
        }else if(achievementCreateDTO.getName() == null){
            throw new IllegalArgumentException("Başarım adı boş olamaz.");
        }
        Achievement achievement = new Achievement();
        achievement.setGame(game);
        achievement.setName(achievementCreateDTO.getName());

        achievementService.save(achievement);

        return ResponseEntity.ok(achievementUtil.createAchievementSuccessDTO(achievement,"Ekleme işlemi başarılı."));
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<?> findAchievements(@RequestParam(required = false) String name,
                                              @RequestParam(required = false) Long gameId){
        List<Achievement> achievements = achievementService.findAchievements(name,gameId);
        return ResponseEntity.ok(achievementUtil.createAchievementFindSuccessDTO(achievements));
    }


    @RequestMapping(value = "/get?{id}" ,method = RequestMethod.GET)
    public ResponseEntity<?> findAchievementById(@PathVariable(value = "id") Long id){

        Achievement achievement = achievementService.findAchievementById(id);

        if(achievement == null){
            throw new IllegalArgumentException("Başarım bulunamadı");
        }

        return ResponseEntity.ok(achievementUtil.createAchievementSuccessDTO(achievement,"İşlem Başarılı."));
    }

    @RequestMapping(value = "/update" , method = RequestMethod.PUT)
    public ResponseEntity<?> updateAchievement(@RequestBody AchievementUpdateDTO achievementUpdateDTO){
        Achievement achievement = achievementService.findAchievementById(achievementUpdateDTO.getId());

        if(achievementUpdateDTO.getName() != null){
            achievement.setName(achievementUpdateDTO.getName());
        }
        if(achievementUpdateDTO.getGameId() != null){
            Game game = gameService.findGameById(achievementUpdateDTO.getGameId());

            if(game == null){
                throw new IllegalArgumentException("Oyun bulunamadı.");
            }
            achievement.setGame(game);
        }

        achievementService.save(achievement);

        return ResponseEntity.ok(achievementUtil.createAchievementSuccessDTO(achievement,"Güncelleme İşlemi Başarılı."));
    }

    @RequestMapping(value = "/delete" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAchievement(@RequestParam Long id){
        Achievement achievement = achievementService.findAchievementById(id);

        if(achievement == null){
            throw new IllegalArgumentException("Başarım bulunamadı.");
        }
        achievementService.delete(achievement);

        return ResponseEntity.ok(achievementUtil.createAchievementSuccessDTO(achievement,"Silme İşlemi Başarılı."));
    }

}
