<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <title>AJAX</title>
    <script type="text/javascript">
      function ajaxInvoke() {
          var uname=$("#username").val();
          $.ajax({
              async:false,//ajax默认是异步的 如果设置了false就变成了同步。
              //请求方式
              type:'post',
              //请求的地址
              url:"/ajax/MyServlet",
              //发送的数据
              data:{
                    username:uname
              },
              //返回值的类型，一般使用两种text,json
              //dataType:'text',
              dataType:'json',
              success:function (responseJSON){//ajax调用成功后的回调方法
                  // //JQuery把字符串解析成json对象
                  // var jsonObj=$.parseJSON(responseJSON);
                  for(var i=0;i<responseJSON.length;i++){
                      alert(responseJSON[i].id+"   "+responseJSON[i].name+"   "+responseJSON[i].age);
                  }
                   //alert(responseJSON.id+"   "+responseJSON.name+"   "+responseJSON.age);
                  //如果dataType是json那么要求后台一定返回JSONObject或者JSONArray对象,这个后台的json对象会直接换成js中的json
              },
              error:function () {//调用的失败方法
                  alert("系统错误");
              }
          })
      }
    </script>
  </head>
  <body>
    <input type="text" id="username" name="username">
    <<input type="button" value="点击" onclick="ajaxInvoke()">
  </body>
</html>
