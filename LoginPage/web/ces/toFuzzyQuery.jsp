<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>用户显示</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css">
    <script src="${pageContext.request.contextPath}/js/moment-with-locales.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.js"></script>

    <style>
        .table {
            width: 90%;
            max-width: 1200px;
            margin-bottom: 40px;
            margin-left: 5%;
            margin-right: 5%;
        }
    </style>
    <!-- ajax分页 -->
    <style>
        #footer{
            position: absolute;
            bottom:5vh;
            text-align: center;
            color: rgba(60,166,206,1);
        }
        #pagination{
            display: inline-block;
        }
        #pagination li{
            display: inline;
        }
        #select{
            display: inline-block;
            margin-left: 40px;
        }
        #select input[type="text"]{
            width: 30px;
            height: 20px;
            border-width: 1px;
        }
        #select input[type="button"]{
            width: 40px;
            height: 23px;
            border:none;
        }
        ul li{
            cursor: pointer;
        }
    </style>
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
        //复选框的全选和全不选
        $(function (){
            $("#selectall").click(function () {
                $("tbody input").prop("checked",this.checked);
            });
        });

    </script>
</head>
<body >
<div style="background-color: #f8f8f8;">
    <br>
    <span style="font-size: 17px;">&nbsp;&nbsp;当前位置：用户管理&nbsp;>>&nbsp;用户显示</span>

    <a style="font-size: 15px;float:right;padding-right: 6%;" href="${pageContext.request.contextPath}/LoginoutServlet" target="_top">退出</a>
    <img src="${pageContext.request.contextPath}/images/Usericon.png"  style="float:right;padding-right: 7px;">
    <hr>
</div>
<table class="table table-bordered">
    <caption><a href="${pageContext.request.contextPath}/ces/toInsert.jsp" class="btn btn-primary " role="button">添加</a>
        &nbsp;&nbsp;<button class="btn btn-danger " role="button" onclick="batchDeletes()">删除</button>
        &nbsp;&nbsp;<button class="btn btn-default " role="button" onclick="window.location.reload()">刷新</button>
        &nbsp;&nbsp;<a href="${pageContext.request.contextPath}/PageServlet" class="btn btn-default " role="button" >重置</a>
        <form class="navbar-form navbar-right" role="search" action="${pageContext.request.contextPath}/FuzzyQueryServlet" method="post">
            <div class="form-group">

                <!--指定 date标记-->
                <div class='input-group date' id='datetimepicker1'>
                    <input type='text' class="form-control" placeholder="请选择开始时间" name="startDate" value="${startDate}" id="start"/>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar" ></span>
                                </span>
                </div>
                <label>--</label>
                <!--指定 date标记-->
                <div class='input-group date' id='datetimepicker2'>
                    <input type='text' class="form-control" placeholder="请选择结束时间" name="endDate" value="${endDate}" id="end"/>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                </div>
            </div>
            <div class="form-group">
                <input id="search" type="text" name="word" class="form-control" placeholder="请输入姓名" value="${word}">
            </div>
            &nbsp;&nbsp;<button  type="submit" class="btn btn-primary " role="button">查询</button>
        </form>
    </caption>
    <thead>
    <tr>
        <th>
            <input type="checkbox" value="1" id="selectall"  >全选
        </th>
        <th>ID</th>
        <th>姓名</th>
        <th>密码</th>
        <th>性别</th>
        <th>地址</th>
        <th>生日</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pageBean.data}" var="user">
        <tr>
            <td name="checkbox2"><input type="checkbox" value="${user.userId}" name="choose"></td>
            <td><c:out value="${user.userId}"></c:out></td>
            <td><c:out value="${user.username}"></c:out></td>
            <td><c:out value="${user.password}"></c:out></td>
            <td>
                <c:if test="${user.gender==1}">男</c:if>
                <c:if test="${user.gender==0}">女</c:if>
            </td>
            <td><c:out value="${user.address}"></c:out></td>
            <td><c:out value="${user.birthday}"></c:out></td>
            <td><a href="${pageContext.request.contextPath}/UpdateOneUserServlet?userId=${user.userId}" class="btn btn-success btn-xs" data-toggle="modal" data-target="#myModal">编辑</a>
                &nbsp;<button  class="btn btn-danger btn-xs" data-toggle="modal" data-target="#myModalDelete" onclick="Values(${user.userId})" >删除</button>
                &nbsp;<a  href="${pageContext.request.contextPath}/QueryOneUserServlet?userId=${user.userId}" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#myModal" >查看</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!--分页 -->
<div style="text-align: center">
    <div class="pager">
        第${pageBean.pageNumber}/${pageBean.totalPage}页&nbsp;&nbsp;
        总记录数：${pageBean.totalRecord}&nbsp;每页显示：${pageBean.pageSize}&nbsp;&nbsp;
        <li><a href="${pageContext.request.contextPath}/FuzzyQueryServlet?pageNumber=1&&startDate=${startDate}&&endDate=${endDate}&&word=${word}">首页</a></li>&nbsp;
        <c:if test="${pageBean.pageNumber gt 1}">
            <li><a href="${pageContext.request.contextPath}/FuzzyQueryServlet?pageNumber=${pageBean.pageNumber-1}&&startDate=${startDate}&&endDate=${endDate}&&word=${word}">上一页</a></li>

            <!--       <a href="${pageContext.request.contextPath}/PageServlet?pageNumber=1">[首页]</a>|&nbsp;
            <a href="${pageContext.request.contextPath}/PageServlet?pageNumber=${pageBean.pageNumber-1}">[上一页]</a>|&nbsp;
            -->
        </c:if>
        &nbsp;
        <c:forEach var="1" begin="1" end="${pageBean.totalPage}">
            <c:if test="${pageBean.pageNumber==i}">
                ${i}
            </c:if>
            <c:if test="${pageBean.pageNumber != i}">
                <a href="${pageContext.request.contextPath}/FuzzyQueryServlet?pageNumber=${i}&&startDate=${startDate}&&endDate=${endDate}&&word=${word}">${i}</a>
            </c:if>
        </c:forEach>
        &nbsp;
        <c:if test="${pageBean.pageNumber lt pageBean.totalPage}">
            <li><a href="${pageContext.request.contextPath}/FuzzyQueryServlet?pageNumber=${pageBean.pageNumber+1}&&startDate=${startDate}&&endDate=${endDate}&&word=${word}">下一页</a></li>&nbsp;

            <!--      <a href="${pageContext.request.contextPath}/PageServlet?pageNumber=${pageBean.pageNumber+1}">[下一页]</a>|&nbsp;
            <a href="${pageContext.request.contextPath}/PageServlet?pageNumber=${pageBean.totalPage}">[尾页]</a>
            -->
        </c:if>
        <li><a href="${pageContext.request.contextPath}/FuzzyQueryServlet?pageNumber=${pageBean.totalPage}&&startDate=${startDate}&&endDate=${endDate}&&word=${word}">尾页</a></li>
    </div>
</div>
<!-- 分页结束 -->

<!-- ajax分页
<div id="footer">
    <span id="summary"></span>
    <ul id="pagination">
        <li id="01">首页</li>
        <li id="02">上一页</li>
        <li id="03">下一页</li>
        <li id="04">最后一页</li>
    </ul>
    <div id="select">
        <span>每页显示 </span>
        <input type="text" name="page_size">
        <span>跳转到 </span>
        <input type="text" name="page_num">
        <span>页</span>
        <input type="button" name="go_btn" value="跳转">
    </div>
</div>
 ajax分页结束 -->
</br>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">

        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- /.删除modal -->
<div class="modal fade" id="myModalDelete">
    <div class="modal-dialog">
        <div class="modal-content message_align">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title">提示</h4>
            </div>
            <form action="${pageContext.request.contextPath}/DeleteServlet" method="post">
                <div class="modal-body">
                    <!-- 隐藏需要删除的id -->
                    <input type="hidden" id="deleteid" name="userId"/>
                    <p>您确认要删除该条信息吗？</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default"
                            data-dismiss="modal">取消</button>
                    <button  type="submit" class="btn btn-primary"
                             id="deleteHaulBtn" >确认</button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

</body>
</html>


<script type="text/javascript">
    Values=function (ID) {
        //       alert(ID);
        $("#deleteid").val(ID);
    }

    //批量删除
    function batchDeletes(){
        //判断至少写了一项
        var checkedNum = $("input[name='choose']:checked").length;
        if(checkedNum==0){
            alert("请至少选择一项!");
            return false;
        }
        if(confirm("确定删除所选项目?")){
            var checkedList = new Array();
            $("input[name='choose']:checked").each(function(){
                checkedList.push($(this).val());
            });
            $.ajax({
                type:"POST",
                url:"${pageContext.request.contextPath}/batchDeletesServlet",
                data:{"delitems":checkedList.toString()},
                datatype:"html",
                success:function(data){
                    $("[name='checkbox2']:checkbox").attr("checked",false);
                    location.reload();//页面刷新
                },
                error:function(data){
                    art.dialog.tips('删除失败!');
                }
            });
        }
    }

    // ajax分页
    //  var start_date = "2017-01-01", end_date = "2017-01-08";
    var pageNo = 1;//请求页数
    var pageSize =4;//每页数量
    var pages = 0;//共多少页
    function loadData(pageNo, pageSize){
        $(".detail").remove(); //每次重新从 API 数据接口获取数据都要先清除原先表格 `<tr>` 的内容
        $.ajax({
            url: '${pageContext.request.contextPath}/ajaxPageServlet',
            type: 'POST',
            dataType:'JSON',
            data: {
                "pageNumber": pageNo,
                "pageSize": pageSize,
            },
            success:function(responseJSON){
                var list = responseJSON.data;
                var totalCount = responseJSON.totalRecord;
                pages = responseJSON.totalPage;
                if(list.length != 0){
                    for(var i=0; i<list.length; i++){
                        var userId = list[i].user_id;
                        var username = list[i].user_name;
                        var password = list[i].user_password;
                        var gender = list[i].user_gender;
                        var address = list[i].user_address;
                        var birthday = list[i].user_birthday;
                        appendData(userId, username, password, gender, address, birthday);

                    }
                    $("#table").show();
                    $("#footer").show();
                    displayFooter(totalCount, pages, pageNo,pageSize);
                } else{
                    $("#table").hide();
                    $("#footer").hide();
                }
            },
            error:function(){
                //error handle function
            }
        });
    }
    //注意到我们将 `alarm_id` 作为 `<textarea>` 'class` 的值，也作为提交按钮 `id` 的值，这是因为我们要通过 ajax 将用户输入到某一个 `<textarea>` 的值作为参数传给后台 API 接口，由其写入数据库。
    function appendData(userId, username, password, gender, address, birthday){
        var text = "<tr>" +
                "<td>"+userId+"</td>" +
                "<td>"+username+"</td>" +
                "<td>"+password+"</td>" +
                "<td>"+gender+"</td>" +
                "<td>"+address+"</td>" +
                "<td>"+birthday+"</td>" +
                "</tr>"

        $("#table table").append(text);
    }

    function displayFooter(totalCount, pages, pageNo,pageSize){
        var newText = '共' + totalCount + '条，' + '第' + pageNo + '页，' + '共' + pages + '页'+'每页显示：'+pageSize;
        $("#summary").text(newText);
    }
    $("input[name='page_num']").keydown(function(e){
        if(e.keyCode == 13){
            $("input[name='go_btn']").click();
        }
    });

    $("input[name='go_btn']").click(function(){
        var goPage = $("input[name='page_num']").val();
        if(goPage >= 1 && goPage <=pages && goPage != pageNo){
            pageNo = goPage;
            loadData(pageNo, pageSize);
        } else{
            return false;
        }
    });

    $("#01").click(function(){
        pageNo = 1;
        loadData(pageNo, pageSize);
    });

    $("#04").click(function(){
        pageNo = pages;
        loadData(pageNo, pageSize);
    });

    $("#02").click(function(){
        if(pageNo == 1){
            return false;
        } else{
            pageNo--;
            loadData(pageNo, pageSize);
        }
    });

    $("#03").click(function(){
        if(pageNo == pages){
            return false;
        } else{
            pageNo++;
            loadData(pageNo, pageSize);
        }
    });

</script>

