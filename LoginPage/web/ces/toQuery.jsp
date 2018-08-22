<%--
  Created by IntelliJ IDEA.
  User: Yan
  Date: 2018/7/9
  Time: 14:51
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/messages_zh.js"></script>
    <title>添加用户</title>
</head>
<body>
<div style="background-color: #f8f8f8;">
    <br>
    <span style="font-size: 17px;">&nbsp;&nbsp;当前位置：用户管理&nbsp;>>&nbsp;用户查看</span>
    <hr>
</div>
<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/InsertServlet" method="post" id="insertFrom">
    <div class="form-group">
        <label for="userName" class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="username" id="userName" placeholder="请输入用户名"  disabled="true" value="${user.username}">
        </div>
    </div>
    <div class="form-group">
        <label for="passWord" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" name="password"  id="passWord" placeholder="请输入密码"  disabled="true" value="${user.password}">
        </div>
    </div>
    <div class="form-group">
        <label for="gender1" class="col-sm-2 control-label">性别</label>
        <div class="col-sm-10">
            <div class="radio">
                <label>
                    <c:if test="${user.gender==1}" var="optionsRadios">
                    <input type="radio" name="optionsRadios" id="gender1" value="1" checked  disabled="true"> 男
                    </c:if>
                </label>
                <label>
                    <c:if test="${user.gender==0}" var="optionsRadios">
                    <input type="radio" name="optionsRadios" id="gender2" value="0" checked disabled="true">女
                    </c:if>
                </label>
            </div>
        </div>
    </div>

    <div class="form-group">
        <label for="addRess" class="col-sm-2 control-label">地址</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="address" id="addRess" placeholder="请输入地址"  disabled="true" value="${user.address}">
        </div>
    </div>
    <div class="form-group">
        <label for="birthDay" class="col-sm-2 control-label">出生日期</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="birthday" id="birthDay" placeholder="请输入出生日期XXXX-XX-XX"  disabled="true" value="${user.birthday}">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="button" class="btn btn-primary"
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
    .error{
        color:red;
        font-weight: normal;
    }
</style>
<script>
    $(function(){
        $("#insertFrom").validate({
            rules:{
                username:{
                    required:true,
                    minlength:2
                },
                password:{
                    required:true,
                    digits:true,
                    minlength:6
                },
                optionsRadios:{
                    required:true
                },
                birthday:{
                    date:true
                }

            },
            messages:{
                user:{
                    required:"用户名不能为空!",
                    minlength:"用户名不得少于2个字符!"
                },
                password:{
                    required:"密码不能为空!",
                    digits:"密码必须是数字!",
                    minlength:"密码长度不得低于6位!"
                },
                optionsRadios:{
                    required:"性别必须勾选!"
                },
                birthday:{
                    date:"日期格式不正确!"
                }

            },
            errorElement: "label", //用来创建错误提示信息标签
            success: function(label) { //验证成功后的执行的回调函数
                //label指向上面那个错误提示信息标签label
                label.text(" ") //清空错误提示消息
                        .addClass("success"); //加上自定义的success类
            }
        });
    })
</script>

<script type="text/javascript">

    //ajax提交信息
    //   $("#save").click(function(){
    /*   function save() {
     var username=$("#userName").val();
     var password=$("#passWord").val();
     var gender=$('input[type=radio][name=optionsRadios]:checked').val();
     var address=$("#addRess").val();
     var birthday=$("#birthDay").val();
     $.ajax({
     async: false,
     type: "POST",
     //     url:'/LoginPage/InsertServlet',
     url:'${pageContext.request.contextPath}/InsertServlet',
     //contentType : "application/x-www-form-urlencoded; charset=utf-8",
     data:{
     "username":username,
     "password":password,
     "gender":gender,
     "address":address,
     "birthday":birthday
     },
     dataType: "text",
     success: function (data) {
     alert(data);
     console.log(data);
     window.location.href="${pageContext.request.contextPath}/PageServlet";
     },
     error: function (e) {
     alert(e);
     }
     })
     }*/
    //再执行关闭

    //    });
</script>
