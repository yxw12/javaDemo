<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<title>Bootstrap 实例 - 水平表单</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<form class="form-horizontal" role="form" action="pay">
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">商品订单</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="out_trade_no"
					id="out_trade_no" placeholder="请输入商品订单">
			</div>
		</div>

		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">商品名称</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="body" id="body"
					placeholder="请输入商品名称">
			</div>
		</div>

		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">商品价格</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="total_fee"
					id="total_fee" placeholder="请输入商品价格">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">支付</button>
			</div>
		</div>
	</form>
</body>
</html>