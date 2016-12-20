<%--
  Created by IntelliJ IDEA.
  User: Shvarts
  Date: 14.12.16
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="my3" class="ru.sstu.MyBean" scope="page"/>
<jsp:useBean id="my4" class="ru.sstu.MyBean" scope="request"/>
Счетчик страницы (в включаемой странце): <jsp:getProperty name="my3" property="counter"/><br/>
Счетчик запроса (в включаемой странце): <jsp:getProperty name="my4" property="counter"/><br/>
