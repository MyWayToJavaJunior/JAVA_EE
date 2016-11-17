package ru.sstu;

/**
 * Created by Shvarts on 16.11.2016.
 */
public class Good {

    private int id;
    private String name;
    private float price;

    public Good()
    {

    }

    public Good(int id, String name, float price)
    {
        setId(id);
        setName(name);
        setPrice(price);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
