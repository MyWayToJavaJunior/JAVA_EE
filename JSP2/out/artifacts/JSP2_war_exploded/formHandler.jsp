<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Shvarts
  Date: 12.12.16
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Обработчик форм</title>
</head>
<body>

<jsp:useBean id="lfb" class="ru.sstu.LoginFormBean"/>
<jsp:setProperty name="lfb" property="login" value="${param.login}"/>
<jsp:setProperty name="lfb" property="password" value="${param.password}"/>

<h1>Результаты в lfb:</h1>
<jsp:getProperty name="lfb" property="login"/><br/>
<jsp:getProperty name="lfb" property="password"/><br/>





<jsp:useBean id="lfb2" class="ru.sstu.LoginFormBean"/>
<jsp:setProperty name="lfb2" property="*"/>

<h1>Результаты в lfb2:</h1>
<jsp:getProperty name="lfb2" property="login"/><br/>
<jsp:getProperty name="lfb2" property="password"/><br/>

<h1>Обработка НЕ текстовых полей форм:</h1>
Школа: <c:out value="${param.school}"/><br/>
Университет: <c:out value="${param.university}"/><br/>
Аспирантура: <c:out value="${param.phd}"/><br/>


Пол: <c:out value="${param.gender}"/><br/>
Языки: <c:out value="${param.language}"/><br/>

город: <c:out value="${param.city}"/><br/>






</body>
</html>
