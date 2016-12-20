package ru.sstu;

import java.io.Serializable;

/**
 * Created by Shvarts on 14.12.16.
 */
public class MyBean implements Serializable {

    public int getCounter() {
        return counter++;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    private int counter = 0;
}
