package ru.sstu;

/**
 * Created by Shvarts on 19.10.2016.
 */
public class GenericTypedBox<T extends Apple> {

    public T content = null;

    public T getContent()
    {
        return content;
    }

    public void setContent(T content)
    {
        this.content = content;
    }
}
