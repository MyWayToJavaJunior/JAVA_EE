<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Shvarts
  Date: 18.01.2017
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Студент</title>
</head>
<body>


<spring:form modelAttribute="studentForm" method="post">
    Имя: <spring:input path="name"/><br/>
    Фамилия: <spring:input path="surname"/><br/>
    Группа: <spring:select path="group" items="${accpService.allGroupsMap}"/><br/>
    Дата рождения: <spring:input path="birthdate" type="date"/><br/>
    <spring:button>Отправить</spring:button>
</spring:form>
</body>
</html>
