package ru.mirea.task15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.task15.repository.model.Level;

public interface LevelRepository extends JpaRepository<Level, Long> {
}
