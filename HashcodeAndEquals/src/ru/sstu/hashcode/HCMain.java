package ru.sstu.hashcode;

import ru.sstu.Waiter;

import java.util.*;

/**
 * Created by Shvarts on 21.10.2016.
 */
public class HCMain {
    public static void main(String[] args) {
        int a = 123, b = 123;
        if(a == b) System.out.println("А и Б равны");

        Waiter w1 = new Waiter();
        Waiter w2 = new Waiter();
        if(w1 == w2) System.out.println("Все официанты равны");
        if(w1.equals(w2)) System.out.println("Все офицанты равны через equals 1");
        if(w2.equals(w1)) System.out.println("Все офицанты равны через equals 2");

        w1.setFio("Иван");
        w2.setFio("Иван");
        if(w1.equals(w2)) System.out.println("Все офицанты равны через equals 1");
        if(w2.equals(w1)) System.out.println("Все офицанты равны через equals 2");


        System.out.println("Hashcode:");
        System.out.println(w1.hashCode());
        System.out.println(w2.hashCode());
        System.out.println(w1.hashCode());

        System.out.println(Integer.MAX_VALUE + " " +  Integer.MIN_VALUE);


        if(w1.hashCode() == w2.hashCode()) System.out.println("Объекты равны по хешкоду");

        Waiter w3 = w1;

        if(w1.hashCode() == w3.hashCode()) System.out.println("Объекты 1 и 3 равны по хешкоду");
        if(w1.equals(w3)) System.out.println("Объекты 1 и 3 равны по equals");
        if(w1 == w3) System.out.println("Объекты 1 и 3 равны по ==");

        Waiter.Gender g = Waiter.Gender.FEMALE;
        Waiter.Gender g1 = Waiter.Gender.MALE;
        Waiter.Gender g2 = Waiter.Gender.MALE;
        if(g == Waiter.Gender.FEMALE) System.out.println("Женщина 1");
        if(g1 == Waiter.Gender.FEMALE) System.out.println("Женщина 2");
        if(g2 == Waiter.Gender.FEMALE) System.out.println("Женщина 3");

        Integer i1 = Integer.valueOf(18);
        Integer i2 = Integer.valueOf(18);
        Integer i3 = Integer.valueOf(19);
        if(i1 == i2) System.out.println("1=2");
        if(i1.equals(i2)) System.out.println("1eq2");
        if(i1 == i3) System.out.println("1=3");

        Integer i4 = new Integer(15);
        Integer i5 = new Integer(15);
        if(i4 == i5) System.out.println("4=5");
        if(i4.equals(i5)) System.out.println("4eq5");


        Set<Waiter> ws = new HashSet<>();
        ws.add(w1);
        ws.add(w2);
        ws.add(w3);

        System.out.println("Официанты в Set:");
        for (Waiter w:
             ws) {
            System.out.println(w.getFio());
        }

        Map<Waiter, String> ws2 = new HashMap<>();
        ws2.put(w1, "srgrg1");
        ws2.put(w2, "srgrg2");
        ws2.put(w3, "srgrg3");
        System.out.println("Ws2:");
        System.out.println(ws2.size());
        for(String s : ws2.values())
        {
            System.out.println(s);
        }
        for (Waiter w: ws2.keySet()) {
            System.out.println(w.hashCode());
        }

        System.out.println(w1.hashCode());
        System.out.println(w2.hashCode());
        System.out.println(w3.hashCode());


        Set<String> ss = new TreeSet<>();
        ss.add("июнь");
        ss.add("июль");
        ss.add("февраль");
        ss.add("август");
        ss.add("январь");
        for (String s:ss
             ) {
            System.out.println(s.hashCode() + " " + s);
        }

    }

}
