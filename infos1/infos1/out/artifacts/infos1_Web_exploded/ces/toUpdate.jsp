<%@ page import="com.ht.ces.DButils" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.ht.ces.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
</head>
<body>
<span>当前位置：用户管理>>用户编辑</span>
<hr>
<form action="/infos1/UpdateServlet" method="post" enctype="multipart/form-data">
    <input type="hidden" value="${user.userId}" name="userId">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" value="${user.name}"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" value="${user.password}"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="gender" value="1" <c:if test="${user.gender==1}">checked</c:if>>男&nbsp;
                <input type="radio" name="gender" value="0"  <c:if test="${user.gender==0}">checked</c:if>>女
            </td>
        </tr>
        <tr>
            <td>头像</td>
            <td><input type="file" name="pic" value="${user.pic}"></td>
        </tr>
        <tr>
            <td>地址</td>
            <td><input type="text" name="address" value="${user.address}"></td>
        </tr>
        <tr>
            <td>生日</td>
            <td><input type="text" name="birthday"value="${user.birthday}" ></td>
        </tr>
    </table>
    <input type="submit" value="修改">
</form>
</body>
</html>
