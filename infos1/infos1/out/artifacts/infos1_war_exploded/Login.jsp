<%--
  Created by IntelliJ IDEA.
  User: MAIBENBEN
  Date: 2018/6/29
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    登录界面:<br>
    <hr>
    <form method="post" action="/infos1/LoginServlet">
        &nbsp;&nbsp;用户名:<input type="text" name="username"><br>
        <br>
        &nbsp;&nbsp;密码:<input type="password" name="password"><br>
        <br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
