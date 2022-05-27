package ru.mirea.task14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.task14.repository.BeanConfig;
import ru.mirea.task14.repository.model.Game;
import ru.mirea.task14.repository.GameRepository;
import ru.mirea.task14.repository.model.Level;

import java.util.List;

@Controller
public class MyController {
    public static ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
    private GameRepository gameRepository = context.getBean(GameRepository.class);

    @RequestMapping("/home")
    public String getIndex() {
        return "index.html";
    }

    @RequestMapping("/games")
    public @ResponseBody String getGames() {
        return gameRepository.toString();
    }

    @RequestMapping("/games/add")
    public @ResponseBody String addGame(@RequestParam("name") String name, @RequestParam("creationDate") String creationDate) {
        if (name.equals("")) {
            return "please send game name";
        }

        if (creationDate.equals("")) {
            return "please send game creation date";
        }

        Game game = new Game(name, creationDate);

        if (gameRepository.find(game) != 0) {
            return "game with name " + name + " and creation date " + creationDate + " is available";
        }

        gameRepository.add(game);

        return "game with name " + name + " and creation date " + creationDate + " has been added";
    }

    @RequestMapping("/games/delete")
    public @ResponseBody String deleteGame(@RequestParam("name") String name, @RequestParam("creationDate") String creationDate) {
        if (name.equals("")) {
            return "please send game name";
        }

        if (creationDate.equals("")) {
            return "please send game creation date";
        }

        Game game = new Game(name, creationDate);

        if (gameRepository.find(game) == -1) {
            return "game with name " + name + " and creation date " + creationDate + " is not available";
        }

        gameRepository.delete(game);

        return "game with name " + name + " and creation date " + creationDate + " has been deleted";
    }

    @RequestMapping("/game")
    public @ResponseBody String findGame(@RequestParam("name") String name, @RequestParam("creationDate") String creationDate) {
        Game game = new Game(name, creationDate);

        int index = gameRepository.find(game);

        if (gameRepository.find(game) == -1) {
            return "game with name " + name + " and creation date " + creationDate + " is not available";
        }

        return gameRepository.getRepository().get(index).toString();
    }

    @RequestMapping("/game/addlevel")
    public @ResponseBody String addLevelInGame(@RequestParam("name") String name, @RequestParam("creationDate") String creationDate,
                                               @RequestParam("levelName") String levelName, @RequestParam("complexity") String complexity) {
        Game game = new Game(name, creationDate);

        int index = gameRepository.find(game);

        if (gameRepository.find(game) == -1) {
            return "game with name " + name + " and creation date " + creationDate + " is not available";
        }

        Game gameInRep = gameRepository.getRepository().get(index);

        if (levelName.equals("")) {
            return "please send level name";
        }

        ComplexityEnum complexityEnum;

        try {
            complexityEnum = ComplexityEnum.valueOf(complexity);
        } catch (Exception e) {
            return "please send level complexity";
        }

        if (complexity.equals("")) {
            return "please send level complexity";
        }

        Level level = new Level(complexityEnum, levelName);

        if (gameInRep.findLevelInGame(level) >= 0) {
            return "level with name " + levelName + " and complexity " + complexity + " is available";
        }

        gameInRep.addLevel(level);

        return "level with name " + levelName + " and complexity " + complexity + " has been added";
    }

    @RequestMapping("/game/deletelevel")
    public @ResponseBody String deleteLevelInGame(@RequestParam("name") String name, @RequestParam("creationDate") String creationDate,
                                               @RequestParam("levelName") String levelName, @RequestParam("complexity") String complexity) {
        Game game = new Game(name, creationDate);

        int index = gameRepository.find(game);

        if (gameRepository.find(game) == -1) {
            return "game with name " + name + " and creation date " + creationDate + " is not available";
        }

        Game gameInRep = gameRepository.getRepository().get(index);

        if (levelName.equals("")) {
            return "please send level name";
        }

        ComplexityEnum complexityEnum;

        try {
            complexityEnum = ComplexityEnum.valueOf(complexity);
        } catch (Exception e) {
            return "please send level complexity";
        }

        if (complexity.equals("")) {
            return "please send level complexity";
        }

        Level level = new Level(complexityEnum, levelName);

        if (gameInRep.findLevelInGame(level) == -1) {
            return "level with name " + levelName + " and complexity " + complexity + " is not available";
        }

        gameInRep.deleteLevel(level);

        return "level with name " + levelName + " and complexity " + complexity + " has been deleted";
    }

}
