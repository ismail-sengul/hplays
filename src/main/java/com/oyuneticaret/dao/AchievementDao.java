package com.oyuneticaret.dao;

import com.oyuneticaret.model.Achievement;

import java.util.List;

public interface AchievementDao {

    void save(Achievement achievement);
    List<Achievement> findAchievements(String name,Long gameId);
    Achievement findAchievementById(Long id);
    void delete(Achievement achievement);
}
