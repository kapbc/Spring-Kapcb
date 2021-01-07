<%--
  Created by IntelliJ IDEA.
  User: ccc
  Date: 2020/6/7
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="hello">Hello,SpringMVC</a><br/>

<%--@RequestParam注解测试--%>
<a href="SpringMVC/userRequestParam?name=Kapcb">RequestParam注解测试</a><br/>


<%--@RequestBody注解测试--%>
<form action="/SpringMVC/userRequestBody" method="post">
    用户名称:<input type="text" name="username"> <br/>
    用户密码:<input type="password" name="password"> <br/>
    用户年龄:<input type="text" name="age"> <br/>
    <input type="submit" value="保存">
</form>

<%--@RequestBody注解GET请求测试--%>
<a href="/SpringMVC/userRequestBody?body=kapcb">@RequestBody注解GET请求测试</a><br/>

<%--@PathVariable注解测试--%>
<a href="/SpringMVC/userPathVariable/10">@PathVariable注解测试</a><br/>


<%--POST请求--%>
<form action="/SpringMVC/RESTfulPost" method="post">
    用户名称:<input type="text" name="username"> <br/>
    <%--<input type="hidden" name="_method" value="POST">--%>
    <input type="submit" value="保存">
</form>

<%--PUT请求--%>
<form action="/SpringMVC/RESTfulPUT/1" method="post">
    用户名称:<input type="text" name="username" placeholder="用户名称"> <br/>
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="更新">
</form>

<%--DELETE请求--%>
<form action="/SpringMVC/RESTfulDELETE/1" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="删除">
</form>

<form action="/SpringMVC/RESTfulGET/1" method="post">
    <input type="hidden" name="_method" value="GET">
    <input type="submit" value="查询">
</form>


<%--@RequestHeader注解测试--%>
<a href="/SpringMVC/userRequestHeader">@RequestHeader注解测试</a><br/>

<%--@CookieValue注解测试--%>
<a href="/SpringMVC/useCookieValue">@CookieValue注解测试</a><br/>

<%--ModelAttribute 注解的基本使用--%>
<a href="/SpringMVC/testModelAttribute?username=test">测试 modelattribute</a><br/>


<%--@ModelAttribute测试--%>
<form action="/SpringMVC/updateUser" method="post">
    用户名称:<input type="text" name="username">
    用户密码:<input type="password" name="password">
    <input type="submit" value="保存">
</form>


<%--@SessionAttributes测试--%>
<a href="/sessionAttribute/testPut">存入值到SessionAttributes中</a><br/>

<a href="/sessionAttribute/testGet">获取SessionAttributes中的值</a><br/>

<a href="/sessionAttribute/testClean">清除SessionAttributes中的值</a><br/>

<a href="/sessionAttribute/testGet">获取清楚后的SessionAttributes中的值</a><br/>


</body>
</html>
