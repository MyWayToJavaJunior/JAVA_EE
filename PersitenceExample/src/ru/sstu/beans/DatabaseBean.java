package ru.sstu.beans;

import ru.sstu.persistence.StudentsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shvarts on 21.12.2016.
 */
public class DatabaseBean implements Serializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ACCPPersistenceUnit");
    EntityManager em = emf.createEntityManager();


    //JPA - Java Persistence API

    public List<StudentsEntity> getStudents()
    {
        List<StudentsEntity> students = null;



        //выбрать всех SQL-запросом
        Query q1 = em.createNativeQuery("SELECT * FROM students", StudentsEntity.class);
        students = q1.getResultList();
        return students;
    }

    public List<StudentsEntity> getStudents2()
    {
        List<StudentsEntity> students = null;

        //JPQL - Java Persistence Query Language
        //Query q1 = em.createQuery("SELECT s FROM StudentsEntity s", StudentsEntity.class);
        Query q1 = em.createQuery("SELECT s FROM StudentsEntity s WHERE s.id > 1", StudentsEntity.class);
        students = q1.getResultList();
        return students;
    }

    public StudentsEntity getOneStudent()
    {

        //SELECT one
        StudentsEntity oneStudent = em.find(StudentsEntity.class, 1);

        System.out.println(oneStudent.getName() + " " + oneStudent.getSurname());
        return oneStudent;
    }


    public void setNewStudent(String name)
    {
        StudentsEntity student = new StudentsEntity();
        student.setName(name);
        student.setSurname("Surname");
        student.setBirthdate(new Date(new java.util.Date().getTime()));

        em.getTransaction().begin();//начало транзакции
        em.persist(student);
        em.getTransaction().commit();//конец транзакции


    }

    //добавление в БД
    public void setNewStudents(int n)
    {
        em.getTransaction().begin();//начало транзакции
        for(int i = 0; i < n; i++)
        {

            StudentsEntity student = new StudentsEntity();
            student.setName("Name " + (i+1));
            student.setSurname("Surname " + (i+1));
            student.setBirthdate(new Date(new java.util.Date().getTime()));

            em.persist(student);

        }
        em.getTransaction().commit();//конец транзакции
    }

    //изменение записей в БД

    public boolean getUpdateStudent()
    {
        StudentsEntity student = em.find(StudentsEntity.class, 1);

        student.setSurname("bbb");
        student.setBirthdate(new Date(new java.util.Date().getTime()));

        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();

        return true;
    }

    public boolean getDeleteStudent()
    {
        StudentsEntity student = em.find(StudentsEntity.class, 2);

        em.getTransaction().begin();
        em.remove(student);
        em.getTransaction().commit();

        return true;
    }
}
