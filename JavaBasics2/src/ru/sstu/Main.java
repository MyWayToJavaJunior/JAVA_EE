package ru.sstu;

import java.io.Console;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    // write your code here

        Person p = new Person();
        p.setGender(89349);

        p.setEnumGender(Gender.UNDEFINED);
        //p.setEnumGender(new Gender());
        System.out.println(p.getEnumGender());
        System.out.println(p.getEnumGender().getRussianName());
        p.setLicense(Person.DrivingLicense.B);

        if(p.getEnumGender() == Gender.FEMALE)
        {
            System.out.println("Цветы");
        }
        else if(p.getEnumGender() == Gender.UNDEFINED)
        {
            System.out.println("Чуть меньше цветов");
        }

        /*switch(p.getEnumGender())
        {
            case Gender.FEMALE:
                break;
            case Gender.MALE:
                break;
        }*/

        Person.Head h = p.getHead();// = new Person.Head();
        System.out.println(Person.Head.eyesCount);
        p.talk();

        Bird bird = new Bird();
        Tank tank = new Tank();
        moveObject(bird);
        moveObject(tank);

        Moveable mov = new Moveable() {
            @Override
            public void move() {
                System.out.println("АБСТРАКТНЫЙ ДВИГАТЕЛЬ!");
            }
        };
        moveObject(mov);

        moveObject(new Moveable() {
            @Override
            public void move() {
                System.out.println("ЕЩЁ ОДИН АНОНИМНЫЙ ДВИГАТЕЛЬ");
            }

            public void method1()
            {

            }
        });

        //Классы-обертки
        int b = Integer.MAX_VALUE;
        System.out.println(b);

        String s = "123";
        int sInt = Integer.parseInt(s);
        System.out.println(sInt);

        double d1 = 8.9;
        Double d2 = new Double(8.9);
        Double d3 = Double.valueOf(8.9);
        Double d4 = 8.9;

        System.out.println(d2 + d3);
        System.out.println(d2 / d3);
        System.out.println(d2 - d3);


        Integer i = 16;
        printObject(b);
        printObject(d2);
        printObject(i);
        printObject(p);


        Random r = new Random();
        int randInt = r.nextInt(100); //случайное число от 0 до 99 включительно

    }

    public static void moveObject(Moveable m)
    {
        System.out.println("Начинается движение...");
        m.move();
    }

    public static void printObject(Object ob)
    {
        System.out.println(ob);
    }
}
