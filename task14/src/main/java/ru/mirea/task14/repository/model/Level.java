package ru.mirea.task14.repository.model;

import ru.mirea.task14.ComplexityEnum;

public class Level {

    private ComplexityEnum complexity;
    private String levelName;

    public Level(ComplexityEnum complexity, String levelName) {
        this.complexity = complexity;
        this.levelName = levelName;
    }

    public ComplexityEnum getComplexity() {
        return complexity;
    }

    public void setComplexity(ComplexityEnum complexity) {
        this.complexity = complexity;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}
