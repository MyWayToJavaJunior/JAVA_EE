package ru.sstu.geom;

/**
 * Created by Shvarts on 14.10.2016.
 */
abstract public class Figure {

    public double area = 0;

    abstract public void draw();
    abstract public void draw3D();


    public void move()
    {
        System.out.println("Движение");
        area = 0;
    }

    public static void run()
    {
        System.out.println("Run");
    }
}
