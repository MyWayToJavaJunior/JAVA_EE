package ru.sstu.robo;

/**
 * Created by Shvarts on 31.10.2016.
 */
public class DriverTest<T extends Person> implements MyTest<Person> {
    public boolean test(Person t){
        if (t.getAge() >= 18) {
            return true;
        }
        return false;
    }
}
