<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
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
				<strong>订单详情</strong>
				<table class="table table-bordered">
					<tbody>
						<tr class="warning">
							<th colspan="5">订单编号:9005</th>
						</tr>
						<tr class="warning">
							<th>图片</th>
							<th>商品</th>
							<th>价格</th>
							<th>数量</th>
							<th>小计</th>
						</tr>
						<tr class="active">
							<td width="60" width="40%"><input type="hidden" name="id"
								value="22"> <img src="./image/dadonggua.jpg" width="70"
								height="60"></td>
							<td width="30%"><a target="_blank"> 有机蔬菜 大冬瓜...</a></td>
							<td width="20%">￥298.00</td>
							<td width="10%">5</td>
							<td width="15%"><span class="subtotal">￥596.00</span></td>
						</tr>
					</tbody>
				</table>
			</div>

			<div style="text-align: right; margin-right: 120px;">
				商品金额: <strong style="color: #ff6600;">￥596.00元</strong>
			</div>

		</div>

		<div>
			<hr />
			<form 
				id="orderForm"
				class="form-horizontal"
				style="margin-top: 5px; 
				margin-left: 150px;" 
				action="confirm_ok.jsp"
				method="POST">
				<div class="form-group">
					<label for="address" class="col-sm-1 control-label">地址</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="address"
							placeholder="请输入收货地址" name="address">
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-1 control-label">收货人</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="name"
							placeholder="请输收货人" name="name">
					</div>
				</div>
				<div class="form-group">
					<label for="telephone" class="col-sm-1 control-label">电话</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="telephone"
							placeholder="请输入联系方式" name="telephone">
					</div>
				</div>
			</form>

			
			
			<p style="text-align: right; margin-right: 100px;">
				<a href="javascript:document.getElementById('orderForm').submit();">
					<img src="./images/finalbutton.gif" width="204" height="51"
					border="0" />
				</a>
			</p>
			

			
		</div>

	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>

</html>