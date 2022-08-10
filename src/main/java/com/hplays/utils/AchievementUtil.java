package com.hplays.utils;

import com.hplays.dto.achievement.AchievementDTO;
import com.hplays.dto.achievement.AchievementFindSuccessDTO;
import com.hplays.dto.achievement.AchievementSuccessDTO;
import com.hplays.model.Achievement;

import java.util.ArrayList;
import java.util.List;

public class AchievementUtil {

    GameUtil gameUtil = new GameUtil();

    public AchievementSuccessDTO createAchievementSuccessDTO(Achievement achievement,String message){
        AchievementSuccessDTO achievementSuccessDTO = new AchievementSuccessDTO();
        achievementSuccessDTO.setGameDTO(gameUtil.convertGameDTO(achievement.getGame()));
        achievementSuccessDTO.setId(achievement.getId());
        achievementSuccessDTO.setName(achievement.getName());
        achievementSuccessDTO.setMessage(message);

        return achievementSuccessDTO;
    }

    public AchievementFindSuccessDTO createAchievementFindSuccessDTO(List<Achievement> achievements){
        AchievementFindSuccessDTO achievementFindSuccessDTO = new AchievementFindSuccessDTO();
        List<AchievementDTO> achievementDTOS = new ArrayList<>();
        for (Achievement achievement: achievements){
            AchievementDTO achievementDTO = new AchievementDTO();
            achievementDTO.setGameDTO(gameUtil.convertGameDTO(achievement.getGame()));
            achievementDTO.setName(achievement.getName());
            achievementDTO.setId(achievement.getId());
            achievementDTOS.add(achievementDTO);
        }
        achievementFindSuccessDTO.setAchievements(achievementDTOS);
        achievementFindSuccessDTO.setMessage("Listeleme İşlemi Başarılı");
        return achievementFindSuccessDTO;
    }

}
