<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<body>
<br>
&nbsp;&nbsp;欢迎你:&nbsp;&nbsp;${username} <%--<%=request.getAttribute("username")%>--%>
<hr>
<br>
<form action="${pageContext.request.contextPath }/queryitem.do" method="post">
查询条件：
<table width="100%" border=1 cellspacing="0">
<tr>
	<td>
	商品id&nbsp;<input type="text" name="product.pid">&nbsp;&nbsp;&nbsp;
	商品名称&nbsp;<input type="text" name="product.pname">&nbsp;&nbsp;&nbsp;
    <input type="submit" value="查询"/>
	</td>
</tr>
</table>
</form>
<form action="${pageContext.request.contextPath }/deleteitem.do" method="post">
商品列表：
<table width="100%" border=1 cellspacing="0">
<tr>
	<td><input type="checkbox" name="ids" value=""></td>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${itemList }" var="item">
<tr>
	<td><input type="checkbox" name="ids" value="${item.pid }"></td>
	<td>${item.pname }</td>
	<td>${item.price }</td>
	<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	<td>${item.detail }</td>
	
	<td><a href="${pageContext.request.contextPath }/findProById.do?pid=${item.pid}">修改</a></td>

</tr>
</c:forEach>
    <input type="submit" value="删除">
</table>
</form>
<br>
<br>
<hr>
<br>
<%--批量修改--%>
<form action="${pageContext.request.contextPath }/updatePros.do" method="post">
	商品列表：
	<table width="100%" border=1 cellspacing="0">
		<tr>
			<td><input type="checkbox" name="ids" value=""></td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>生产日期</td>
			<td>商品描述</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${itemList }" var="item" varStatus="s">
			<tr>
				<td><input type="checkbox" name="ids" value="${item.pid }"></td>
				<input type="hidden" name="productList[${s.index}].pid" value="${item.pid }"/>
				<td><input type="text" name="productList[${s.index}].pname" value="${item.pname }"></td>
				<td><input type="text" name="productList[${s.index}].price" value="${item.price }"></td>
				<td><input type="text" name="productList[${s.index}].createtime"
						   value="<fmt:formatDate value="${item.createtime}"
						   pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
				<td><input type="text" name="productList[${s.index}].detail" value="${item.detail }"></td>

				<td><a href="${pageContext.request.contextPath }/findProById.do?pid=${item.pid}">修改</a></td>

			</tr>
		</c:forEach>
		<input type="submit" value="批量修改">
	</table>
</form>
</body>

</html>