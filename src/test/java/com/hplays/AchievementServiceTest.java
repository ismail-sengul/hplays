package com.hplays;


import com.hplays.dao.AchievementDao;
import com.hplays.model.Achievement;
import com.hplays.model.Game;
import com.hplays.service.Impl.AchievementServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AchievementServiceTest {

    @InjectMocks
    AchievementServiceImpl achievementService;

    @Mock
    AchievementDao achievementDao;

    @Test
    public void testSave(){
        Achievement saveAchievement = new Achievement();
        saveAchievement.setId(1L);
        saveAchievement.setGame(new Game());
        saveAchievement.setName("TestAchievement");

        when(achievementDao.save(saveAchievement)).thenReturn(saveAchievement);

        Achievement achievement = achievementService.save(saveAchievement);
        assertEquals(achievement.getId(),1L);
    }

    @Test
    public void testUpdate(){
        Achievement updateAchievement = new Achievement();
        updateAchievement.setId(1L);
        updateAchievement.setGame(new Game());
        updateAchievement.setName("TestAchievement");

        when(achievementDao.save(updateAchievement)).thenReturn(updateAchievement);
        Achievement saveAchievement = achievementService.save(updateAchievement);
        saveAchievement.setId(2L);
        Achievement achievement = achievementService.save(saveAchievement);

        assertEquals(achievement.getId(),2L);
    }

    @Test
    public void testDelete(){
        Achievement deleteAchievement = new Achievement();
        deleteAchievement.setId(1L);
        deleteAchievement.setGame(new Game());
        deleteAchievement.setName("TestAchievement");

        when(achievementDao.save(deleteAchievement)).thenReturn(deleteAchievement);
        Achievement saveAchievement = achievementDao.save(deleteAchievement);

        assertEquals(saveAchievement.getId(),1L);
        when(achievementDao.delete(saveAchievement)).thenReturn(saveAchievement);
        when(achievementDao.findAchievementById(saveAchievement.getId())).thenReturn(null);
        Achievement deletedAchievement = achievementDao.delete(saveAchievement);
        Achievement achievement = achievementDao.findAchievementById(deletedAchievement.getId());

        assertEquals(achievement,null);
    }
}
