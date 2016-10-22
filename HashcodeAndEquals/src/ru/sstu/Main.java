package ru.sstu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here

        HashMap<Waiter, ArrayList<Order>> waitersOrders = new HashMap<>();
        Random r = new Random();
        for(int i = 0; i < 5; i++)
        {
            Waiter w = new Waiter();
            w.setFio("Официант №" + (i+1));
            waitersOrders.put(w, new ArrayList<>());

            for(int j = 0; j < r.nextInt(5); j++)
            {
                Order o = new Order();
                o.setContent("Заказ №" + (j+1) + " официанта №" + (i+1));
                waitersOrders.get(w).add(o);
            }
        }

        for(Map.Entry<Waiter, ArrayList<Order>> en : waitersOrders.entrySet())
        {
            System.out.println("Официант: " + en.getKey().getFio());
            System.out.println("Заказы:");
            for(Order o : en.getValue())
            {
                System.out.println("Заказ: " + o.getContent());
            }
        }

    }
}
