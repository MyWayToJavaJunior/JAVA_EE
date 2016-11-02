package ru.sstu.robo;

/**
 * Created by Shvarts on 31.10.2016.
 */
public class SoldierTest<T extends Person> implements MyTest<Person> {
    public boolean test(Person t){
        if (t.getAge() >= 18 && t.getAge() <= 27 && t.getGender() == Gender.MALE) {
            return true;
        }
        return false;
    }
}
