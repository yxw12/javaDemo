<%--
  Created by IntelliJ IDEA.
  User: Yan
  Date: 2018/7/25
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container mt-3">
    <h2>自定义文件上传控件</h2>
    <p>我们可以在父元素添加 .custom-file 类，然后在 input 设置为 type="file" 并添加 .custom-control-label:</p>
    <form action="/action_page.php">
        <p>自定义上传文件样式:</p>
        <div class="custom-file mb-3" style="width: 20%;">
            <input type="file" class="custom-file-input" id="customFile" name="filename">
            <label class="custom-file-label" for="customFile">文件导入</label>
        </div>&nbsp;&nbsp;&nbsp;&nbsp;
        <div class="custom-file mb-3" style="width: 20%;">
            <input type="file" class="custom-file-input" id="outFile" name="filename">
            <label class="custom-file-label" for="customFile">文件导出</label>
        </div>


        <div class="mt-3">
            <button type="submit" class="btn btn-primary">提交</button>
        </div>
    </form>
</div>

</body>
</html>
