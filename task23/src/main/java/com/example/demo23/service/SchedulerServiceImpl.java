package com.example.demo23.service;

import com.example.demo23.model.Groups;
import com.example.demo23.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Для приложения из предыдущего задания создать класс-сервис с методом,
 * который будет вызываться каждые 30 минут
 * и очищать определённую директорию,
 * +++ а затем создавать по файлу для каждой из сущностей и загружать туда все данные из базы данных.
 * <p>
 * +++ Также добавить возможность вызывать данный метод с использованием Java Management Extensions (JMX).
 */


@Service
@Slf4j
@ManagedResource(description = "Scheduler service bean")
public class SchedulerServiceImpl implements SchedulerService {
    private final String BACKUP_DIR = "src/ru/mirea/task23/demo23/backups/";

    @Autowired
    private StudentService studentService;
    @Autowired
    private GroupService groupService;


    //сначала сделаем по 1 минуте, чтобы не ждать 30 минут
    @Override
    @Scheduled(cron = "0 0/10 * * * *")
    @ManagedOperation(description = "Clear output, create .txt with database data")
    public void backupFromDatabase() throws IOException {
        log.info("Sheduler Task is started");
        File file_dir = ResourceUtils.getFile(BACKUP_DIR);
        try {
            for (File file : file_dir.listFiles())
                if (file.isFile()) {
                    file.delete();
                    System.out.println(file.getName() +" is deleted");
                }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        log.info("Files deleted");

        BufferedWriter groups = new BufferedWriter(new FileWriter(BACKUP_DIR + "groups_data.txt"));
        BufferedWriter students = new BufferedWriter(new FileWriter(BACKUP_DIR + "students_data.txt"));

        //groups.write("id\tauthor_id\tname\tcreation date\n");
        for (Groups item : groupService.readAllEntity()) {
            groups.write(item.toString());
            groups.write('\n');
        }
        groups.close();

        //students.write("id\tnickname\tbirth date\n");
        for (Student item : studentService.readAllEntity()) {
            //System.out.println(item.toString());
            students.write(item.toString());
            students.write('\n');
        }
        students.close();
        log.info("Sheduler Task is ended");
    }
}
