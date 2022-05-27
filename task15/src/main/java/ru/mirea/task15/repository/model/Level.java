package ru.mirea.task15.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "levels")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Complexity complexity;
    @Column(name = "name")
    private String levelName;
    @Column(name = "game_id")
    private Long gameId;

    public Level() {}

    public Level(Complexity complexity, String levelName) {
        this.complexity = complexity;
        this.levelName = levelName;
    }

    public Level(Complexity complexity, String levelName, Long gameId) {
        this.complexity = complexity;
        this.levelName = levelName;
        this.gameId = gameId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Complexity getComplexity() {
        return complexity;
    }

    public void setComplexity(Complexity complexity) {
        this.complexity = complexity;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
}