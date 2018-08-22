function jsonData() {
    //	alert(1);
    var params = '{"pid": 1,"pname": "测试商品","price": 99.9,"detail": "测试商品描述","pic": "123456.jpg"}';

    $.ajax({
        url : "json.do",
        data : params,
        contentType : "application/json;charset=UTF-8",//发送数据的格式
        type : "post",
        dataType : "json",//回调
        success : function(data){
            //		alert(typeof (data));
            alert(data.pname+".."+data.pid+".."+data.price+".."+data.detail+".."+data.pic);
        },
        error:function () {
            alert("系统错误");
        }
    });
}
function checkName() {
    alert("nameValue");
    //使用get请求
    $.post("user/checkName", {"username": "aaa"}, function (result) {
        alert(result + "--" + typeof(result));
    });
}
function findUser(){
    //使用get请求
    $.getJSON("user/findUser", function (result) {
        //alert(result + "--" + typeof(result));
        alert(result.pname);
    });
}


function findUsers(){
    //使用get请求
    $.getJSON("user/findUsers", function (result) {
        //alert(result + "--" + typeof(result));
        $(result).each(function () {
            alert(this.pname);
        });
    });
}