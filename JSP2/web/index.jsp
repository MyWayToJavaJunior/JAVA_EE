<%--
  Created by IntelliJ IDEA.
  User: Shvarts
  Date: 12.12.16
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Beans</title>
  </head>
  <body>
  <h1>Java Beans</h1>

  <jsp:useBean id="my" class="ru.sstu.MyBean"/>

  my.message1 = <jsp:getProperty name="my" property="message1"/> <br/>
  my.message2 = <jsp:getProperty name="my" property="message2"/> <br/>

  <jsp:setProperty name="my" property="message1" value="goodbye"/>
  <jsp:setProperty name="my" property="message2" value="universe"/>

  my.message1 = <jsp:getProperty name="my" property="message1"/> <br/>
  my.message2 = <jsp:getProperty name="my" property="message2"/> <br/>

  <jsp:useBean id="my2" class="ru.sstu.MyBean"/>

  my2.message1 = <jsp:getProperty name="my2" property="message1"/> <br/>
  my2.message2 = <jsp:getProperty name="my2" property="message2"/> <br/>



  <jsp:useBean id="d" class="java.util.Date"/>

  d.time = <jsp:getProperty name="d" property="time"/>


  </body>
</html>
