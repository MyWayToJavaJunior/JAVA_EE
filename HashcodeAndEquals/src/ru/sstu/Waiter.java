package ru.sstu;

/**
 * Created by Shvarts on 21.10.2016.
 */
public class Waiter {

    public enum Gender
    {
        MALE, FEMALE;
    }

    public String getFio() {

        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    private String fio = null;
    private int age = 0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Waiter)) return false;

        Waiter waiter = (Waiter) o;

        if (age != waiter.age) return false;
        if (Double.compare(waiter.height, height) != 0) return false;
        return getFio() != null ? getFio().equals(waiter.getFio()) : waiter.getFio() == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getFio() != null ? getFio().hashCode() : 0;
        result = 31 * result + age;
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    private double height = 0;
}
