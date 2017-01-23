<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <script
            src="https://code.jquery.com/jquery-3.1.1.js"
            integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
            crossorigin="anonymous"></script>

    <script>

        //AJAX - Asynchronous JavaScript And XML
        function loadData()
        {
            $.ajax({
                url: "/api/oneComment",
                context: document.body
            }).done(function(data) {
                console.log("Запрос отправлен");
                console.log(data);

                $("#requestResultRaw").text(data);

                var formattedResult = "";
                for(var key in data)
                {
                    formattedResult += key + " = " + data[key] +"<br/>";
                }
                $("#requestResultFormatted").html(formattedResult);

                $("#message").text(data.message);
                $("#author").text(data.author);
            });
        }

        function sendComment()
        {
            var postObject = {
                author: "Admin",
                message: "Привет!",
                gender: "U"
            };
            $.post("/api/createComment", postObject, function (data) {
                console.log(data);
                $("#postRequestResultRaw").text(data);
            });
        }

        function sendCommentForm()
        {
            var postObject = {
                author: $('#authorField').val(),
                message: $('#messageField').val()
            };
            $.post("/api/createComment", postObject, function (data) {
                console.log(data);
                //$("#postRequestResultRaw").text(data);
            });
        }


    </script>
</head>
<body>
<h2>Hello World!</h2>
<button onclick="loadData()">Загрузить данные</button>

<div id="requestResultRaw"></div>
<div id="requestResultFormatted"></div>
<div>Сообщение с сервера: <span id="message"></span> от автора <span id="author"></span></div>

<hr/>

<button onclick="sendComment()">Отправить сообщение</button>
<div id="postRequestResultRaw"></div>

<hr/>

Автор: <input type="text" id="authorField"/><br/>
Сообщение: <input type="text" id="messageField"/><br/>
<button onclick="sendCommentForm()">Отправить сообщение</button>
</body>
</html>
