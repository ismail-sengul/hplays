package com.oyuneticaret.service.Impl;

import com.oyuneticaret.dao.AchievementDao;
import com.oyuneticaret.model.Achievement;
import com.oyuneticaret.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AchievementServiceImpl implements AchievementService {
    @Autowired
    AchievementDao achievementDao;

    @Override
    @Transactional
    public void save(Achievement achievement) {
        achievementDao.save(achievement);
    }

    @Override
    public List<Achievement> findAchievements(String name,Long gameId) {
        return achievementDao.findAchievements(name,gameId);
    }

    @Override
    public Achievement findAchievementById(Long id) {
        return achievementDao.findAchievementById(id);
    }

    @Override
    @Transactional
    public void delete(Achievement achievement) {
        achievementDao.delete(achievement);
    }
}
