package ru.mirea.task12;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;

import static java.lang.System.err;
import static java.lang.System.out;

@Component
@Scope("singleton")
public class MyHashClass {

    public static String fileToHashPath = "";
    public static String fileWithHashPath = "";
    private int hash;

    public MyHashClass() {}

    public MyHashClass(String fileToHashPath, String fileWithHashPath) {
        this.fileToHashPath = fileToHashPath;
        this.fileWithHashPath = fileWithHashPath;
    }


    @PostConstruct
    private void init() {
        StringBuilder text = new StringBuilder();

        try (FileReader fileReader = new FileReader(fileToHashPath)) {
            int i;
            while ((i = fileReader.read()) != -1) {
                text.append((char) i);
            }
        } catch (IOException e) {
            err.println(e);
            return;
        }

        this.hash = text.toString().hashCode();
    }

    @PreDestroy
    private void destroy() {
        try (FileWriter fileWriter = new FileWriter(fileWithHashPath)) {
            fileWriter.write(String.valueOf(this.hash));
        } catch (IOException e) {
            err.println(e);
        }
    }

}
