<html>
<body>
<h2>Hello World!</h2>

<form action="${pageContext.request.contextPath}/test/validation" method="post">
    <label>username:</label>
    <input type="text" name="username" placeholder=""/> <br/>
    <label>password:</label>
    <input type="password" name="password" placeholder=""/> <br/>
    <label>email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
    <input type="text" name="email" placeholder=""/> <br/>
    <label>age:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
    <input type="text" name="age" placeholder=""/> <br/> <br/>
    <input type="submit" name="提交">
    <input type="reset" name="重置"> <br/>
</form>

<H4>${pageContext.request.contextPath}</H4>
</body>
</html>
