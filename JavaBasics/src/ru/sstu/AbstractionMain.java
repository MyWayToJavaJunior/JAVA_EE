package ru.sstu;

import ru.sstu.game.Tree;
import ru.sstu.geom.Circle;
import ru.sstu.geom.Drawable3D;
import ru.sstu.geom.Figure;
import ru.sstu.geom.Triangle;

/**
 * Created by Shvarts on 14.10.2016.
 */
public class AbstractionMain {

    public static void main(String[] args) {

        /*Figure f = new Figure();
        f.draw3D();*/
        Triangle t = new Triangle();
        t.draw3D();
        t.draw();
        t.move();

        /*Circle c = new Circle();
        c.draw3D();*/
        Figure f1 = new Triangle();
        f1.draw3D();

        Triangle t1 = new Triangle();
        t1.drawMoreSuper3D();
        t1.drawSuper3D();

        Drawable3D d3d = new Triangle();
        Drawable3D d3d2 = new Tree();
        drawDrawable3D(d3d);
        drawDrawable3D(d3d2);

        System.out.println(Drawable3D.y);
        System.out.println(Drawable3D.x);

        d3d.paint();

    }

    public static void drawDrawable3D(Drawable3D d3d)
    {
        d3d.drawSuper3D();
    }
}
