/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sstu;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author user
 */
public class AdvancedStreamExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Person> persons = Arrays.asList(
                        new Person("Иван", 18),
                        new Person("Александр", 23),
                        new Person("Сергей", 23),
                        new Person("Алексей", 28),
                        new Person("Николай", 31),
                        new Person("Мария", 25),
                        new Person("Татьяна", 25),
                        new Person("Николай", 30),
                        new Person("Николай", 18),
                        new Person("Мария", 46),
                        new Person("Сергей", 38),
                        new Person("Николай", 17),
                        new Person("Александр", 26),
                        new Person("Лариса", 25));
        //System.out.println("======= COLLECT ========");
        //collectorExample(persons);

        /*System.out.println("======= FLATMAP ========");
        List<Boss> bosses = new ArrayList<>();

        // создаем боссов
        IntStream
                .range(1, 4)
                .forEach(i -> bosses.add(new Boss("Big boss #" + i)));

        // создаем подчиненных
        bosses.forEach(
                b -> IntStream
                        .range(1, 4)
                        .forEach(
                                i -> b.employees.add(new Employee("Small employee #" + i + " of " + b.name))));
        
        bosses.forEach((Boss b)
                -> b.employees
                .stream()//Stream<Employee>
                .forEach(
                        (Employee e) ->
                                IntStream
                                        .range(1, 4)
                                        .forEach(i ->
                                                e.friends.add(new Employee("Friend #" + i + " of " + e.name))
                                        )
                )
        );
        
        flatMapExample(bosses);*/

        /*System.out.println("======= REDUCE ========");
        reduceExample(persons);*/
        System.out.println("======= PARALLEL ========");
        parallelStreamExample(persons);
        
    }

    private static void collectorExample(List<Person> persons) {

        /*System.out.println("======= Простое преобразование в List ========");
        List<Person> filtered
                = persons
                .stream()//Stream<Person>
                .filter(p -> p.name.startsWith("А"))//Stream<Person>
                .collect(
                        Collectors.toList()
                );//List<Person>

        System.out.println(filtered);

        
        
        
        System.out.println("======= Простое преобразование в Set ========");
        Set<Person> filteredSet
                = persons
                .stream()//Stream<Person>
                .filter(p -> p.name.startsWith("А"))//Stream<Person>
                .collect(
                        Collectors.toSet()
                );//Set<Person>
        System.out.println(filteredSet);
        */

        /*System.out.println("======= Простое преобразование в Map с группировкой по возрасту ========");
        Map<Integer, List<Person>> personsByAge = persons
                .stream()//Stream<Person>
                .collect(
                        Collectors.groupingBy(
                                p -> p.age
                        )
                );

        personsByAge
                .forEach(
                        (age, p) -> System.out.format("age %s: %s\n", age, p)
                );


        System.out.println("======= Простое преобразование в Map с группировкой по имени ========");
        Map<String, List<Person>> personsByName = persons
                .stream()
                .collect(
                        Collectors.groupingBy(
                                p -> p.name
                        )
                );

        personsByName
                .forEach(
                        (name, p) -> System.out.format("name %s: %s\n", name, p)
                );
                */


        /*System.out.println("======= Преобразование Stream в double ========");
        Double averageAge = persons
                .stream()//Stream<Person>
                .collect(
                        Collectors.averagingInt(
                                p -> p.age
                        )
                );//Double

        System.out.println(averageAge);

        System.out.println("======= Преобразование Stream в double ========");
        IntSummaryStatistics ageSummary
                = persons
                .stream()//Stream<Person>
                .collect(
                        Collectors.summarizingInt(p -> p.age)
                );

        //System.out.println(ageSummary);
        System.out.println(ageSummary.getMax());
        */


        /*System.out.println("======= Использование произвольной функции слияния элементов ========");
        Map<Integer, String> map = persons
                .stream()//Stream<Person>
                .collect(
                        Collectors.toMap(
                            p -> p.age,
                            p -> p.name,
                            (name1, name2) -> name1 + "; " + name2)
                );
        map.forEach(
                (age, s) -> System.out.println(age  +" : " + s)
        );


        System.out.println("======= Использование произвольной функции слияния элементов 2 ========");
        Map<String, Integer> map2 = persons
                .stream()
                .collect(
                        Collectors.toMap(
                            p -> p.name,
                            p -> p.age,
                            (age1, age2) -> Math.max(age1, age2))
                );
        System.out.println(map2);*/


        System.out.println("======= Использование произвольного Collector ========");
        Collector<Person, StringJoiner, String> personNameCollector
                = Collector.of(
                        () -> {
                            System.out.println("!вызван поставщик!");
                            return new StringJoiner(" | ");
                        },//supplier поставщик
                        (StringJoiner j, Person p) -> {
                            System.out.println("!вызван накопитель: " + j.toString() + " and " + p.name);
                            j.add(p.name.toUpperCase());
                        }, // accumulator накопитель
                        (StringJoiner j1, StringJoiner j2)
                        -> {
                            System.out.println("!вызван совместитель: " + j1.toString() + " and " + j2.toString());
                            return j1.merge(j2);
                        }, // combiner комбинатор/совместитель ???????????????
                        (StringJoiner j) -> {
                            System.out.println("!завершитель : " + j.toString());
                            return j.toString();
                        });                // finisher завершитель


        String names = persons
                .stream()//Stream<Person>
                .collect(
                        personNameCollector
                );//String

        System.out.println(names);

    }

    private static void flatMapExample(List<Boss> bosses) {
        System.out.println("======= Получение Stream для всех подчиненных ========");
        bosses.stream()//Stream<Boss>
                .flatMap(
                        b -> {
                            return b.employees.stream();
                        })//Stream<Employee>
                .forEach(
                        e -> System.out.println("Foreach : " + e.name)
                );
        
        System.out.println("======= Получение Stream для всех друзей подчиненных ========");
        bosses.stream()//Stream<Boss>
                .flatMap(
                        b -> {
                            return b.employees.stream();
                        })//Stream<Employee>
                .flatMap(e -> {
                    return  e.friends.stream();
                })//Stream<Employee>
                .forEach(
                        e
                        -> {
                    System.out.println("Foreach : " + e.name);
                });

    }

    private static void reduceExample(List<Person> persons) {

        /*System.out.println("======= Редуцирование нескольких элементов в один с наибольшим возрастом ========");
        persons
                .stream()//Stream<Person>
                .reduce(
                        (Person p1, Person p2) ->
                        {
                            System.out.println(p1.name + " сравниваем с " + p2.name);
                            return p1.age > p2.age ? p1 : p2;
                        }
                )
                .ifPresent(System.out::println);*/
        
        /*System.out.println("======= Передача итогового значения и функции accumulator ========");
        Person result = persons
                .stream()//Stream<Person>
                .reduce(
                        new Person("", 0),
                        (Person p1, Person p2) -> {
                            System.out.format("совместитель/комбинатор: name1=%s; name2=%s\n", p1.name, p2.name);
                            p1.age += p2.age;
                            p1.name += p2.name;
                            return p1;
                        }
                );

        System.out.format("name=%s; age=%s\n", result.name, result.age);*/



        System.out.println("======= Передача итогового значения, функции редукции и функции combiner ========");
        Integer ageSum = persons
                .stream()
                .reduce(0,
                        (Integer sum, Person p) -> {
                            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
                            return sum += p.age;
                        },
                        (Integer sum1, Integer sum2) -> {
                            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                            return sum1 + sum2;//??????????????????
                        });
        System.out.println("Sum=" + ageSum);

        System.out.println("======= Использование параллельного Stream ========");
        Integer ageSumParallel = persons
                .parallelStream()
                .reduce(0,
                        (sum, p) -> {
                            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
                            return sum += p.age;
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                            return sum1 + sum2;
                        });
        System.out.println("Sum=" + ageSumParallel);
    }

    private static void parallelStreamExample(List<Person> persons) {

        /*ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println(commonPool.getParallelism());*/
        // изменение кол-ва потоков через параметры JVM -Djava.util.concurrent.ForkJoinPool.common.parallelism=5


        List<String> myList =
                IntStream.range(1, 10)
                        .mapToObj(i -> "a" + i )
                        .collect(Collectors.toList());
/*
        System.out.println("======= Выполнение операций в нескольких потоках (параллельно) ========");

        long start = System.currentTimeMillis();
        myList
                .parallelStream()
                .filter(s -> {
                    //System.out.format("filter: %s \t[%s]\n",                            s, Thread.currentThread().getName());
                    return true;
                })
                .map(s -> {
                    //System.out.format("map: %s \t[%s]\n",                            s, Thread.currentThread().getName());
                    return s.toUpperCase();
                }).forEach(s ->
                {
                    System.out.format("forEach: %s \t[%s]\n", s, Thread.currentThread().getName());
                    return;
                });
        
        System.out.println(  "ms=" + (System.currentTimeMillis() - start));

        System.out.println("======= Выполнение операций в одном потоке ========");
        long start = System.currentTimeMillis();
        myList
                .stream()
                .filter(s -> {
                    //System.out.format("filter: %s \t[%s]\n",                            s, Thread.currentThread().getName());
                    return true;
                })
                .map(s -> {
                    //System.out.format("map: %s \t[%s]\n",                           s, Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .forEach(s ->
                    {
                        System.out.format("forEach: %s \t[%s]\n", s, Thread.currentThread().getName());
                        return;
                    });
        
        System.out.println( "ms=" + (System.currentTimeMillis() - start));

*/
       /*System.out.println("======= Выполнение сортировки в нескольких потоках ========");
        Arrays.asList("a1", "a2", "b1", "c2", "c1")
                .parallelStream()
                .filter(s -> {
                    System.out.format("filter: %s \t\t[%s]\n",
                            s, Thread.currentThread().getName());
                    return true;
                })
                .map(s -> {
                    System.out.format("map: %s \t\t[%s]\n",
                            s, Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .sorted((s1, s2) -> {
                    System.out.format("sort: %s <> %s \t\t[%s]\n",
                            s1, s2, Thread.currentThread().getName());
                    return s1.compareTo(s2);
                })
                .forEach(s -> System.out.format("forEach: %s \t\t[%s]\n",
                        s, Thread.currentThread().getName()));*/

        
        System.out.println("======= Выполнение reduce в нескольких потоках ========");
        persons
                .parallelStream()
                .reduce(0,
                        (sum, p) -> {
                            System.out.format("acc: sum=%s; person=%s \t\t[%s]\n",
                                    sum, p, Thread.currentThread().getName());
                            return sum += p.age;
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner: sum1=%s; sum2=%s \t\t[%s]\n",
                                    sum1, sum2, Thread.currentThread().getName());
                            return sum1 + sum2;
                        });
    }
}
