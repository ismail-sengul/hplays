package com.oyuneticaret.dto.communitygroup;

import com.oyuneticaret.dto.user.UserDTO;

import java.io.Serializable;

public class CommunityGroupUpdateDTO implements Serializable {

    private Long id;
    private Long creatorId;
    private String groupName;
    private String groupDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
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
}
