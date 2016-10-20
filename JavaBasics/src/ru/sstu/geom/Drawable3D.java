package ru.sstu.geom;

/**
 * Created by Shvarts on 14.10.2016.
 */
public interface Drawable3D{

    public int x = 0;
    public void drawSuper3D();
    public void drawMoreSuper3D();

    default void paint()
    {
        System.out.println("Def paint");
    }

    public static int y = 0;

    public static void run(){
        System.out.println("efefefefe");
    }

}
