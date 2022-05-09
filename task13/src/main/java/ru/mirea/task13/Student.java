package ru.mirea.task13;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component
@PropertySources(value = {@PropertySource("classpath:application.yml")})
public class Student {

    @Value("${name}")
    private String name;
    @Value("${last_name}")
    private String lastName;
    @Value("${group}")
    private String group;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGroup() {
        return group;
    }

}
