package com.hplays.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "GAME")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "RELEASE_DATE")
    private Date releaseDate;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "GAME_COMPANY_ID", referencedColumnName = "ID")
    private GameCompany gameCompany;

    @Column(name = "GAME_DESCRIPTION")
    private String gameDescription;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private Set<Achievement> achievements;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "GAME_TYPE",
            joinColumns = { @JoinColumn(name = "GAME_ID") },
            inverseJoinColumns = { @JoinColumn(name = "USER_ID") })
    private Set<Types> types;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public GameCompany getGameCompany() {
        return gameCompany;
    }

    public void setGameCompany(GameCompany gameCompany) {
        this.gameCompany = gameCompany;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public Set<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(Set<Achievement> achievements) {
        this.achievements = achievements;
    }

    public Set<Types> getTypes() {
        return types;
    }

    public void setTypes(Set<Types> types) {
        this.types = types;
    }
}
