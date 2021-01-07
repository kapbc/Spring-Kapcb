<%--
  Created by IntelliJ IDEA.
  User: ccc
  Date: 2020/12/23
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email_Template</title>
</head>
<body>
<h1>Click The Below Button To Send Email!</h1>
<button id="email_send_email">Click To Send Email</button>
</body>
<script>
    let button = document.getElementById('email_send_email');
    button.onclick = function () {
        let xmlHttpRequest = new XMLHttpRequest();
        xmlHttpRequest.open("post", "http://localhost:8080/kapcb/onlineEmail.do", true);
        xmlHttpRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlHttpRequest.send();
        xmlHttpRequest.onreadystatechange = function () {
            if (xmlHttpRequest.status === 200 && xmlHttpRequest.readyState === 4) {
                console.log("请求发送成功");
            }
        };
    };
</script>
</html>
