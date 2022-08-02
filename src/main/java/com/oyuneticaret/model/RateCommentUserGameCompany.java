package com.oyuneticaret.model;

import javax.persistence.*;

@Entity
@Table(name = "RATE_COMMENT_USER_GAME_COMPANY")
public class RateCommentUserGameCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GAME_COMPANY_ID",referencedColumnName = "ID")
    private GameCompany gameCompany;

    @Column(name = "RATE")
    private Integer rate;

    @Column(name = "COMMENT")
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GameCompany getGameCompany() {
        return gameCompany;
    }

    public void setGameCompany(GameCompany gameCompany) {
        this.gameCompany = gameCompany;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
