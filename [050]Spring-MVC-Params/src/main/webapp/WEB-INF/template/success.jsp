<%--
  Created by IntelliJ IDEA.
  User: chenc
  Date: 2021/2/21
  Time: 22:19
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
