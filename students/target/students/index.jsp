<%@ page import="javax.persistence.EntityManagerFactory" %>
<%@ page import="javax.persistence.Persistence" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="ru.sstu.StudentsEntity" %>
<%@ page import="ru.sstu.GroupsEntity" %>
<%@ page import="javax.persistence.Query" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.sstu.DepartmentsEntity" %>
<html>
<body>
<h2>Hello World!</h2>

<%

    out.write("!!!!!!!!!!!!!!!!");

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ACCP_PU");
    EntityManager em = emf.createEntityManager();

    StudentsEntity s1 = em.find(StudentsEntity.class, 3);
    System.out.println("===================");

    DepartmentsEntity d1 = s1.getGroupsByIdGroup().getDepartmentsByIdGroup();
    System.out.println("===================");
    out.write(d1.getName());
    /*
    GroupsEntity g2 = em.find(GroupsEntity.class, 2);
    System.out.println("===================");
    s1.setGroupsByIdGroup(g2);
    System.out.println("===================");
    g2.getStudentssById().add(s1);
    System.out.println("===================");

    em.getTransaction().begin();
    System.out.println("===================");
    em.persist(s1);
    System.out.println("===================");
    em.persist(g2);
    System.out.println("===================");
    em.getTransaction().commit();
    System.out.println("===================");*/

    /*Query q1 = em.createQuery("SELECT s FROM StudentsEntity s", StudentsEntity.class);
    System.out.println("===================");

    List<StudentsEntity> studs = q1.getResultList();
    System.out.println("===================");*/

    /*em.getTransaction().begin();
    for(StudentsEntity s : studs)
    {
        s.setGroupsByIdGroup(g2);
        g2.getStudentssById().add(s);
        em.persist(s);
        em.persist(g2);
    }
    em.getTransaction().commit();*/




%>
</body>
</html>
