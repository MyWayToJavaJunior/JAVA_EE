package ru.sstu.model.db;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Shvarts on 18.01.2017.
 */
@Entity
public class Students {
    private int id;
    private String name;
    private String surname;
    private Date birthdate;
    private Groups groupsByIdGroup;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 50)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "birthdate", nullable = false)
    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Students students = (Students) o;

        if (id != students.id) return false;
        if (name != null ? !name.equals(students.name) : students.name != null) return false;
        if (surname != null ? !surname.equals(students.surname) : students.surname != null) return false;
        if (birthdate != null ? !birthdate.equals(students.birthdate) : students.birthdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_group", referencedColumnName = "id")
    public Groups getGroupsByIdGroup() {
        return groupsByIdGroup;
    }

    public void setGroupsByIdGroup(Groups groupsByIdGroup) {
        this.groupsByIdGroup = groupsByIdGroup;
    }
}
