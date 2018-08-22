<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <span>当前位置：用户管理>>用户添加</span>
    <hr>
    <form action="/infos1/AddServlet" method="post"enctype="multipart/form-data">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="gender" value="1" checked>男&nbsp;
                <input type="radio" name="gender" value="0" >女
            </td>
        </tr>
        <tr>
            <td>地址</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td>头像</td>
            <td><input type="file" name="pic"></td>
        </tr>
        <tr>
            <td>生日</td>
            <td><input type="text" name="birthday"></td>
        </tr>
    </table>
    <input type="submit" value="保存">
    </form>
</body>
</html>
