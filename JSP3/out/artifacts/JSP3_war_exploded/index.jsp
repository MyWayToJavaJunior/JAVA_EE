<%--
  Created by IntelliJ IDEA.
  User: Shvarts
  Date: 14.12.16
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>


  <jsp:useBean id="my" class="ru.sstu.MyBean"/>
  Счетчик без scope : <jsp:getProperty name="my" property="counter"/><br/>

  <jsp:useBean id="my2" class="ru.sstu.MyBean" scope="application"/>
  Счетчик приложения : <jsp:getProperty name="my2" property="counter"/><br/>

  <jsp:useBean id="my3" class="ru.sstu.MyBean" scope="page"/>
  Счетчик страницы : <jsp:getProperty name="my3" property="counter"/><br/>

  <jsp:useBean id="my4" class="ru.sstu.MyBean" scope="request"/>
  Счетчик запроса : <jsp:getProperty name="my4" property="counter"/><br/>

  <jsp:useBean id="my5" class="ru.sstu.MyBean" scope="session"/>
  Счетчик в сессии : <jsp:getProperty name="my5" property="counter"/><br/>
  </body>
</html>
