<%--
  Created by IntelliJ IDEA.
  User: Shvarts
  Date: 21.12.2016
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="db" class="ru.sstu.beans.DatabaseBean"/>

<jsp:getProperty name="db" property="oneStudent"/><br/>
<h1>SQL:</h1>
<c:forEach items="${db.students}" var="student">
    <c:out value="${student.name}"/> <c:out value="${student.surname}"/><br/>
</c:forEach>

<h1>JPQL:</h1>
<c:forEach items="${db.students2}" var="student">
    <c:out value="${student.name}"/> <c:out value="${student.surname}"/><br/>
</c:forEach>


<%--<jsp:setProperty name="db" property="newStudents" value="5"/>--%>

<jsp:getProperty name="db" property="updateStudent"/><br/>

<jsp:getProperty name="db" property="deleteStudent"/><br/>
</body>
</html>
