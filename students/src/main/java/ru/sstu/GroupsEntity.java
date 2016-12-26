package ru.sstu;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Shvarts on 23.12.2016.
 */
@Entity
@Table(name = "groups", schema = "accp", catalog = "")
public class GroupsEntity {
    private int id;
    private String name;
    private Collection<StudentsEntity> studentssById;
    private DepartmentsEntity departmentsByIdGroup;

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

    @OneToMany(mappedBy = "groupsByIdGroup", fetch = FetchType.LAZY)
    public Collection<StudentsEntity> getStudentssById() {
        return studentssById;
    }

    public void setStudentssById(Collection<StudentsEntity> studentssById) {
        this.studentssById = studentssById;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_department", referencedColumnName = "id")
    public DepartmentsEntity getDepartmentsByIdGroup() {
        return departmentsByIdGroup;
    }

    public void setDepartmentsByIdGroup(DepartmentsEntity departmentsByIdGroup) {
        this.departmentsByIdGroup = departmentsByIdGroup;
    }
}
