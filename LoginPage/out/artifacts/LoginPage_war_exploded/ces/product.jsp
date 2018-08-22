<%--
  Created by IntelliJ IDEA.
  User: Yan
  Date: 2018/7/12
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css">
    <script src="${pageContext.request.contextPath}/js/moment-with-locales.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.js"></script>
    <title>产品查询</title>

</head>
<body>
<br>
&nbsp;&nbsp;&nbsp;


<div class="navbar-form navbar-left" role="search" >
       <div class="form-group">
           <!--指定 date标记-->
           <div class='input-group date' id='datetimepicker1'>
               <input type='text' class="form-control" placeholder="请选择开始时间"/>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
           </div>
           <label>--</label>
           <!--指定 date标记-->
           <div class='input-group date' id='datetimepicker2'>
               <input type='text' class="form-control" placeholder="请选择结束时间"/>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
           </div>
       </div>
       <div class="form-group">
           <input id="search" type="text" class="form-control" placeholder="Search" >
       </div>
       <button type="submit" class="btn btn-primary hidden-xs" onclick="ajaxInvoke()">Submit</button>
 <%--      <div id="completeShow">--%>
           <table class="table table-bordered" id="table1">
               <thead>
               <tr>
                   <th>ID</th>
                   <th>pname</th>
                   <th>pinyin</th>
               </tr>
               </thead>
               <tbody >
               </tbody>
           </table>
</div>

</body>
</html>
<script type="text/javascript">
    $(function () {
        var picker1 = $('#datetimepicker1').datetimepicker({
            format: 'YYYY-MM-DD',
            locale: moment.locale('zh-cn'),
            //minDate: '2016-7-1'
        });
        var picker2 = $('#datetimepicker2').datetimepicker({
            format: 'YYYY-MM-DD',
            locale: moment.locale('zh-cn')
        });
        //动态设置最小值
        picker1.on('dp.change', function (e) {
            picker2.data('DateTimePicker').minDate(e.date);
        });
        //动态设置最大值
        picker2.on('dp.change', function (e) {
            picker1.data('DateTimePicker').maxDate(e.date);
        });
    });
</script>
<script type="text/javascript">
   function ajaxInvoke() {
       $("#table1 tbody").empty(); //查询前先清空上一次查询的数据

        var word=$("#search").val();
        $.ajax({
            async:false,//ajax默认是异步的 如果设置了false就变成了同步。
            //请求方式
            type:'post',
            //请求的地址
            url:"${pageContext.request.contextPath}/ProductServlet",
            //发送的数据
            data:{
                "word":word
            },
            //返回值的类型，一般使用两种text,json
         //   dataType:'text',
            dataType:'json',
      //      contentType : "application/json;charsetset=UTF-8",
            success:function (data){//ajax调用成功后的回调方法
                var table = $("#table1");
                //table动态添加一行一列
               for(var i=0; i<data.length;i++) {
                   table.append("<tr>" +
                           "<td>"+data[i].pid+"</td>" +
                           "<td>"+data[i].pname+"</td>" +
                           "<td>"+data[i].pinyin+"</td>" +
                           "</tr>");
                }
            },
            error:function () {//调用的失败方法
                alert("系统错误");
            }
        })
    }

 <%--   $(function(){
        $("#search").keyup(function(){
            var url="${pageContext.request.contextPath}/ProductServlet";
            var word=$(this).val();
            if(word == ""){
                //如果没有输入关键字，隐藏提供区域
                $("#completeShow").slideUp(200);
                return false;
            }
            var params={"word":word};
            $.post(url,params,function (data) {
                $("#completeShow").html("<ul id='list' class='list-group'></ul>");
                for(var i=0;i<data.length;i++){
                    var prod = data[i];
                    //处理关键字高亮
                    var str = ""+prod.pname+"("+prod.pinyin+")";
                    str = highlight(word,str);
                    $("#list").append("<li class='list-group-item'><a href='#'>"+str+"</a></li>");
                    $("#completeShow").show();

                }
            });
        }).focus(function () {
            if($("#completeShow li").size()>0){
                $("#completeShow").show();
            }
        }).click(function () {
            return false;
        });

        function highlight(word,str) {
            var start = "";
            var end = str;
            for(var i = 0 ; i < word.length; i++){
                var w = word.substring(i,i+1);
                var index = end.indexOf(w);
                start += end.substring(0,index);
                start += "<font color='red'>"+w+"</font>";
                end = end.substring(index+1,end.length);
            }
            start += end;
            return start;
        }
        $(document).click(function () {
            $("#completeShow").slideUp(200);
        });
    });
    --%>
</script>
