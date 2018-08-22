<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}
</style>
</head>

<body>


	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div style="margin: 0 auto; margin-top: 10px; width: 950px;">
				<strong>我的订单</strong>
				<table class="table table-bordered">

					    <c:forEach items="${orderList}" var="orders">
							<tbody>
							<tr class="success">
								<th colspan="5">订单编号:${orders.oid}&nbsp;&nbsp;${orders.state==0?"未付款":"已付款"}</th>
							</tr>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
							</tr>
							<c:forEach items="${orders.orderItems}" var="orderitem">
								<tr class="active">
									<td width="60" width="40%">
										<img src="${pageContext.request.contextPath}/${orderitem.product.pimage}" width="70" height="60">
									</td>
									<td width="30%"><a target="_blank">${orderitem.product.pname}</a></td>
									<td width="20%">￥${orderitem.product.shop_price}</td>
									<td width="10%">${orderitem.count}</td>
									<td width="15%"><span class="subtotal">￥${orderitem.subtotal}</span></td>
								</tr>
							</c:forEach>
							</tbody>
					    </c:forEach>


				</table>
			</div>
		</div>
		<div style="text-align: center;">
			<ul class="pagination">
				<!-- 上一页 -->
				<c:if test="${pageBean.currentNumber==1}">
				<li class="disabled"><a href="javascript:void(0);" aria-label="Previous"><span
						aria-hidden="true">&laquo;</span></a></li>
				</c:if>
				<c:if test="${pageBean.currentNumber!=1}">
					<li><a href="${pageContext.request.contextPath}/product?method=myPageOrders&currentNumber=${pageBean.currentNumber-1}" aria-label="Previous"><span
							aria-hidden="true">&laquo;</span></a></li>
				</c:if>

				<!-- 显示每一页 -->
				<c:forEach begin="1" end="${pageBean.totalPage}" var="page">
				<!-- 判断是否是当前页 -->
					<c:if test="${page == pageBean.currentNumber}">
						<li class="active"><a href="javascript:void(0);">${page}</a></li>
					</c:if>
					<c:if test="${page != pageBean.currentNumber}">
						<li  ><a href="${pageContext.request.contextPath}/product?method=myPageOrders&currentNumber=${page}">${page}</a></li>
					</c:if>
				</c:forEach>

				<!-- 下一页 -->
				<c:if test="${pageBean.currentNumber==pageBean.totalPage}">
					<li class="disabled"><a href="javascript:void(0);" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
				<c:if test="${pageBean.currentNumber!=pageBean.totalPage}">
					<li><a href="${pageContext.request.contextPath}/product?method=myPageOrders&currentNumber=${pageBean.currentNumber+1}" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>

			</ul>
		</div>
		<!-- 分页结束 -->
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>
	
</body>

</html>