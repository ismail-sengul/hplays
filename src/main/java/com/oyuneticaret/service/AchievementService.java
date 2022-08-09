package com.oyuneticaret.service;

import com.oyuneticaret.model.Achievement;

import java.util.List;

public interface AchievementService {
    Achievement save(Achievement achievement);
    List<Achievement> findAchievements(String name, Long gameId);
    Achievement findAchievementById(Long id);
    Achievement delete(Achievement achievement);
}
