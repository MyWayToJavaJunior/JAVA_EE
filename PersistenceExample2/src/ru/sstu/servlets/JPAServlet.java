package ru.sstu.servlets;

import ru.sstu.persistence.GroupsEntity;
import ru.sstu.persistence.StudentsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Shvarts on 21.12.2016.
 */
public class JPAServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setHeader("Content-Type", "text/html; charset=utf-8");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ACCP_PU");
        EntityManager em = emf.createEntityManager();

        GroupsEntity group = em.find(GroupsEntity.class, 1);
        PrintWriter pw = response.getWriter();

        pw.write(group.getId() + " " + group.getName() + "<br/><h2>Студенты:</h2>");

        for(StudentsEntity stud : group.getStudentsById())
        {
            pw.write(stud.getName() + " " + stud.getSurname() + ", группа: " + stud.getGroupsByIdGroup().getId()+"<br/>");
        }


        StudentsEntity student = em.find(StudentsEntity.class, 1);

        pw.write(student.getName() + " " + student.getSurname() + ", группа " + student.getGroupsByIdGroup().getName() + ", в ней " +

            student.getGroupsByIdGroup().getStudentsById().size() + " студентов"
        );

        GroupsEntity newGroup = new GroupsEntity();
        newGroup.setName("ARENA1605");

        StudentsEntity student1 = em.find(StudentsEntity.class, 1);
        StudentsEntity student3 = em.find(StudentsEntity.class, 3);


        pw.write(student1.getName() + "<br/>");
        pw.write(student3.getName() + "<br/>");

        /*newGroup.setStudentsById(new ArrayList<>());

        newGroup.getStudentsById().add(student1);
        student1.setGroupsByIdGroup(newGroup);

        //newGroup.getStudentsById().add(student3);
        student3.setGroupsByIdGroup(newGroup);

        for(StudentsEntity stud: newGroup.getStudentsById())
        {
            System.out.println(stud.getName());
        }*/


        em.getTransaction().begin();
        em.persist(newGroup);
        em.getTransaction().commit();


        /*em.getTransaction().begin();
        em.persist(student1);
        em.persist(student3);
        em.getTransaction().commit();*/


    }
}
