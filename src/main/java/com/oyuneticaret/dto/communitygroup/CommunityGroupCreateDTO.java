package com.oyuneticaret.dto.communitygroup;

import java.io.Serializable;

public class CommunityGroupCreateDTO implements Serializable {

    private Long creatorId;
    private String groupName;
    private String groupDescription;

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
