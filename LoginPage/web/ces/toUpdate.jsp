<%--
  Created by IntelliJ IDEA.
  User: Yan
  Date: 2018/7/9
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
    <title></title>
</head>
<body>

            <div style="background-color: #f8f8f8;">
                <br>
                <span style="font-size: 17px;">&nbsp;&nbsp;当前位置：用户管理&nbsp;>>&nbsp;用户编辑</span>
                <hr>
            </div>
            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/UpdateServlet" method="post">
                <input type="hidden" value="${user.userId}" name="userId">
                <div class="form-group">
                    <label for="userName" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="username" id="userName" placeholder="请输入用户名" value="${user.username}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="passWord" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="password"  id="passWord" placeholder="请输入密码" value="${user.password}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="gender1" class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-10">
                        <div class="radio">
                            <label>
                                <input type="radio" name="optionsRadios" id="gender1" value="1" <c:if test="${user.gender==1}">checked</c:if>> 男
                            </label>
                            <label>
                                <input type="radio" name="optionsRadios" id="gender2" value="0"  <c:if test="${user.gender==0}">checked</c:if>>女
                            </label>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="addRess" class="col-sm-2 control-label">地址</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="address" id="addRess" placeholder="请输入地址" value="${user.address}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="birthDay" class="col-sm-2 control-label">出生日期</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="birthday" id="birthDay" placeholder="请输入出生日期XXXX-XX-XX" value="${user.birthday}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-success" >修改</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button type="button" class="btn btn-default"
                                data-dismiss="modal">返回</button>
                    </div>
                </div>
            </form>


</body>
</html>
<style>
    .form-control {
        width: 50%;
    }
</style>