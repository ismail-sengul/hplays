package com.oyuneticaret.service;

import com.oyuneticaret.dao.AchievementDao;
import com.oyuneticaret.dto.achievement.AchievementFindDTO;
import com.oyuneticaret.model.Achievement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementServiceImpl implements AchievementService {
    @Autowired
    AchievementDao achievementDao;

    @Override
    public void save(Achievement achievement) {
        achievementDao.save(achievement);
    }

    @Override
    public List<Achievement> findAchievements(AchievementFindDTO achievementFindDao) {
        return achievementDao.findAchievements(achievementFindDao);
    }

    @Override
    public Achievement findAchievementById(Long id) {
        return achievementDao.findAchievementById(id);
    }

    @Override
    public void delete(Achievement achievement) {
        achievementDao.delete(achievement);
    }
}
