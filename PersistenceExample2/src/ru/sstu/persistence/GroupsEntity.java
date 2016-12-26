package ru.sstu.persistence;

import java.util.Collection;

/**
 * Created by Shvarts on 21.12.2016.
 */
public class GroupsEntity {
    private int id;
    private String name;
    private Collection<StudentsEntity> studentsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupsEntity that = (GroupsEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<StudentsEntity> getStudentsById() {
        return studentsById;
    }

    public void setStudentsById(Collection<StudentsEntity> studentssById) {
        this.studentsById = studentssById;
    }
}
