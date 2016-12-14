package ru.sstu;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Shvarts on 12.12.16.
 */
public class MyBean implements Serializable{

    Random r= new Random();
    public MyBean()
    {
        //ANY CODE!!!
    }

    public MyBean(int a)
    {
        //ANY OTHER CODE!!!
    }

    private String message1 = "a b c d";
    private String message2 = "<i>курсивный текст</i>";

    public String getMessage1() {
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public boolean getRandomBoolean()
    {
        return r.nextBoolean();
    }

    public int getRandomInt()
    {
        int res  = r.nextInt();
        System.err.println("res = " + res + ", " + new Date().toString());
        return res;
    }

    public List<String> getMessages()
    {
        return Arrays.asList("a", "b", "c", "erjgheriugh");
    }

    public List<Date> getDates()
    {
        return Arrays.asList(

                new Date(System.currentTimeMillis() - 10000),
                new Date(System.currentTimeMillis() + 10000),
                new Date()
        );
    }

    public int getWrongNumber()
    {
        return 10/0;
    }
}
