<%--
  Created by IntelliJ IDEA.
  User: chenc
  Date: 2021/1/18
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<label>username:</label>
<input type="text" name="username" id="username"><br/>
<label>password</label>
<input type="password" name="password" id="password"><br/>
<button type="button" id="submitButton">Submit</button>
</body>
<script>
    let submitButton = document.getElementById('submitButton');

    function getParam() {
        let username = document.getElementById('username');
        let password = document.getElementById('password');
        return "username=" + username + "&" + "password=" + password;
    };

    submitButton.onclick = function () {
        let ajax = new XMLHttpRequest();
        ajax.open('post', 'http://localhost:8080/kapcb/login', true);
        ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        ajax.send(getParam());
        ajax.onreadystatechange = function () {
            if (ajax.status === 4 && ajax.readyState === 200) {
                let responseXML = ajax.responseXML;
                let data = JSON.stringify(responseXML);
                console.log(data);
            }
        };
    };
</script>
</html>
