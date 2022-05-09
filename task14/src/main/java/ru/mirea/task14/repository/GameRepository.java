package ru.mirea.task14.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.mirea.task14.repository.model.Game;
import ru.mirea.task14.repository.model.Level;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class GameRepository {

    List<Game> repository = new ArrayList<>();

    public GameRepository() {}

    public List<Game> getRepository() {
        return repository;
    }

    public void setRepository(List<Game> repository) {
        this.repository = repository;
    }

    @Override
    public String toString() {

        String result = "";
        int i = 0;

        for (Game game : repository) {
            result += game.toString() + "</br></br>";
        }

        return result;
    }

    public void add(Game game) {
        repository.add(game);
    }

    public void delete(Game game) {
        repository.removeIf(gameRep -> gameRep.getName().equals(game.getName()) && gameRep.getCreationDate().equals(game.getCreationDate()));
    }

    public int find(Game game) {
        int i = 0;
        for (Game gameRep : repository) {
            i++;
            if (gameRep.getName().equals(game.getName()) && gameRep.getCreationDate().equals(game.getCreationDate())) {
                return i;
            }
        }
        return 0;
    }
}
