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
<form action="/kapcb/shiro/v1/login" method="post">
    <label>username:</label>
    <input type="text" name="username" placeholder="Please type your username"><br>
    <label>password:</label>
    <input type="password" name="password" placeholder="Please type your password">
</form>
<button type="button" id="submitButton">login</button>
<button type="reset">reset</button>
</body>
</html>
