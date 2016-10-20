package ru.sstu;

import sun.net.www.content.text.Generic;

public class Main {

    public static void main(String[] args) {
	// write your code here


        Box b1 = new Box(new Apple());
        //b1.content = new Integer(1);
        ((Apple)(b1.content)).lay();

        GenericBox<Apple> b2 = new GenericBox();
        b2.content = new Apple();
        b2.content.lay();

        GenericBox<String> b3 = new GenericBox<String>();
        b3.content = "abefuf";
        System.out.println(b3.content.length());



        GenericTypedBox<Apple> b4 = new GenericTypedBox<>();
        b4.content = new Apple();
        b4.content.lay();

        /*GenericTypedBox<String> b5 = new GenericTypedBox<String>();
        b5.content = "abefuf";
        System.out.println(b5.content.length());*/

        GenericTypedBox<PineApple> b6 = new GenericTypedBox<>();
        b6.content = new PineApple();
        b6.content.lay();


        //b2.content = new Integer(1);
        //b2.content.l

        BoxForPair<String, Integer> bfp1 = new BoxForPair<>();
        bfp1.first = "eferffe";
        bfp1.second = new Integer(78);
        System.out.println(bfp1.first.length());
        System.out.println(bfp1.second.intValue());
    }
}
