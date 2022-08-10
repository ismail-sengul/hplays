package com.hplays.service.Impl;

import com.hplays.dao.AchievementDao;
import com.hplays.model.Achievement;
import com.hplays.service.AchievementService;
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
    public Achievement save(Achievement achievement) {
        achievementDao.save(achievement);
        return achievement;
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
    public Achievement delete(Achievement achievement) {
        achievementDao.delete(achievement);
        return achievement;
    }
}
