package ru.sstu.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sstu.model.db.Departments;

/**
 * Created by Shvarts on 18.01.2017.
 */
public interface DepartmentsRepository extends CrudRepository<Departments, Integer> {
}
