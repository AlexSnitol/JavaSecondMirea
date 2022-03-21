// Variant 8
// Фильтрация по возрасту больше чем 20, сортировка по последней букве имени, увеличение возраста каждого на 3, вычисление среднего возраста всех элементов.

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.summingInt;

public class Main
{
    public static void main(String [] args)
    {
        List<Human> l = new ArrayList<>();
        LocalDate date;
        float sumAge;
        float avgAge;

        date = LocalDate.of(1999, 10, 10);
        l.add(new Human(
                "Maxim",
                "Novikov",
                date,
                60
        ));

        date = LocalDate.of(1998, 5, 24);
        l.add(new Human(
                "Liza",
                "Yota",
                date,
                55
        ));

        date = LocalDate.of(2000, 1, 14);
        l.add(new Human(
                "Ivan",
                "Hekto",
                date,
                62
        ));

        date = LocalDate.of(2000, 1, 14);
        l.add(new Human(
                "Dmitriy",
                "Ismail",
                date,
                75
        ));

        date = LocalDate.of(1999, 2, 15);
        l.add(new Human(
                "Alex",
                "Slotin",
                date,
                70
        ));

        date = LocalDate.of(2005, 3, 1);
        l.add(new Human(
                "Inna",
                "Petrova",
                date,
                45
        ));

        Stream<Human> stream = l.stream();
        System.out.println("[source]");
        System.out.println("fN\t\tlN\t\tA\tBD\t\t\tW");
        stream.forEach(System.out::println);

        stream = l.stream();
        sumAge = stream.collect(summingInt(hm -> hm.getAge()));
        avgAge = sumAge / l.size();
        System.out.println("average age: " + avgAge);


        stream = l.stream();
        System.out.println("");
        System.out.println("[result]");
        System.out.println("fN\t\tlN\t\tA\tBD\t\t\tW");
        stream.filter(hm -> hm.getAge() > 20)
                .sorted(Comparator.comparing(hm -> hm.getFirstName().charAt(hm.getFirstName().length() - 1)))
                .forEach(hm -> System.out.println(hm.getFirstName() + "\t" + hm.getLastName() + "\t" + (hm.getAge() + 3) + "\t" + hm.getBirthDate() + "\t" + hm.getWeight()));

        stream = l.stream();
        sumAge = stream.collect(summingInt(hm -> hm.getAge() + 3));
        avgAge = sumAge / l.size();
        System.out.println("average age: " + avgAge);
    }
}
