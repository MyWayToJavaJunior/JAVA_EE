package ru.sstu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sstu.model.db.Departments;
import ru.sstu.model.db.Groups;
import ru.sstu.model.db.Students;
import ru.sstu.repository.DepartmentsRepository;
import ru.sstu.repository.GroupsRepository;
import ru.sstu.repository.StudentsRepository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Shvarts on 18.01.2017.
 */
@Service("accpService")
@Transactional
public class AccpService {

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private GroupsRepository groupsRepository;

    @Autowired
    private DepartmentsRepository departmentsRepository;


    public List<Students> getAllStudents()
    {
        Iterable<Students> fetchedStudents = studentsRepository.findAll();
        List<Students> result = new LinkedList<>();
        for(Students s : fetchedStudents)
        {
            result.add(s);
        }
        return result;
    }

    public Map<Integer, String> getAllGroupsMap()
    {
        Iterable<Groups> fetchedGroups = groupsRepository.findAll();
        Map<Integer, String> result = new HashMap<>();
        for(Groups g : fetchedGroups)
        {
            result.put(g.getId(), g.getName());
        }
        return result;
    }

    public Groups getOneGroup(int id)
    {
        return groupsRepository.findOne(id);
    }




    public List<Students> getAllStudentsByName(String name)
    {
        Iterable<Students> fetchedStudents = studentsRepository.findAllByName(name);
        List<Students> result = new LinkedList<>();
        for(Students s : fetchedStudents)
        {
            result.add(s);
        }
        return result;
    }

    public List<Students> getAllStudentsByGroup(Groups g)
    {
        Iterable<Students> fetchedStudents = studentsRepository.findAllByGroup(g);
        List<Students> result = new LinkedList<>();
        for(Students s : fetchedStudents)
        {
            result.add(s);
        }
        return result;
    }

    public List<Students> getAllStudentsByGroup(int idGroup)
    {
        Groups g = groupsRepository.findOne(idGroup);
        return getAllStudentsByGroup(g);
    }





    public Students getOneStudent(int id)
    {
        return studentsRepository.findOne(id);
    }

    public Students saveStudent(Students s)
    {
        return studentsRepository.save(s);
    }

    public void putStudentToGroup(Students s, Groups g)
    {
        if(s != null && g != null) {
            s.setGroupsByIdGroup(g);
            studentsRepository.save(s);
        }
    }

    public void putStudentToGroup(int idStudent, int idGroup)
    {
        Students s = studentsRepository.findOne(idStudent);
        Groups g = groupsRepository.findOne(idGroup);
        putStudentToGroup(s, g);
    }

}
