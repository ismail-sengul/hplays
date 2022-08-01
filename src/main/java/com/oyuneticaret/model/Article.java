package com.oyuneticaret.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ARTICLE")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COMMUNITY_GROUP_ID", referencedColumnName = "ID")
    private CommunityGroup communityGroup;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

    @Column(name = "CONTENT")
    private String content;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ARTICLE_LIKES",
            joinColumns = { @JoinColumn(name = "ARTICLE_ID") },
            inverseJoinColumns = { @JoinColumn(name = "USER_ID") })
    private Set<User> likes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CommunityGroup getCommunityGroup() {
        return communityGroup;
    }

    public void setCommunityGroup(CommunityGroup communityGroup) {
        this.communityGroup = communityGroup;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<User> getLikes() {
        return likes;
    }

    public void setLikes(Set<User> likes) {
        this.likes = likes;
    }
}
