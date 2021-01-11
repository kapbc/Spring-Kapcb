<%--
  Created by IntelliJ IDEA.
  User: chenc
  Date: 2021/1/11
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login page</title>
</head>
<body>
<h1>this is login page</h1>
<form id="loginForm" action="/kapcb/shiro/v1/login" method="post">
    <label>username:</label>
    <input type="text" name="username" placeholder="Please type your username"><br>
    <label>password:</label>
    <input type="password" name="password" placeholder="Please type your password">
</form>
<button type="button" id="submitButton">login</button>
<button type="reset">reset</button>
</body>
<script>
    let loginForm = document.getElementById("loginForm");
    let inputElements = document.getElementsByTagName("input");
    let submitButton = document.getElementById("submitButton");
    let targetUtl = loginForm.action;
    let method = loginForm.method;
    console.log("method is : " + method);

    submitButton.onclick = function () {
        let requestParams = getRequestParams(inputElements);
        let xmlHttpRequest = new XMLHttpRequest();
        xmlHttpRequest.open(method, targetUtl, true);
        xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xmlHttpRequest.send(requestParams);
        xmlHttpRequest.onreadystatechange = function () {
            if (xmlHttpRequest.readyState === 4 && xmlHttpRequest.status === 200) {
                console.log("request success");
                let responseText = xmlHttpRequest.responseText;
                let parse = JSON.parse(responseText);
                alert(parse.message);
            }
        }
    };

    function getRequestParams(inputElements) {
        let data = [];
        console.log(typeof inputElements);
        for (let i = 0; i < inputElements.length; i++) {
            data.push(inputElements[i].name + "=" + inputElements[i].value)
        }
        return data.join("&");
    };

</script>
</html>
