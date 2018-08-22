<%--
  Created by IntelliJ IDEA.
  User: Yan
  Date: 2018/7/9
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>用户登录</title>
    <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
</head>

<body>
<div class="login_box">
    <div class="login_l_img"><img src="images/login-img.png" /></div>
    <div class="login">
        <div class="login_logo"><a href="#"><img src="images/login_logo.png" /></a></div>
        <div class="login_name" >
            <p><a href="${pageContext.request.contextPath}/index.jsp" style="font-size: 18px;">登录</a>
                &nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/ces/register.jsp" style="font-size: 18px;">注册</a></p>
        </div>
        <%--      <form method="post" action="${pageContext.request.contextPath}/LoginServlet">--%>
                 <input name="username" type="text"  id="username" value="用户名"  onfocus="this.value=''" onblur="if(this.value==''){this.value='用户名'}">
                 <span id="password_text" onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();" >密码</span>
                 <input name="password" type="password" id="password" style="display:none;" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};"/>
                 <input value="登录" style="width:100%;" type="button" class="form-control" id="registButton" onclick="ajaxInvoke()" >
          <%--        <span style="color: #27A9E3;" id="error" class="error"><%=request.getAttribute("errorMessage")%></span>--%>
          <span  style="color: #27A9E3;font-size: 15px;" id="showErrorSpan" ></span>
<%--      </form>--%>
 </div>
 <div></div>
</div>
</body>
</html>
<style>
    .style {
        width: 100%;
        margin-bottom: 15px;
    }
</style>
<script type="text/javascript">
            function ajaxInvoke() {
                var uname=$("#username").val();
                var upass=$("#password").val();
                $.ajax({
                    async:false,//ajax默认是异步的 如果设置了false就变成了同步。
                    //请求方式
                    type:'post',
                    //请求的地址
                    url:"${pageContext.request.contextPath}/LoginServlet",
                    //发送的数据
                    data:{
                        "username":uname,
                        "password":upass
                    },
                    //返回值的类型，一般使用两种text,json
                    dataType:'text',
                  //  dataType:'json',
                    success:function (data){//ajax调用成功后的回调方法

                   //     alert(typeof data);
                        if(eval(data)){//boolean类型
                            window.location.href="${pageContext.request.contextPath}/PageServlet";
                        }else {
                            $("#showErrorSpan").text("用户名或密码错误！");
                        }
                    },
                    error:function () {//调用的失败方法
                        alert("系统错误");
                    }
                })
            }
</script>
 <!--$(function () {
     $("input[name='username']").blur(function () {
         //1.确定请求路径
         var url="${pageContext.request.contextPath}/LoginServlet";
         //2.确定请求参数
         var params={"username":$(this).val()};
         //3.发送ajax请求
         $.post(url,params,function (data) {
             //4.给“提示显示”区域添加label样式
             $("#showErrorSpan").addClass("label");
             if(data.flag){
                 //可用,添加success样式，并移除按钮禁用
                 $("#showErrorSpan").addClass("label-success");
                 $("#showErrorSpan").removeClass("label-success");
                 $("#registButton").removeProp("disabled");
         }else{
             //不可用,添加danger样式，并禁用按钮
                 $("#showErrorSpan").addClass("label-danger");
                 $("#showErrorSpan").removeClass("label-success");
                 $("#registButton").prop("disabled","disabled");
             }
             //设置提示信息
             $("#showErrorSpan").text(data.message);
         },"json");
   });
 });
</script>
<!--
<script type="text/javascript">
 var userName= document.getElementById("username");
 var passWord= document.getElementById("password");
 function myfunction(){
     $.ajax({
         data:{
             "username":userName,
             "password":passWord,
         },
         dataType:"text",
         type:"post",
         url:"${pageContext.request.contextPath}/LoginServlet",
         success:function(data){
             if(data.errcroe=="400"){
                 $("#error").append("<span>"+data.msg+"</span>");
                 alert(data.msg);
             }
             /*$.each(data.messafe,function(index,item{
              alert("message")
              });*/
         }
     });
 }
</script>
-->
