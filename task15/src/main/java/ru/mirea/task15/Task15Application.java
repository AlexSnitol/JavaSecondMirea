package ru.mirea.task15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.mirea.task15.controller.MyController;
import ru.mirea.task15.repository.GameRepository;
import ru.mirea.task15.repository.model.Game;
import ru.mirea.task15.repository.model.Level;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Task15Application {

    public static void main(String[] args) {
        SpringApplication.run(Task15Application.class, args);
    }

}
