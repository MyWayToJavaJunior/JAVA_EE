package ru.sstu.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sstu.model.db.Groups;
import ru.sstu.model.db.Students;

import java.util.List;

/**
 * Created by Shvarts on 18.01.2017.
 */

@Repository
public interface StudentsRepository extends CrudRepository<Students, Integer>{
    /*
        CrudRepository<Students,            Integer>
                    класс сущности          тип первичного ключа

        CRUD
        Create - INSERT
        Read - SELECT
        Update - UPDATE
        Delete - DELETE
     */

    @Query(value = "select s from Students s where s.name = ?1")
    List<Students> findAllByName(String name);

    /*@Query(value = "SELECT * FROM students WHERE surname=?", nativeQuery = true)
    List<Students> findAllBySurname(String surname);*/

    @Query(value = "select s from Students s where s.groupsByIdGroup = ?1")
    List<Students> findAllByGroup(Groups g);
}
