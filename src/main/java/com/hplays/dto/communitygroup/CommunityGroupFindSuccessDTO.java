package com.hplays.dto.communitygroup;

import java.io.Serializable;
import java.util.List;

public class CommunityGroupFindSuccessDTO implements Serializable {

    private List<CommunityGroupDTO> communityGroupDTOS;
    private String message;

    public List<CommunityGroupDTO> getCommunityGroupDTOS() {
        return communityGroupDTOS;
    }

    public void setCommunityGroupDTOS(List<CommunityGroupDTO> communityGroupDTOS) {
        this.communityGroupDTOS = communityGroupDTOS;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
