package ru.sstu.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sstu.model.db.Groups;

import java.util.List;

/**
 * Created by Shvarts on 18.01.2017.
 */
@Repository
public interface GroupsRepository extends CrudRepository<Groups, Integer>{

    @Query("select g from Groups g WHERE g.name=?1")
    List<Groups> findAllByName(String name);
}
