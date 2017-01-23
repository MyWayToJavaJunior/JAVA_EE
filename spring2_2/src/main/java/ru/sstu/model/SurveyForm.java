package ru.sstu.model;

import org.hibernate.validator.constraints.*;

import javax.validation.constraints.*;



/**
 * Created by Shvarts on 16.01.2017.
 */
public class SurveyForm { //FIXME

    @NotNull(message = "Имя не может быть пустым")
    @Size(min = 1, max = 20, message = "Имя должно содержать от 1 до 20 символов")
    private String name;

    @NotNull(message = "Фамилия не может быть пустой")
    @Size(min = 1, max = 20, message = "Фамилия должна содержать от 1 до 20 символов")
    private String surname;

    private String patronymic;

    @Max(value = 120, message = "Возраст слишком велик")
    @Min(value = 18, message = "Вы ещё не достигли совершеннолетия")
    private int age;

    @Email(message = "Адрес почты некорректен")
    private String email;

    @Pattern(regexp = "(8|\\+7)-9\\d\\d-\\d{3}-\\d\\d-\\d\\d", message = "Некорректный номер телефона!")
    private String phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    //@NotEmpty

    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return surname;
    }

    //@NotEmpty

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }




}
