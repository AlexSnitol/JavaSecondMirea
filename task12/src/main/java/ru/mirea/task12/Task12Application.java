package ru.mirea.task12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Task12Application {

    public static void main(String[] args) {

        String fileToHashPath = args[0];
        String fileWithHashPath = args[1];

        MyHashClass.fileToHashPath = fileToHashPath;
        MyHashClass.fileWithHashPath = fileWithHashPath;

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        MyHashClass myHashClass = context.getBean(MyHashClass.class);

        SpringApplication.run(Task12Application.class, args);
    }

}
