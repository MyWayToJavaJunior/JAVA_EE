package ru.sstu;

public class Main {

    public static void main(String[] args) {
        // write your code here

        byte byteVar = 99;
        short shortVar = -156;
        int intVar = 13;
        long longVar = 13352537647L, longVar2 = 12_2_1_2_121_212L;

        float floatVar = 0.89F;
        double doubleVar = -1e-9;

        char charVar = 'r';

        boolean boolVar = false;

        System.out.println(floatVar);

        if(boolVar)
            System.out.println("Первая ветка из двух");
        else
            System.out.println("Вторая ветка из двух");

        if(boolVar)
            System.out.println("Первая ветка из четырех");
        else if(floatVar > 10)
            System.out.println("Вторая ветка из четырех");
        else if(intVar > 107)
            System.out.println("Третья ветка из четырех");
        else System.out.println("Последняя ветка из четырех");

        switch(intVar+2)
        {
            case 1:
                System.out.println("Один");
                break;
            case 2:
                System.out.println("Два");
                break;
            case 3:
                System.out.println("Три");
                break;
            default:

        }

        while(intVar-- > 0)
        {
            System.out.println("while intvar =" + intVar);
        }

        do {
            System.out.println("do-while intvar =" + intVar);
        }
        while(intVar++ < 10);

        for(int i = 0; i < 10; i++)
        {
            System.out.println("i=" + i);
        }

        //Массивы
        int[] arr;
        arr = new int[10];
        arr[0] = 78;
        System.out.println("arr[0]=" + arr[0]);
        arr = new int[]{1, 3, 5, 6, 4, 6, 1, 9, 3};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + "=" + arr[i]);
            arr[i] = 100;
        }
        for ( int abc : arr) {
            System.out.println(abc);
            abc = 0;
        }
        System.out.println("Ещё раз:");
        for ( int abc : arr) {
            System.out.println(abc);
        }

        //Строки
        String s = "rgirgiuhuh 5eyoijr5oiyj5yotijojoje5 oij";

        System.out.println(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }
        System.out.println("Битовые:");
        System.out.println( 5 & 7 );
        // 101
        // 111
        // 101
        System.out.println( 5 | 7 );
        // 101
        // 111
        // 111
        System.out.println( 5 + 7 );
        System.out.println( 5 + "" + 7 );
        System.out.println( '5' + '7' );
        System.out.println("a" + "b");
        System.out.println(7);
    }
}
