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
    <title>Форма</title>
</head>
<body>
<form method="post" action="formHandler.jsp">
    <input type="text" name="login"/><br/>
    <input type="password" name="password"/><br/>

    Где вы учились:<br/>
    Школа <input type="checkbox" name="school"/><br/>
    Университет <input type="checkbox" name="university"/><br/>
    Аспирантура <input type="checkbox" name="phd"/><br/>

    Пол:
    М<input type="radio" name="gender" value="m"/><br/>
    Ж<input type="radio" name="gender" value="f"/><br/>

    Языки программирования:
    Java<input type="checkbox" name="language" value="java"/><br/>
    C#<input type="checkbox" name="language" value="csharp"/><br/>
    JavaScript<input type="checkbox" name="language" value="js"/><br/>


    Город:
    <select name="city">
        <option value="1">Саратов</option>
        <option value="2">Москва</option>
        <option value="3">Энгельс</option>
        <option value="4">Красный Кут</option>
    </select>

    <button type="submit">Отправить</button>
</form>

</body>
</html>
