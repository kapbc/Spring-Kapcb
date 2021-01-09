<%--
  Created by IntelliJ IDEA.
  User: chenc
  Date: 2021/1/9
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<form id="loginForm" action="/kapcb/test/login" method="post">
    <label>Username: </label>
    <input type="text" name="username" placeholder="Please type your username"/> <br/>
    <label>Password: </label>
    <input type="password" name="password" placeholder="Please type your password"/> <br/>
</form>
<button id="LoginButton" type="button">Login in</button>
<button type="reset">Reset</button>
<button></button>
</body>
<script>
    let loginButton = document.getElementById('LoginButton');
    let form = document.getElementById('loginForm');
    let targetUrl = form['action'];
    console.log("targetUrl = " + targetUrl);
    loginButton.onclick = function () {
        // 创建一个 XMLHttpRequest 异步对象兼容模式
        let xmlHttpRequest;
        /**
         * code for IE7+, Firefox, Chrome, Opera
         */
        if (window.XMLHttpRequest) {
            xmlHttpRequest = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
        }

        /**
         * 设置请求方式和请求地址
         * 第一个参数: 请求方式
         * 第二个参数: 请求地址
         * 第三个参数: true(异步), false(同步)
         */
        xmlHttpRequest.open('post', targetUrl, true);

        /**
         * POST请求需要设置头文件, get请求不需要此步骤
         */
        xmlHttpRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        /**
         * 发送请求
         */
        xmlHttpRequest.send();

        /**
         * 监听状态变化
         * 状态码:
         * 0: 请求未初始化
         * 1: 服务器已建立链接
         * 2: 请求已接受到
         * 3: 请求处理中
         * 4: 请求处理完成, 且相应已准备就绪
         */
        xmlHttpRequest.onreadystatechange = function () {
            /**
             * xmlHttpRequest.readyState === 4 代表请求已经处理完成, 服务器返回状态码 有一个特殊状态码 304 代表返回的是本地缓存文件
             * , 返回 本地缓存文件也代表成功
             */
            if (xmlHttpRequest.readyState === 4 && xmlHttpRequest.statusText === 200) {
                /**
                 * 获取返回的数据
                 * @type {string}
                 */
                let data = xmlHttpRequest.responseText;

                /**
                 * 获取返回的xml
                 * @type {Document}
                 */
                // let responseXML = xmlHttpRequest.responseXML;
            }
        };
    };

</script>
</html>
