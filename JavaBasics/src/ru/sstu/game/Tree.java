package ru.sstu.game;

import ru.sstu.geom.Drawable3D;

/**
 * Created by Shvarts on 14.10.2016.
 */
public class Tree extends GameObject implements Drawable3D{

    public void drawSuper3D() {
        System.out.println("Дерево в супер 3д");
    }

    @Override
    public void drawMoreSuper3D() {
        System.out.println("Дерево в ещё более супер 3д");
    }
}
