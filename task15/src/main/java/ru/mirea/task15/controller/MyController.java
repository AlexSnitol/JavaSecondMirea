package ru.mirea.task15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.task15.repository.GameRepository;
import ru.mirea.task15.repository.LevelRepository;
import ru.mirea.task15.repository.model.Game;
import ru.mirea.task15.repository.model.Level;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class MyController {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private LevelRepository levelRepository;

    @RequestMapping("/home")
    public String getIndex() {
        return "index.html";
    }

    @GetMapping("/games")
    public ResponseEntity<List<Game>> getAllGames() {
        try {
            List<Game> games = gameRepository.findAll();
            if (games == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(games, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/games/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable("id") Long id) {
        try {
            Optional<Game> game = gameRepository.findById(id);
            if (game.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(game.get(), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/games")
    public ResponseEntity<Game> addGame(@RequestBody Game game) {
        try {
            Game _game = gameRepository.save(new Game(game.getName(), game.getCreationDate()));
            return new ResponseEntity<>(_game, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/games/{id}")
    public ResponseEntity<HttpStatus> deleteGame(@PathVariable("id") Long id) {
        try {
            gameRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/games/{id}/{iLevel}")
    public ResponseEntity<Level> getLevelByNumberOnGameById(@PathVariable("id") Long id, @PathVariable("iLevel") Long iLevel) {
        try {
            Game game = gameRepository.findById(id).get();
            int i = 0;
            for (Level level : game.getLevelList()) {
                if (i++ == iLevel) {
                    return new ResponseEntity<>(level, HttpStatus.OK);
                }
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/games/{id}")
    public ResponseEntity<Level> addLevelInGameById(@PathVariable("id") Long id, @RequestBody Level newLevel) {
        try {
            Game game = gameRepository.findById(id).get();
            game.addLevel(newLevel);
            //Level _level = levelRepository.save(new Level(newLevel.getComplexity(), newLevel.getLevelName(), game));
            return new ResponseEntity<>(newLevel, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/games/{id}/{iLevel}")
    public ResponseEntity<HttpStatus> deleteLevelByNumberInGameById(@PathVariable("id") Long id, @PathVariable("iLevel") Long iLevel) {
        try {
            Game game = gameRepository.findById(id).get();
            int i = 0;
            for (Level level : game.getLevelList()) {
                if (i++ == iLevel) {
                    levelRepository.deleteById(level.getId());
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
