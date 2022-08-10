package com.hplays.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "BIRTH_OF_DATE")
    private Date birthOfDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ACHIEVEMENT",
            joinColumns = { @JoinColumn(name = "USER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "ACHIEVEMENT_ID") })
    private Set<Achievement> achievements;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_GAME",
            joinColumns = { @JoinColumn(name = "USER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "GAME_ID") })
    private Set<Game> games;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "WISHLIST_USER",
            joinColumns = { @JoinColumn(name = "USER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "GAME_ID") })
    private Set<Game> wishlist;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "BASKET_USER",
            joinColumns = { @JoinColumn(name = "USER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "GAME_ID") })
    private Set<Game> basket;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_FRIEND",
            joinColumns = { @JoinColumn(name = "USER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "FRIEND_ID") })
    private Set<User> friends;

    @ManyToMany(mappedBy = "joinedUsers")
    private Set<CommunityGroup> communityGroups;

    @OneToMany(mappedBy = "senderUser")
    private Set<MessageUserToUser> sendedMessages;

    @OneToMany(mappedBy = "receiverUser")
    private Set<MessageUserToUser> receivedMessages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(Date birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public Set<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(Set<Achievement> achievements) {
        this.achievements = achievements;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public Set<Game> getWishlist() {
        return wishlist;
    }

    public void setWishlist(Set<Game> wishlist) {
        this.wishlist = wishlist;
    }

    public Set<Game> getBasket() {
        return basket;
    }

    public void setBasket(Set<Game> basket) {
        this.basket = basket;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public Set<CommunityGroup> getCommunityGroups() {
        return communityGroups;
    }

    public void setCommunityGroups(Set<CommunityGroup> communityGroups) {
        this.communityGroups = communityGroups;
    }

    public Set<MessageUserToUser> getSendedMessages() {
        return sendedMessages;
    }

    public void setSendedMessages(Set<MessageUserToUser> sendedMessages) {
        this.sendedMessages = sendedMessages;
    }

    public Set<MessageUserToUser> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(Set<MessageUserToUser> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }
}
