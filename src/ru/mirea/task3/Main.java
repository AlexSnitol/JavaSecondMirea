package ru.mirea.task3;

// Variant 8
// List с использованием Semaphore, Map с использованием ключевого слова synchronized.

import java.util.Random;
import static java.lang.Math.abs;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        MyList<Integer> list = new MyList<Integer>();
        MyMap<Integer, Integer> map = new MyMap<Integer, Integer>();
        Random random = new Random();

        Thread th1 = new Thread(() -> {
            for (int i = 1; i <= 50; i++)
                list.add(abs(random.nextInt()%100));
        });

        Thread th2 = new Thread(() -> {
            for (int i = 1; i <= 50; i++)
                list.add(abs(random.nextInt()%100));
        });

        th1.start();
        th2.start();
        Thread.sleep(100);

        System.out.println("LIST:");
        System.out.println(list.size());
        list.printList();


        System.out.println();
        System.out.println();

        Thread th3 = new Thread(() -> {
            for (int i = 1; i <= 50; i++)
                map.put(i, abs(random.nextInt()%100));
        });

        Thread th4 = new Thread(() -> {
            for (int i = 51; i <= 100; i++)
                map.put(i, abs(random.nextInt()%100));
        });

        th3.start();
        th4.start();
        Thread.sleep(100);

        System.out.println("MAP:");
        System.out.println(map.size());
        map.printMap();
    }
}
