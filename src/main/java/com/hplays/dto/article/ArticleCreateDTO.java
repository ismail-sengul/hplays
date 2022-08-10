package com.hplays.dto.article;

import java.io.Serializable;

public class ArticleCreateDTO implements Serializable {

    private Long userId;
    private Long communityGroupId;
    private String content;

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
