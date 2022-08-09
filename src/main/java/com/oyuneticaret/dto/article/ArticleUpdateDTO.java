package com.oyuneticaret.dto.article;

import com.oyuneticaret.dto.communitygroup.CommunityGroupDTO;
import com.oyuneticaret.dto.user.UserDTO;

public class ArticleUpdateDTO {

    private Long id;
    private Long userId;
    private Long communityGroupId;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCommunityGroupId() {
        return communityGroupId;
    }

    public void setCommunityGroupId(Long communityGroupId) {
        this.communityGroupId = communityGroupId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
