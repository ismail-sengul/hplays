package com.oyuneticaret.dto.article;

import com.oyuneticaret.dto.communitygroup.CommunityGroupDTO;
import com.oyuneticaret.dto.user.UserDTO;

import java.io.Serializable;

public class ArticleDTO implements Serializable {

    private Long id;
    private UserDTO user;
    private CommunityGroupDTO communityGroup;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public CommunityGroupDTO getCommunityGroup() {
        return communityGroup;
    }

    public void setCommunityGroup(CommunityGroupDTO communityGroup) {
        this.communityGroup = communityGroup;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
