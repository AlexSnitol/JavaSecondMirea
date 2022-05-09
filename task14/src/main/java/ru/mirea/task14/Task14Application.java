package ru.mirea.task14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.mirea.task14.repository.BeanConfig;
import ru.mirea.task14.repository.GameRepository;
import ru.mirea.task14.repository.model.Game;
import ru.mirea.task14.repository.model.Level;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Task14Application {

    public static void main(String[] args) {
        GameRepository gameRepository = MyController.context.getBean(GameRepository.class);

        List<Game> gameList = gameRepository.getRepository();
        List<Level> levelList = new ArrayList<>();
        levelList.add(new Level(ComplexityEnum.EASY, "easyLevel1"));
        levelList.add(new Level(ComplexityEnum.EASY, "easyLevel2"));
        levelList.add(new Level(ComplexityEnum.EASY, "easyLevel3"));
        gameList.add(new Game("game1", "date1", levelList));
        gameList.add(new Game("game2", "date2"));
        levelList = new ArrayList<>();
        levelList.add(new Level(ComplexityEnum.TUTORIAL, "tutorialLevel0"));
        levelList.add(new Level(ComplexityEnum.EASY, "easyLevel1"));
        levelList.add(new Level(ComplexityEnum.NORMAL, "normalLevel2"));
        levelList.add(new Level(ComplexityEnum.HARD, "hardLevel3"));
        gameList.add(new Game("game3", "date3", levelList));
        gameRepository.setRepository(gameList);

        SpringApplication.run(Task14Application.class, args);
    }

}
