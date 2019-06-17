<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css" />
</head>
<body>
	<div class="container" id="container">
		<div class="page msg_success js_show">
			<div class="weui-msg">
				<div class="weui-msg__icon-area">
					<i class="weui-icon-success weui-icon_msg"></i>
				</div>
				<div class="weui-msg__text-area">
					<h2 class="weui-msg__title">支付成功</h2>
					<p class="weui-msg__desc">订单支付已完成，请联系商家进行测评或提醒发货</p>
				</div>
				<div class="weui-msg__opr-area">
					<p class="weui-btn-area">
						<a href="javascript:window.close();"
							class="weui-btn weui-btn_default">关闭</a>
					</p>
				</div>
				<div class="weui-msg__extra-area">
					<div class="weui-footer">
						<p class="weui-footer__links"></p>
						<p class="weui-footer__text">如订单有疑问？请咨询商家</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
