package ru.sstu;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //methodReferences();
        //simpleExamples();
        //advancedUnderstanding();
        reusingStreams();
    }


    static class MyClass
    {
        public String message = "abc";
        public int compare(String s1, String s2)
        {
            return -1;
        }
        public void print(String s)
        {
            System.out.println("Вывод : " + s + ", сообщение : " + message);
        }

        public static void printStatic(String s)
        {
            System.out.println("Статический метод вывода : " + s);
        }
    }

    private static void methodReferences()
    {
        List<String> myList
                = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        System.out.println("Классический for");
        for(String s : myList)
        {
            System.out.println(s);
        }
        System.out.println("Метод forEeach и лямбда");
        myList.forEach(
                s -> System.out.println(s)
        );

        System.out.println("Метод forEeach и ссылка на метод (method reference");

        myList.forEach(
                System.out::println
        );



        System.out.println("Ссылки на методы самописного класса");
        MyClass mc = new MyClass();
        mc.message = "message 1";


        myList.sort(mc::compare);
        myList.sort((s1, s2) -> -1 );

        mc.print("ABCDE");
        myList.forEach(mc::print);

        myList.forEach(MyClass::printStatic);


        MyClass mc2 = new MyClass();
        mc2.message = "message 2";
        myList.forEach(mc2::print);
        //myList.forEach(System.out::println);


        Consumer<String> cons = mc::print;
        Consumer<String> cons2 = s -> System.out.println("Printing : " + s);

        Comparator<String> comp = mc::compare;

        myList.sort(comp);
        myList.forEach(cons);
        myList.forEach(cons2);

        System.out.println(cons.getClass());
        System.out.println(cons2.getClass());
        System.out.println(comp.getClass());
        System.out.println(mc.getClass());
    }

    private static void simpleExamples() {
        System.out.println("======= Типичный пример использования Stream ========");
        List<String> myList
               = new ArrayList<>();
        myList.add("b1");
        myList.add("a2");
        myList.add("c1");
        myList.add("a1");
        myList.add("d1");
        myList.add("a3");


        myList.stream()//Stream<String>
                .sorted()//Stream<String>
                .forEach(System.out::println);




        System.out.println("======= Использование Stream на основе коллекции List ========");
        Arrays.asList("a2", "a1", "a3")//List<String>
                .stream()//Stream<String>
                .sorted()//Stream<String>
                .forEach(System.out::println);

        System.out.println("======= Использование Stream на основе перечня значений ========");
        Stream.of("a2", "a1", "a3")//Stream<String>
                .sorted()
                .forEach(System.out::println);



        /*System.out.println("======= Использование специальных Stream для различных примитивных типов ========");
        IntStream.range(1, 100)//IntStream
                .forEach(System.out::println);

        DoubleStream.of(0, 0.78, -0.98, 19.145)//DoubleStream
                .forEach(System.out::println);*/


        System.out.println("======= Stream для примитивных типов используют и специальные функциональные интерфейсы для примитивных типов ========");

        Arrays.stream(new int[]{1, 2, 3})//IntStream
                //.map(n -> 2 * n + 1)
                .average()
                .ifPresent(System.out::println);
        //.forEach(System.out::println);


        System.out.println("======= Можно преобразовывать обычный Stream к Stream примитивных типов ========");
        Stream.of("a1zz", "a7zzzzz", "a3c")//Stream<String>
                //.map(s -> s.substring(1))
                .mapToInt(s -> s.length())//преобразование, результат IntStream
                .forEach(System.out::println);


        System.out.println("======= Также можно преобразовывать Stream примитивных типов к объектному Stream ========");
        IntStream.range(1, 10)
                .mapToObj(i -> "a" + i)//Stream<String>
                .forEach(System.out::println);



        System.out.println("======= Пример преобразования в обе стороны ========");
        Stream.of(3.16, 1.5, 2.7)//Stream<Double>
                .mapToInt(Double::intValue)//IntStream
                .mapToObj(i -> "целая часть оставшаяся: " + i)//Stream<String>
                .forEach(System.out::println);

        System.out.println("======= Метод map ========");
        IntStream.range(1, 10)//IntStream
                .map(i -> i*12)//IntStream
                .forEach(System.out::println);

    }

    private static void advancedUnderstanding() {

        /*System.out.println("======= Какой порядок выполнения кода? ========");
        Stream.of("d2", "a2", "b1", "b3", "c")//Stream<String>
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return new Random().nextBoolean();
                })
                .map(s -> s+"!")
                .forEach(s -> System.out.println(" foreach: " +s));




        System.out.println("======= Снижение количества итераций ========");
        Stream.of("d2", "a2", "a1", "b3", "c", "a8")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                //.forEach(System.out::println);
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });

        System.out.println("А теперь неоптимально:");
        Stream.of("d2", "a2", "a1", "b3", "c", "a8")

                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s ->
                {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(System.out::println);*/
        /*
        Stream.of("a2", "a2", "a1", "b3", "c", "a8")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                //.forEach(System.out::println);
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });

        System.out.println("======= Пример изменения порядка операций: ДО ========");
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));*/


        /*System.out.println("======= Пример изменения порядка операций: ПОСЛЕ ========");
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

*/

        System.out.println("======= Второй пример изменения порядка операций: ДО ========");
        Stream.of("d2", "a2", "b1", "a3", "c")
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        System.out.println("======= Второй пример изменения порядка операций: ПОСЛЕ ========");
        Stream.of("d2", "a2", "b1", "a3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));



    }

    private static void reusingStreams() {
        /*System.out.println("======= Попытка заново вызвать терминальную операцию у Stream ========");
        Stream<String> stream
                = Stream.of("d2", "a2", "a1", "b3", "a");
                //.filter(s -> s.startsWith("a"));

        stream.anyMatch(s ->
        {
            return s.startsWith("a");
        });*/
        /*stream.anyMatch(s ->
        {
            return s.startsWith("b");
        });*/

        /*System.out.println("======= Корректная попытка заново вызвать терминальную операцию у Stream ========");
        Supplier<Stream<String>> streamSupplier
                = () -> Stream.of("aa2", "a2", "b1", "a3", "c").filter(s -> s.startsWith("a"));

        streamSupplier.get()//Stream<string> : "a2", "a3"
                .anyMatch(s -> {
                    System.out.println(s);
                    return true;
            });
        System.out.println("==============");
        streamSupplier.get()//Stream<string> : "a2", "a3"
                .forEach(System.out::println);

*/
        Function<List<String>, Stream<String>> streamFromList =
                (list) -> list.stream()
                        .filter(s -> s.startsWith("a"))
                        .map(s -> s + "!");
        System.out.println("==============");
        streamFromList.apply(
                    Arrays.asList("d2", "a2", "b1", "a3", "a")//List<String>
                )//Strean<String>
                .sorted()
                .forEach(System.out::println);
        System.out.println("==============");
        streamFromList.apply(
                    Arrays.asList("a2", "d2")
                )
                .forEach(System.out::println);

    }

}
