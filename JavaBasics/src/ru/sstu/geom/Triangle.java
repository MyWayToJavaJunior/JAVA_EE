package ru.sstu.geom;

/**
 * Created by Shvarts on 14.10.2016.
 */
public class Triangle extends Figure implements Drawable3D{
    public void draw() {
        System.out.println("Треугольник");
        //x++;
    }
    public void draw3D() {
        System.out.println("Треугольник в 3D");
    }


    public void drawSuper3D() {
        System.out.println("drawSuper3D");
    }

    public void drawMoreSuper3D() {
        System.out.println("drawMoreSuper3D");
    }

}
