package ru.mirea.task10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static java.lang.System.err;

@SpringBootApplication
public class Task10Application {

    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        MyList myList = context.getBean(MyList.class);
        err.println(myList.getSortAlgorithm().getClass().toString());

        SpringApplication.run(Task10Application.class, args);
    }

}
