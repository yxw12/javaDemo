<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>黑马商城购物车</title>
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
			
			font {
				color: #3164af;
				font-size: 18px;
				font-weight: normal;
				padding: 0 10px;
			}
			.emptyImage {
				height: 273px;
				padding-left: 558px;
				margin: 65px 0 130px;
				background: url(images/cart-empty.png) no-repeat 124px 0;
				color: #b0b0b0;
				overflow: hidden;
			}
		</style>
	</head>

	<body>
		<!-- 引入header.jsp -->
		<jsp:include page="/header.jsp"></jsp:include>
		<c:if test="${!empty cart.cartItemMap}">
				<div class="container">
					<div class="row">
		
						<div style="margin:0 auto; margin-top:10px;width:950px;">
							<strong style="font-size:16px;margin:5px 0;">订单详情</strong>
							<table class="table table-bordered">
								<tbody>
									<tr class="warning">
										<th>图片</th>
										<th>商品</th>
										<th>价格</th>
										<th>数量</th>
										<th>小计</th>
										<th>操作</th>
									</tr>
									<c:forEach items="${cart.cartItemMap}" var="entity">
										<tr class="active">
												<td width="60" width="40%">
													<input type="hidden" name="id" value="22">
													<img src="${pageContext.request.contextPath}/${entity.value.product.pimage}" width="70" height="60">
												</td>
												<td width="30%">
													<a target="_blank">${entity.value.product.pname}</a>
												</td>
												<td width="20%">
													￥${entity.value.product.shop_price}
												</td>
												<td width="10%">
													<input type="text" name="quantity" value="${entity.value.number}" maxlength="4" size="10">
												</td>
												<td width="15%">
													<span class="subtotal">￥${entity.value.productTotalPrice}</span>
												</td>
												<td>
													<button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#myModalDelete" onclick="Values(${entity.value.product.pid})" class="delete">删除</button>
												</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
		
					<div style="margin-right:130px;">
						<div style="text-align:right;">
							<em style="color:#ff6600;">
						登录后确认是否享有优惠&nbsp;&nbsp;
					</em> 赠送积分: <em style="color:#ff6600;">${cart.cartTotal}</em>&nbsp; 商品金额: <strong style="color:#ff6600;">￥${cart.cartTotal}元</strong>
						</div>
						<div style="text-align:right;margin-top:10px;margin-bottom:10px;">
							<a href="${pageContext.request.contextPath}/product?method=cleanCart" id="clear" class="clear">清空购物车</a>
							<a href="${pageContext.request.contextPath}/product?method=submitCart">
								<input type="button" width="100" value="提交订单" name="submit" border="0" style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
								height:35px;width:100px;color:white;">
							</a>
						</div>
					</div>
		
				</div>
		</c:if>
		<c:if test="${empty cart.cartItemMap}">
			<div class="container" style="height: 350px;">
				<div style="text-align: center;" class="emptyImage">
					<h2>您的购物车还是空的！</h2>
					<p class="login-desc"></p>
					<p class="login-desc"></p>
					<a href="${pageContext.request.contextPath}/" class="btn btn-primary btn-shoping J_goShoping">马上去购物</a>
				</div>
			</div>
		</c:if>
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
					<div >
						<div class="modal-body">
							<!-- 隐藏需要删除的id -->
							<input type="hidden" id="deleteid" name="pid"/>
							<p>您确认要删除该条订单吗？</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
									data-dismiss="modal">取消</button>
							<button  type="submit" class="btn btn-primary"
									 id="deleteHaulBtn" onclick="deletePid()">确认</button>
						</div>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- 引入footer.jsp -->
		<jsp:include page="/footer.jsp"></jsp:include>

	</body>

</html>
<script type="text/javascript">
	Values=function (ID) {
		//       alert(ID);
		$("#deleteid").val(ID);
	}
	function deletePid() {
		var pid=$("#deleteid").val();
		location.href="${pageContext.request.contextPath}/product?method=deleteCartByPid&pid="+pid;
	}

</script>