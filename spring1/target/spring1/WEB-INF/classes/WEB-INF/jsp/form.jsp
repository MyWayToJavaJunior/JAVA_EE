<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>




<form method="POST" action="./uploadFile" enctype="multipart/form-data">
    File to upload: <input type="file" name="file"/>

    Name: <input type="text" name="name"/>


    <input type="submit" value="Upload"/> Press here to upload the file!
</form>


</body>
</html>