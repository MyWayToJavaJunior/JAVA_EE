package ru.sstu.model.db;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Shvarts on 18.01.2017.
 */
@Entity
public class Groups {
    private int id;
    private String name;
    private Departments departmentsByIdDepartment;
    private Collection<Students> studentssById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
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

        Groups groups = (Groups) o;

        if (id != groups.id) return false;
        if (name != null ? !name.equals(groups.name) : groups.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_department", referencedColumnName = "id", nullable = false)
    public Departments getDepartmentsByIdDepartment() {
        return departmentsByIdDepartment;
    }

    public void setDepartmentsByIdDepartment(Departments departmentsByIdDepartment) {
        this.departmentsByIdDepartment = departmentsByIdDepartment;
    }

    @OneToMany(mappedBy = "groupsByIdGroup")
    public Collection<Students> getStudentssById() {
        return studentssById;
    }

    public void setStudentssById(Collection<Students> studentssById) {
        this.studentssById = studentssById;
    }
}
