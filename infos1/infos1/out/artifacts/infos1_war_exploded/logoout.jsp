<%--
  Created by IntelliJ IDEA.
  User: MAIBENBEN
  Date: 2018/7/3
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.getSession().invalidate();
    %>
    <h2>已退出</h2>
</body>
</html>
