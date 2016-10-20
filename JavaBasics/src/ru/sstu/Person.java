package ru.sstu;

/**
 * Created by Shvarts on 12.10.2016.
 */
public class Person {

    protected int age = 18;
    String name = "Иван";


    public void run()
    {
        System.out.println("Бегу!");
    }

    public void talk(String phrase)
    {
        System.out.println(phrase);
    }

}
