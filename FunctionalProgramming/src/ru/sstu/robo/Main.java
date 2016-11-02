package ru.sstu.robo;


import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.nio.file.Files.isDirectory;
import static java.nio.file.Files.isRegularFile;

/**
 * @author MikeW
 */
public class Main {

    public static void main(String[] args) {
        /*List<Person> persons = Person.createShortList();
        System.out.println("Водители потенциальные:");
        for (Person p :
                persons) {
            if (p.getAge() >= 18) {
                System.out.println(p.getSurName());
            }
        }

        System.out.println("Призывники:");
        System.out.println("Призывники:");
        for (Person p :
                persons) {
            if (p.getAge() >= 18 && p.getAge() <= 27 && p.getGender() == Gender.MALE) {
                System.out.println(p.getSurName());
            }
        }

        System.out.println("Призывники 2:");
        MyTest<Person> myTest1 = new SoldierTest<>();
        MyTest<Person> myTest2 = new DriverTest<>();
        for (Person p :
                persons) {
            if (myTest1.test(p)) {
                System.out.println(p.getSurName());
            }
        }

        System.out.println("Фильтрация с помощью ананомных классов:");
        MyTest<Person> myTest3 = new MyTest<Person>() {
            @Override
            public boolean test(Person t) {
                return t.getGender() == Gender.FEMALE;
            }
        };
        for (Person p :
                persons) {
            if (myTest3.test(p)) {
                System.out.println(p.getSurName());
            }
        }

        System.out.println("Фильтрация с помощью лямбда-выражений:");
        MyTest<Person> myTest4 = t -> t.getGender() == Gender.FEMALE;
        for (Person p :
                persons) {
            if (myTest4.test(p)) {
                System.out.println(p.getSurName());
            }
        }

        System.out.println("Фильтрация с помощью лямбда-выражений 2:");
        MyTest<Person> myTest5 = t -> {
            if (t.getSurName().equals("Doe") || t.getAge() > 40) {
                return false;
            } else return true;
        };
        for (Person p :
                persons) {
            if (myTest5.test(p)) {
                System.out.println(p.getSurName());
            }
        }

        System.out.println("Фильтрация с помощью лямбда-выражений 3:");
        AgeTest ageTest1 = (p, age1, age2) -> p.getAge() >= age1 && p.getAge() <= age2;
        for (Person p :
                persons) {
            if (ageTest1.test(p, 18, 27)) {
                System.out.println(p.getSurName());
            }
        }

        System.out.println("Фильтрация с помощью лямбда-выражений 4:");
        AgeTest ageTest2 = (p, age1, age2) -> p.getAge() < age1 || p.getAge() > age2;
        for (Person p :
                persons) {
            //if (ageTest2.test(p, 18, 27)) {
            System.out.println(p.getSurName());
            //}
        }

        System.out.println("Итерирование с помощью анонимного класса и forEach:");
        persons.forEach(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person.getSurName());
            }
        });

        System.out.println("Итерирование с помощью лямбд и forEach:");
        persons.forEach(person -> System.out.println(person.getSurName()));

        System.out.println("Итерирование с помощью лямбд и forEach 2:");
        Consumer<Person> cons1 = person -> System.out.println(person.getSurName());
        Consumer<Person> cons2 = person -> System.out.println(person.getAddress());
        Consumer<Person> cons3 = person -> System.out.println(person.getAge());

        Random r = new Random();
        int nextInt = r.nextInt(3);
        if (nextInt == 0) persons.forEach(cons1);
        else if (nextInt == 1) persons.forEach(cons2);
        else if (nextInt == 2) persons.forEach(cons3);

        System.out.println("Сортировка коллекций с помощью анонимного класса и sort:");
        persons.sort(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p2.getAge() - p1.getAge();
            }
        });
        persons.forEach(person -> System.out.println(person.getSurName() + " " + person.getAge()));

        System.out.println("Сортировка коллекций с помощью анонимного класса и sort 2:");
        persons.sort(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p2.getSurName().compareTo(p1.getSurName());
            }
        });
        persons.forEach(person -> System.out.println(person.getSurName() + " " + person.getAge()));

        System.out.println("Сортировка коллекций с помощью лямбд и sort:");
        persons.sort((p1, p2) -> p2.getAge() - p1.getAge());
        persons.forEach(person -> System.out.println(person.getSurName() + " " + person.getAge()));


        System.out.println("Пример функциональных интерфейсов из java.util.function.*");
        Function<String, String> funct1 = s1 -> s1 + "!";
        System.out.println(funct1.apply("Hello"));

        Function<String, Integer> funct2 = s1 -> s1.length() * 2;
        System.out.println(funct2.apply("Hello"));

        java.util.function.Predicate<String> pred1 = s -> s.length() > 1;
        System.out.println(pred1.test("Hello"));
        System.out.println(pred1.test("e"));*/
        //RoboCallTest01.main(args);
        //RoboCallTest02.main(args);
        //RoboCallTest03.main(args);
        //RoboCallTest04.main(args);

        //dirExample();


        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(s);
    }

    public static void dirExample()
    {
        System.out.println("Пример вывода содержимого папки:");
        Path path = Paths.get("");
        list(path);
    }

    public static void list(Path path)
    {
        if(Files.isDirectory(path)) {
            System.out.println(path.toAbsolutePath() + " - это папка. Вот её содержимое:");
            try {

                Files.list(path).forEach( path1 ->
                {
                    System.out.println(path1.getFileName());
                    list(path1);
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(Files.isRegularFile(path))
            System.out.println(path.toAbsolutePath() + " - это файл");
    }
}
