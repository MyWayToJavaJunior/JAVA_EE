package ru.sstu.model.form;

import javax.validation.constraints.Size;

/**
 * Created by Shvarts on 18.01.2017.
 */
public class StudentForm {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Size(min=1, max = 50, message = "Имя не может быть таким!")
    private String name;

    @Size(min=1, max = 50, message = "Фамилия не может быть такой!")
    private String surname;

    @Size(min=1, max = 50, message = "Дата рождения!")
    private String birthdate;

    private int group;
}
