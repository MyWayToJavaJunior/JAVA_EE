package ru.sstu.collections;


import java.util.*;

/**
 * Created by Shvarts on 19.10.2016.
 */
public class ColMain {

    public static void main(String[] args) {
        //Collection - набор значений, Map - набор пар ключ-значение

        //Collection <- List, Set, Queue, Deque
        //Map

        //List
        /*List<String> arrayList = new ArrayList<>();
        listOperations(arrayList);
        List<String> linkedList = new LinkedList<>();
        listOperations(linkedList);*/


        //Map
        /*Map<String, Integer> hashMap = new HashMap<>();
        mapOperations(hashMap);
        Map<String, Integer> treeMap = new TreeMap<>();
        mapOperations(treeMap);*/

        //Set
        /*System.out.println("========SET===========");
        Set<String> set1 = new HashSet<>();
        set1.add("январь");
        set1.add("август");
        set1.add("июнь");
        set1.add("июль");
        for(String s : set1)
        {
            System.out.println(s);
        }//????

        set1.add("июнь");
        System.out.println("Добавили ещё июнь:");
        for(String s : set1)
        {
            System.out.println(s);
        }*/

        Set<Engineer> engs = new HashSet<>();
        for (int i = 0; i < 7; i++) {
            Engineer newEng = new Engineer();
            newEng.fio = "Инж. #" + (i+1);
            engs.add(newEng);
        }

        Random r = new Random();
        Map<Weekday,Engineer> m = new HashMap<>();
        for (Weekday wd : Weekday.values()) {
            if(!m.containsKey(wd))
            {
                Engineer chosenEng = (Engineer) (engs.toArray()[r.nextInt(engs.size())]);
                m.put(wd, chosenEng);
                engs.remove(chosenEng);
            }
        }

        for(Map.Entry<Weekday,Engineer> en : m.entrySet())
        {
            System.out.println(en.getKey() + " " + en.getValue().fio);
        }




    }

    public static void listOperations(List<String> list1)
    {
        for (int i = 0; i < 10; i++) {
            list1.add("строка №"+(i+1));
        }
        for (String s : list1) {
            System.out.println(s);
        }
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }

        //добавление элементов
        list1.add("строка №11");//в конец
        list1.add(1,"строка №1.5");// на заданную позицию
        for (String s : list1) {
            System.out.println(s);
        }

        //Чтение-запись существующих элементов
        System.out.println("по индексу 6: " + list1.get(6));
        list1.set(6, "Новая строка");
        System.out.println("по индексу 6: " + list1.get(6));


        //удаление элементов
        list1.remove(6);//по индексу
        System.out.println("по индексу 6: " + list1.get(6));
        list1.remove("строка №10");//по значению
        System.out.println("Удалили строку №10");
        for (String s : list1) {
            System.out.println(s);
        }

        //проверка наличия
        if(list1.contains("Новая строка")) System.out.println("ЕСТЬ НОВАЯ СТРОКА");
    }

    public static void mapOperations(Map<String, Integer> map1)
    {
        map1.put("январь", 91);
        map1.put("июль", 167);
        map1.put("февраль", 191);
        map1.put("июнь", 12);
        map1.put("август", 90);
        System.out.println("EntrySet:");
        for(Map.Entry<String, Integer> en : map1.entrySet())
        {
            System.out.println(en.getKey() + " " + en.getValue());
        }// ????
        System.out.println("KeySet:");
        for(String key : map1.keySet())
        {
            System.out.println(key);
        }
        //Values
        int sum = 0;
        for(Integer value : map1.values())
        {
            //System.out.println(value);
            sum+= value;
        }
        System.out.println("sum = " + sum);
        //Перезапись
        System.out.println("Перезапись:");
        map1.put("июнь", 1999);
        for(Map.Entry<String, Integer> en : map1.entrySet())
        {
            System.out.println(en.getKey() + " " + en.getValue());
        }

        //Удаление
        System.out.println("Удаление:");
        map1.remove("январь");
        for(Map.Entry<String, Integer> en : map1.entrySet())
        {
            System.out.println(en.getKey() + " " + en.getValue());
        }
        System.out.println("Удаление c 2 аргументами:");
        map1.remove("февраль", 191);
        for(Map.Entry<String, Integer> en : map1.entrySet())
        {
            System.out.println(en.getKey() + " " + en.getValue());
        }

        //проверка наличия
        if(map1.containsKey("июнь")) System.out.println("ЕСТЬ ИЮНЬ");
        if(map1.containsValue(90)) System.out.println("ЕСТЬ 90");
    }
}
