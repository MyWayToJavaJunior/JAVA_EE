package ru.sstu;

/**
 * Created by Shvarts on 12.10.2016.
 */
class Teacher extends Person {


    /*
        переопределение (overriding) метода run() родительского класса Person
     */
    public void run()
    {
        System.out.println("Бегу, я - учитель! Мне " + age +" лет");
    }

    public void teach()
    {
        System.out.println("Учу!");
    }
}
