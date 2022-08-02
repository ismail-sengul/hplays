package com.oyuneticaret.utils;

import com.oyuneticaret.dto.achievement.AchievementSuccessDTO;
import com.oyuneticaret.model.Achievement;

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

}
