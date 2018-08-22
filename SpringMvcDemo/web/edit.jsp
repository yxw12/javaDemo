<%--
  Created by IntelliJ IDEA.
  User: Yan
  Date: 2018/8/3
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br>
<br>
<hr>
<br>
<form action="updateUser.do?uid=${user.uid}" method="post">
      姓名：<input type="text" value="${user.username}" name="username"><br>
      密码：<input type="text" value="${user.password}" name="password"><br>
      生日：<input type="text" value="${user.birthday}" name="birthday"><br>
      性别：<input type="text" value="${user.sex}" name="sex"><br>
      地址：<input type="text" value="${user.address}" name="address"><br>
      <input type="submit" value="保存">
</form>
</body>
</html>
