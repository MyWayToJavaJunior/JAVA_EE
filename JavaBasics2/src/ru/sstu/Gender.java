package ru.sstu;

/**
 * Created by Shvarts on 17.10.2016.
 */
public enum Gender {
    MALE,
    FEMALE,
    UNDEFINED;

    //public static final int MALE = 0;

    private String name = super.toString();

    public void talk()
    {
        System.out.println("Разговор");
    }

    public String getRussianName()
    {
        switch (name)
        {
            case "MALE":
                return "Мужчина";
            case "FEMALE":
                return "Женщина";
            case "UNDEFINED":
            default:
                return "Не указан";
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
