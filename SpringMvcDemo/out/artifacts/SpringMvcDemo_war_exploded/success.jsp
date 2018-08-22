<%--
  Created by IntelliJ IDEA.
  User: Yan
  Date: 2018/8/2
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    欢迎你，<%=request.getAttribute("name")%>!登录成功
   <hr>
<table style="width: 50%;border: 1px;align-items:center;" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>密码</th>
        <th>生日</th>
        <th>性别</th>
        <th>地址</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <th>${user.uid}</th>
            <th>${user.username}</th>
            <th>${user.password}</th>
            <th>${user.birthday}</th>
            <th>${user.sex}</th>
            <th>${user.address}</th>
            <th>
                <a href="deleteUser.do?id=${user.uid}" >删除</a>
                <a href="findUserById.do?uid=${user.uid}" >编辑</a>
                <a href="findOrdersByUid.do?uid=${user.uid}" >查看订单</a>
            </th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
