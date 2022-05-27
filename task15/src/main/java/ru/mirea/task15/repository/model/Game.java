package ru.mirea.task15.repository.model;

import org.apache.tomcat.jni.Local;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "games")
public class Game {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "creation_date")
    private LocalDate creationDate;
    @OneToMany()
    @JoinColumn(name = "game_id")
    private List<Level> levelList;

    public Game() {

    }
    public Game(String name, LocalDate creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Level> getLevelList() {
        return levelList;
    }

    public void setLevelList(List<Level> levelList) {
        this.levelList = levelList;
    }

    public void addLevel(Level newLevel) {
        levelList.add(newLevel);
    }

    public void deleteLevel(Level level) {
        levelList.removeIf(levelGame -> levelGame.getLevelName().equals(level.getLevelName()) && levelGame.getComplexity().equals(level.getComplexity()));
    }

    public int findLevelInGame(Level level) {
        int i = 0;
        for (Level levelInGame : levelList) {
            i++;
            if (levelInGame.getLevelName().equals(level.getLevelName()) && levelInGame.getComplexity().equals(level.getComplexity())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String result = "";

        result += name + " " + creationDate + " levelNumber:" + levelList.size();
        if (levelList != null && levelList.size() != 0) {
            result += "</br>";
            for (int i = 0; i < levelList.size(); i++) {
                result += (i + 1) + ". " + levelList.get(i).getLevelName() + " c: " + levelList.get(i).getComplexity();

                if (i != levelList.size() - 1) {
                    result += "</br>";
                }
            }
        }

        return result;
    }
}
