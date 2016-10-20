package ru.sstu.game;

/**
 * Created by Shvarts on 14.10.2016.
 */
public class GameObject {
    double x, y;

    private static int count = 0;

    public static void printCount()
    {
        System.out.println("Count=" + count);
        //x++;
        //draw();
    }

    public static void printCountAndDraw(GameObject g)
    {
        System.out.println("Count=" + count);
        g.draw();
        //x++;
        //draw();
    }

    public GameObject()
    {
        System.out.println("КОНСТРУКТОР !");
        count++;
        printCount();
    }

    public GameObject(double x, double y)
    {
        this.x = x;
        this.y = y;
        System.out.println("КОНСТРУКТОР !");
        count++;
        printCount();
    }

    public void moveTo(double newX, double newY)
    {
        System.out.printf("Перемещаем объект из точки({0},{1}) в точку ({2},{3})", x, y, newX, newY);
        x = newX;
        y = newY;
    }

    public void moveTo(int newX, int newY)
    {
        System.out.printf("Перемещаем объект из точки({0},{1}) в точку ({2},{3})", x, y, newX, newY);
        x = newX;
        y = newY;
    }

    public void moveTo()
    {
        System.out.printf("Стою");

    }

    public void draw()
    {
        System.out.println("Рисование объекта ... ");
        //printCount();
    }

}
