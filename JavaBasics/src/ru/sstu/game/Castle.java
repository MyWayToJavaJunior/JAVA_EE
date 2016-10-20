package ru.sstu.game;

/**
 * Created by Shvarts on 14.10.2016.
 */
public class Castle extends GameObject {

    public Castle()
    {
        //super.draw();
        //super(18, 9);
        System.out.println("ЗАМОК СОЗДАЛСЯ");
    }

    public void draw()
    {
        super.moveTo();
        System.out.println("РИСОВАНИЕ ЗАМКА");
        super.draw();
    }

    public void defend()
    {

    }
}
