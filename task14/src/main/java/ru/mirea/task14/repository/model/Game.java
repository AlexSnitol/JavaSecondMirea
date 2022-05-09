package ru.mirea.task14.repository.model;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private String name;
    private String creationDate;
    private List<Level> levelList;

    public Game(String name, String creationDate) {
        this.name = name;
        this.creationDate = creationDate;
        this.levelList = new ArrayList<>();
    }

    public Game(String name, String creationDate, List<Level> levelList) {
        this.name = name;
        this.creationDate = creationDate;
        this.levelList = levelList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
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
