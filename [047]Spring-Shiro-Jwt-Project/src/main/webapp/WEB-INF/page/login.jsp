<%--
  Created by IntelliJ IDEA.
  User: chenc
  Date: 2021/1/20
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Buyer Score Weekly Point Change Notification</title>
  <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
    integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
    integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous">
  </script>
</head>
<style>
  body {
    min-width: 800px;
    background-image: url(https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/3ac79f3df8dcd100ef40a627718b4710b8122fd3.jpg);
    background-size: 1000px 1000px;
  }

  .content {
    width: 700px;
    height: 340px;
    background-color: rgba(211, 211, 211, 0.541);
    margin: 50px auto;
    position: relative;
    border-radius: 2%;
    box-shadow: 2px 2px 5px rgba(211, 211, 211, .5);
  }

  .content .form-content {
    width: 400px;
    height: 400px;
    position: absolute;
    left: 150px;
    top: 90px;
  }

  .alertWindows {
    position: relative;
    left: 0;
    top: 0;
  }

  .content .form-content .form-group {
    width: 400px !important;
  }
</style>

<body>
  <div id="messageAlert">

  </div>
  <div class="content">
    <div class="form-content">
      <form class="form-horizontal" id="insertForm" action="#" method="POST">
        <div class="form-group has-success has-feedback">
          <label class="control-label" for="inputGroupSuccess1">username</label>
          <div class="input-group">
            <span class="input-group-addon">@</span>
            <input type="text" class="form-control" id="inputGroupSuccess1" aria-describedby="inputGroupSuccess1Status"
              name="username">
          </div>
          <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
          <span id="inputGroupSuccess1Status" class="sr-only">(success)</span>
        </div>
        <div class="form-group has-success has-feedback">
          <label class="control-label" for="inputGroupSuccess1">passwrod</label>
          <div class="input-group">
            <span class="input-group-addon">@</span>
            <input type="text" class="form-control" id="inputGroupSuccess1" aria-describedby="inputGroupSuccess1Status"
              name="passwrod">
          </div>
          <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
          <span id="inputGroupSuccess1Status" class="sr-only">(success)</span>
        </div>
      </form>
      <div class="col-sm-offset-2 col-sm-10">
        <button type="button" class="btn btn-primary" id="insertButton"
          style="width: 100px; margin-right: 30px;">Insert</button>
        <button type="button" class="btn btn-danger" style="width: 100px; margin-left: 30px;">Reset</button>
      </div>
    </div>
  </div>
</body>
<script>
  let formELement = document.getElementById("insertForm");
  let inputElements = formELement.getElementsByTagName("input");
  let button = document.getElementById("insertButton");
  let method = formELement.method;
  let targetUrl = formELement.action;
  button.onclick = function () {
    let requestParams = getFormParams(inputElements);
    console.log("requestParams is : " + requestParams);
    let xmlHttpRequest = new XMLHttpRequest;
    let jsonString = JSON.stringify(requestParams);
    console.log("jsonString : " + jsonString);
    xmlHttpRequest.open(method, targetUrl, true);
    xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xmlHttpRequest.send(requestParams);
    xmlHttpRequest.onreadystatechange = function () {
      if (xmlHttpRequest.readyState === 4 && xmlHttpRequest.status === 200) {
        console.log("send ansyc request success");
        let result = xmlHttpRequest.responseText;
        let data = JSON.parse(result);
        alert(data.StatusMessage);
      }
    };
  };

  function getFormParams(inputs) {
    let bean = new Object();
    for (let i = 0; i < inputs.length; i++) {
      const element = inputs[i];
      if (element.value == undefined || element.value === "") {
        messageAlert(element.name);
        return;
      }
      const k = element.name;
      console.log(k);
      const v = element.value;
      console.log(v);
      bean.k = v;
    }
    console.log("bean : " + bean.buyerId);
  };

  function messageAlert(message) {
    let messagebox = document.getElementById("messageAlert");
    let div = document.createElement("div");
    div.classList = "alert alert-warning alert-dismissible col-xs-offset-3 col-xs-6";
    div.style = "z-index: 9999;"
    div.role = "alert";
    div.id = "alertWindows";
    div.innerHTML =
      '<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Warning!</strong> Please type in the column ' +
      message + ' first. The Column is requires!';
    messagebox.appendChild(div);
  };
</script>

</html>
