package com.oyuneticaret.dao;

import com.oyuneticaret.dto.achievement.AchievementFindDTO;
import com.oyuneticaret.model.Achievement;

import java.util.List;

public interface AchievementDao {

    void save(Achievement achievement);
    List<Achievement> findAchievements(AchievementFindDTO achievementFindDao);
    Achievement findAchievementById(Long id);
    void delete(Achievement achievement);
}
