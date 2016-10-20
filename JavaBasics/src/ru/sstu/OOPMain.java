package ru.sstu;

import com.sun.org.apache.bcel.internal.generic.GOTO;
import ru.sstu.game.Castle;
import ru.sstu.game.GameObject;
import ru.sstu.game.NavySeal;
import ru.sstu.game.Soldier;

/**
 * Created by Shvarts on 12.10.2016.
 */
public class OOPMain {
    public static void main(String[] args) {
        /*Person p = new Person();
        p.run();
        p.talk("Привет");
        p.age = 90;
        p.name = "Петр";

        Person p2 = new Person();
        p2.age = 50;
        p2.name = "Мария";
        System.out.println(p.age + " " + p.name);
        System.out.println(p2.age + " " + p2.name);


        Teacher t = new Teacher();
        t.name = "Учитель1";
        t.age = 50;
        t.run();
        t.teach();
        t.talk("rgrtg");*/


        //Динамический полиморфизм
        GameObject go = new GameObject();

        GameObject go2 = new Castle();
        GameObject go3 = new Soldier(18);
        //go.x = 9;
        /*go2.draw();
        go3.draw();*/

        /*Castle c1 = new GameObject();
        c1.defend();*/

        //Castle c2 = (Castle)go2;
        //c2.draw();

        /*Castle c3 = (Castle)go3;
        c3.draw();*/

        /*Castle c4 = (Castle)go;
        c4.draw();*/

        //Статический полиморфизм = перегрузка методов
        go.moveTo();
        go.moveTo(8.6, 9.7);
        go.moveTo(14, 16);

        //Статические поля и методы
        /*go.count++;
        go2.count++;
        go3.count += 20;
        System.out.println(go.count + " " + go2.count + " " +  go3.count);
        System.out.println(GameObject.count);
        GameObject.count++;
        System.out.println(GameObject.count);
        System.out.println(go.count + " " + go2.count + " " +  go3.count);*/
        go.draw();
        GameObject.printCount();
        System.out.println("Статический метод принимает объект");
        GameObject.printCountAndDraw(go);
        System.out.println("====");
        GameObject.printCountAndDraw(go2);
        System.out.println("====");
        GameObject.printCountAndDraw(new Soldier(18));
        System.out.println("====");

        //Final

        Soldier ns = new Soldier(18);
        ns.shoot();
        Soldier s = new Soldier(49);
        s.shoot();
        System.out.println(s.age);
        System.out.println(ns.age);
        System.out.println(Soldier.chromosomeCount);
        //NavySeal ns2 = new




    }
}
