package com.oyuneticaret.service;

import com.oyuneticaret.dto.achievement.AchievementFindDTO;
import com.oyuneticaret.model.Achievement;

import java.util.List;

public interface AchievementService {
    void save(Achievement achievement);
    List<Achievement> findAchievements(AchievementFindDTO achievementFindDao);
    Achievement findAchievementById(Long id);
    void delete(Achievement achievement);
}
