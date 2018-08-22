<%--
  Created by IntelliJ IDEA.
  User: Yan
  Date: 2018/7/11
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/messages_zh.js"></script>
</head>
<body>
<div style="background-color: #f8f8f8;">
<br>
<span style="font-size: 17px;">&nbsp;&nbsp;当前位置：用户管理&nbsp;>>&nbsp;用户注册</span>
<p></p>
<hr>
</div>
<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/RegisterServlet" method="post" id="registForm">
    &nbsp;
    <div class="form-group">
        <label for="user" class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="username" id="user" placeholder="请输入用户名">
        </div>
    </div>&nbsp;
    <div class="form-group">
        <label for="pass" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" name="password"  id="pass" placeholder="请输入密码">
        </div>
    </div>&nbsp;
    <div class="form-group">
        <label for="comfirpass" class="col-sm-2 control-label">确认密码</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" name="comfpassword"  id="comfirpass" placeholder="请输入密码">
        </div>
    </div>&nbsp;
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary" >注册</button>
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
        $("#registForm").validate({
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
                comfpassword:{
                    required:true,
                    digits:true,
                    minlength:6,
                    equalTo:"[name='password']"
                }
            },
            messages:{
                username:{
                    required:"用户名不能为空!",
                    minlength:"用户名不得少于2个字符!"
                },
                password:{
                    required:"密码不能为空!",
                    digits:"密码必须是数字!",
                    minlength:"密码长度不得低于6位!"
                },
                comfpassword:{
                    required:"确认密码不能为空!",
                    digits:"密码必须是数字!",
                    minlength:"密码长度不得低于6位!",
                    equalTo:"两次密码不一致!"
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

<!--
<script type="text/javascript">
    var username=$("#user").val();
    var password=$("#pass").val();
    var comfirpass=$("#comfirpass").val();
    $("#submit").click(function(){
        $.ajax({
            async: false,
            type: "POST",
            //     url:'/LoginPage/InsertServlet',
            url:'${pageContext.request.contextPath}/RegisterServlet',
            //contentType : "application/x-www-form-urlencoded; charset=utf-8",
            data:{
                "username":username,
                "password":password,
                "comfirpass":comfirpass
            },
            dataType: "text",
            success: function (data) {
                alert(data);
                console.log(data);
                window.location.href="${pageContext.request.contextPath}/index.jsp";
            },
            error: function (e) {
                alert(e);
            }
        })
    });
</script>
-->
