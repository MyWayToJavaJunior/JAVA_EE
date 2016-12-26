package ru.sstu;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Shvarts on 23.12.2016.
 */
@Entity
@Table(name = "departments", schema = "accp", catalog = "")
public class DepartmentsEntity {
    private int id;
    private String name;
    private Collection<GroupsEntity> groupssById;

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

        if (id != that.getId()) return false;
        if (name != null ? !name.equals(that.getName()) : that.getName() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "departmentsByIdGroup", fetch = FetchType.LAZY)
    public Collection<GroupsEntity> getGroupssById() {
        return groupssById;
    }

    public void setGroupssById(Collection<GroupsEntity> groupssById) {
        this.groupssById = groupssById;
    }
}
