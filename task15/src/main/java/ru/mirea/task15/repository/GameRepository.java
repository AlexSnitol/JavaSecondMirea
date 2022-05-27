package ru.mirea.task15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.task15.repository.model.Game;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByName(String name);
}
