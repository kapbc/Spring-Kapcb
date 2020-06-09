<%--
  Created by IntelliJ IDEA.
  User: ccc
  Date: 2020/6/8
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="test">测试</a><br/>

<%--基本类型的请求参数绑定测试--%>
<a href="/param/findAccount?accountId=10">查询账户</a><br/>

<%--基本类型和 String 类型作为参数 --%>
<a href="/param/findAccount2?accountId=8&accountName=kapcb">String类型的参数携带测试(大小写一致)</a><br/>

<a href="/param/findAccount2?accountId=8&accountname=kapcb">String类型的参数携带测试(大小写不一致)</a><br/>

<%--类型绑定--pojo测试--%>
<form action="/account/saveAccount" method="post">
    账户名称:<input type="text" name="name"> <br/>
    账户金额:<input type="text" name="money"> <br/>
    账户省份:<input type="text" name="address.provinceName"> <br/>
    账户城市:<input type="text" name="address.cityName"> <br/>
    <input type="submit" value="保存"> <br/>
</form>

<%--POJO 类中包含集合类型参数 --%>
<form action="/account/updateAccount" method="post">
    用户名称:<input type="text" name="username"><br/>
    用户密码:<input type="password" name="password"><br/>
    用户年龄:<input type="text" name="age"><br/>
    账户 1 名称:<input type="text" name="accounts[0].name"><br/>
    账户 1 金额:<input type="text" name="accounts[0].money"><br/>
    账户 2 名称:<input type="text" name="accounts[1].name"><br/>
    账户 2 金额:<input type="text" name="accounts[1].money"><br/>
    账户 3 名称:<input type="text" name="accountMap['one'].name"><br/>
    账户 3 金额:<input type="text" name="accountMap['one'].money"><br/>
    账户 4 名称:<input type="text" name="accountMap['two'].name"><br/>
    账户 4 金额:<input type="text" name="accountMap['two'].money"><br/>
    <input type="submit" value="保存">
</form>

<%--自定义类型转换器--%>
<a href="/account/deleteAccount?date=2020-6-8">根据日期输出账户</a><br/>

<%--使用 ServletAPI 对象作为方法参数 --%>
<a href="/account/servletAPI">测试访问 ServletAPI</a><br/>


<%--测试返回 ModeAndView--%>
<a href="/ModeAndView/ModeAndViewTest">测试返回 ModeAndView</a><br/>

<%--forward请求转发--%>
<a href="/forWard">forward请求转发</a>

<%--redirect重定向--%>
<a href="/redirect">redirect重定向</a>

<%--使用@RequestBody获取请求体数据--%>
<input type="submit" id="btn" value="TestJson"> <br/>

<%--测试map携带参数输出--%>
<a href="/param/map">测试map携带参数输出</a><br/>

<%--测试model携带参数输出--%>
<a href="/param/model">测试model携带参数输出</a><br/>

<%--测试modelMap携带参数输出--%>
<a href="/param/modelMap">测试modelMap携带参数输出</a><br/>

</body>

<script type="text/javascript">

    $(function () {
        // 绑定点击事件
        $("#btn").click(function () {
            $.ajax({
                url: "user/testJson",
                contentType: "application/json;charset=UTF-8",
                data: '{"addressName":"aa","addressNum":100}',
                dataType: "json",
                type: "post",
                success: function (data) {
                    alert(data);
                    alert(data.addressName);
                }
            });
        });
    });


</script>
</html>

