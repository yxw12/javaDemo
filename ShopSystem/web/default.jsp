<%--
  Created by IntelliJ IDEA.
  User: Yan
  Date: 2018/7/18
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    response.sendRedirect(request.getContextPath()+"/product?method=index");
%>
</body>
</html>
