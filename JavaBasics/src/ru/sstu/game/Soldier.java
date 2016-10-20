package ru.sstu.game;

/**
 * Created by Shvarts on 14.10.2016.
 */
public class Soldier extends GameObject{

    public static final int chromosomeCount = 46;
    public final int age;


    public Soldier(int newAge)
    {
        age = newAge;


    }

    public void draw()
    {
        //age=18;
        final int a = 1;
        //a = 1;
        final int b;
        this.x = 9;
        System.out.println("РИСОВАНИЕ СОЛДАТА");

        b = 19;
        System.out.println(b);
    }

    final public void shoot()
    {
        System.out.println("СТРЕЛЬБА!");
    }

}
