<%--
  Created by IntelliJ IDEA.
  User: ccc
  Date: 2020/6/8
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>测试成功!</h1>

request域:${requestScope.message}<br/>
session域:${sessionScope.message}<br/>
pageContext域:${pageScope.message}<br/>
application域:${applicationScope.message}<br/>
</body>
</html>
