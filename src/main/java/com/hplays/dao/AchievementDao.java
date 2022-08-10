package com.hplays.dao;

import com.hplays.model.Achievement;

import java.util.List;

public interface AchievementDao {

    Achievement save(Achievement achievement);
    List<Achievement> findAchievements(String name,Long gameId);
    Achievement findAchievementById(Long id);
    Achievement delete(Achievement achievement);
}
