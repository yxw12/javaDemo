<%--
  Created by IntelliJ IDEA.
  User: Yan
  Date: 2018/8/3
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>



<table style="width: 50%;border: 1px;align-items:center;" cellspacing="0">
    <tr>
        <p>${users.get(0).username}的订单</p>
        <a href="javascript:history.back(-1);">返回</a>
        <hr>
    </tr>
    <tr>
        <th>订单ID</th>
        <th>订单价格</th>
        <th>创建时间</th>
    </tr>
    <c:forEach items="${users}" var="orders">
            <tr>
                <th>${orders.orders.oid}</th>
                <th>${orders.orders.number}</th>
                <th>${orders.orders.createtime}</th>
            </tr>
    </c:forEach>
</table>
</body>
</html>
