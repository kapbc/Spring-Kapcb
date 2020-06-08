<%--
  Created by IntelliJ IDEA.
  User: ccc
  Date: 2020/6/8
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>传统上传</h1><br/>
<form action="test/fileUpLoad" enctype="multipart/form-data" method="post">
    选择文件:<input type="file" name="upload"><br/>
    <input type="submit" value="文件上传"><br/>
</form>

<h1> SpringMVC上传</h1>
<form action="/springmvc/UpLoad" enctype="multipart/form-data" method="post">
    选择文件:<input type="file" name="upload"><br/>
    <input type="submit" value="文件上传"><br/>
</form>

</body>
</html>
