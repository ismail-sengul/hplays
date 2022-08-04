package com.oyuneticaret.model;

import org.hibernate.boot.jaxb.hbm.internal.CacheAccessTypeConverter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "COMMUNITY_GROUP")
public class CommunityGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "CREATOR_ID", referencedColumnName = "ID")
    private User creator;

    @Column(name = "GROUP_NAME")
    private String groupName;

    @Column(name = "COMMUNITY_GROUP_DESCRIPTION")
    private String communityGroupDescription;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "JOINED_USER_COMMUNITY_GROUP",
            joinColumns = { @JoinColumn(name = "COMMUNITY_GROUP_ID") },
            inverseJoinColumns = { @JoinColumn(name = "USER_ID") })
    private Set<User> joinedUsers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCommunityGroupDescription() {
        return communityGroupDescription;
    }

    public void setCommunityGroupDescription(String communityGroupDescription) {
        this.communityGroupDescription = communityGroupDescription;
    }

    public Set<User> getJoinedUsers() {
        return joinedUsers;
    }

    public void setJoinedUsers(Set<User> joinedUsers) {
        this.joinedUsers = joinedUsers;
    }
}
