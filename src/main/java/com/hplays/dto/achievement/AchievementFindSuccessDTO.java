package com.hplays.dto.achievement;

import java.util.List;

public class AchievementFindSuccessDTO {

    private List<AchievementDTO> achievements;
    private String message;

    public List<AchievementDTO> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<AchievementDTO> achievements) {
        this.achievements = achievements;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
