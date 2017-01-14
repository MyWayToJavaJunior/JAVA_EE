package ru.sstu.entity;

/**
 * Created by user on 09.01.2017.
 */
public enum Gender {
    MALE("m"),
    FEMALE("f"),
    UNDEFINED("u");

    private String value;

    Gender(String value)
    {
        setValue(value);
    }

    public static Gender fromString(String s)
    {
        for(Gender g : values())
        {
            if(g.getValue().equals(s))
            {
                return g;
            }
        }
        return UNDEFINED;
    }

    @Override
    public String toString() {
        return getValue();
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    public void setValue(Gender value) {
        this.value = value.getValue();
    }
}
