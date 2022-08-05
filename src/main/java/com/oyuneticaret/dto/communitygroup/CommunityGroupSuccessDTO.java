package com.oyuneticaret.dto.communitygroup;

import com.oyuneticaret.dto.user.UserDTO;

import java.io.Serializable;

public class CommunityGroupSuccessDTO implements Serializable {

    private Long id;
    private UserDTO creatorUser;
    private String groupName;
    private String groupDescription;
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(UserDTO creatorUser) {
        this.creatorUser = creatorUser;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
