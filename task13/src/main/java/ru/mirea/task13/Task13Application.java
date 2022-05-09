package ru.mirea.task13;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@SpringBootApplication
public class Task13Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Student student = context.getBean(Student.class);

        out.println(student.getName());
        out.println(student.getLastName());
        out.println(student.getGroup());

        SpringApplication.run(Task13Application.class, args);
    }

}
