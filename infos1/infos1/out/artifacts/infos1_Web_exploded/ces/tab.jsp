<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
<style type="text/css">

    table{
        font-size: 14px;
        border-collapse: collapse;
        width: 1000px;
    }
    th,td{
        border: 1px solid black;
    }
    a{
        text-decoration:none;
        color: bisque;
        background-color: darkgrey;
    }
</style>
</head>
<body>
<a href="/infos1/LogooutServlet" target="_top">退出</a>
    <table>
        <tr>
            <td>
                <a href="${pageContext.request.contextPath}/ces/toAdd.jsp">添加</a>
            </td>
        </tr>
                    <tr>
                        <th>头像</th>
                        <th>id</th>
                        <th>姓名</th>
                        <th>密码</th>
                        <th>性别</th>
                        <th>地址</th>
                        <th>生日</th>
                        <th>操作</th>
                    </tr>
                         <c:forEach items="${userList}" var="user">
                    <tr>
                        <c:set var="image_path" value="http://localhost:8080/infos1"></c:set>
                        <td><img src="${image_path}${user.pic}" width="50px" height="50px"></td>
                        <td><c:out value="${user.userId}"></c:out></td>
                        <td><c:out value="${user.name}"></c:out></td>
                        <td><c:out value="${user.password}"></c:out></td>
                        <td>
                            <c:if test="${user.gender==1}">男</c:if>
                            <c:if test="${user.gender==0}">女</c:if>
                        </td>
                        <td><c:out value="${user.address}"></c:out></td>
                        <td><c:out value="${user.birthday}"></c:out></td>
                        <td><a href="/infos1/QuerySingleUser?userId=${user.userId}">编辑</a>&nbsp;<a href="/infos1/DeleteServlet?userId=${user.userId}">删除</a></td>
                    </tr>
                    </c:forEach>
    </table>
</body>
</html>