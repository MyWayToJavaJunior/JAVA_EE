<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 19.12.2016
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="post">
    <input type="text" name="name"/>
    <button type="submit">ОК</button>
  </form>
  <%
    Connection c = null;
    Statement stmt = null;
    ResultSet rs1 = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      c = DriverManager.getConnection("jdbc:mysql://localhost:3306/accp", "root", "");
      out.write("Connected!<br/>");

      stmt = c.createStatement();//создаем объект SQL-выражения

      /*rs1 = stmt.executeQuery("SELECT * FROM students");//выполняем SELECT-запрос
      while(rs1.next())//итерируем по набору результатов
      {
        out.write("id by column name =" + rs1.getInt("id") + ", name = " + rs1.getString("name") + ", surname = " + rs1.getString("surname"));
        out.write("height =" + rs1.getInt("height") + ", birthdate = " + rs1.getDate("birthdate") + "<br/>");
        out.write("id by column index =" + rs1.getInt(1) + "<br/>");
      }*/

      //ResultSet rs2 = stmt.executeQuery("SELECT * FROM students");
      //добавление строки в БД
      int res1 = stmt.executeUpdate("INSERT INTO students (name, surname, height, birthdate) VALUES ('123', '456', 196, CURRENT_DATE())");
      out.write("Добавленных строк= " + res1 + "<br/>");//выводим кол-во затронутых (добавленных) строк

      //удаление из БД
      int res2 = stmt.executeUpdate("DELETE FROM students WHERE id > 4");
      out.write("Удаленных строк= " + res2 + "<br/>");//выводим кол-во затронутых (удаленных) строк

      //изменение в БД
      int res3 = stmt.executeUpdate("UPDATE students SET name='890' WHERE id < 3");
      out.write("Измененных строк  = " + res3 + "<br/>");//выводим кол-во затронутых (измененных) строк

      //SQL-инъекции!!!!!!!!!!!!!!!
      String searchName = request.getParameter("name");
      if(searchName != null)
      {
          if(!searchName.isEmpty()) {
            out.write("<h2>Statement:</h2>");
            String sql = "SELECT * FROM students WHERE name='" + searchName + "'";//опасность!!!
            out.write("SQL: " + sql + "<br/>");
            ResultSet nameResultSet = stmt.executeQuery(sql);

            while (nameResultSet.next()) {
              out.write("Surname = " + nameResultSet.getString("surname") + " " + nameResultSet.getString("name")+"<br/>");
            }
            out.write("<h2>PreparedStatement:</h2>");
            PreparedStatement ps = c.prepareStatement("SELECT * FROM students WHERE name=?");
            ps.setString(1, searchName);
            ResultSet prs1 = ps.executeQuery();
            out.write("SQL: " + ps.toString() + "<br/>");
            while(prs1.next())
            {
              out.write("Surname = " + prs1.getString("surname") + " " + prs1.getString("name")+"<br/>");
            }
          }
      }

      try {
        c.setAutoCommit(false);
        int money1 = stmt.executeUpdate("UPDATE students SET money=money-100 WHERE id=2");
        int money2 = stmt.executeUpdate("UPDATE students SET money=money+100 WHERE id=1");
        c.commit();

        int money3 = stmt.executeUpdate("UPDATE students SET money=money-100 WHERE id=3");
        int money4 = stmt.executeUpdate("UPDATE students SET money=money+100 WHERE2 id=4");
        c.commit();
      }
      catch(SQLException ex)
      {
        c.rollback();
      }


      try {
        c.setAutoCommit(false);
        long time1 = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++) {
          stmt.executeUpdate("INSERT INTO students (name, surname, height, birthdate) VALUES ('name" + i + "', 'surname" + i + "', 180, CURRENT_DATE())");
        }
        c.commit();
        out.write("В транзакции:" + (System.currentTimeMillis() - time1) + " мс <br/>");

        c.setAutoCommit(true);
        stmt.executeUpdate("DELETE FROM students WHERE id>4");

        long time2 = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++) {
          stmt.executeUpdate("INSERT INTO students (name, surname, height, birthdate) VALUES ('name" + i + "', 'surname" + i + "', 180, CURRENT_DATE())");
        }
        out.write("Без транзакции:" + (System.currentTimeMillis() - time2) + " мс <br/>");
      }
      catch(SQLException ex)
      {
        c.rollback();
      }






    }
    catch (Exception ex)
    {
        out.write(ex.getMessage());
    }
    finally {

        //ЗАКРЫВАЙТЕ ОТКРЫТОЕ!!!
      //rs1.close();
      stmt.close();
      c.close();
    }
  %>
  </body>
</html>
