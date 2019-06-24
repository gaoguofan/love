<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
	String qiniuPath = "http://qiniu.jobwisdom.cn/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html style="overflow: hidden;">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
</svg>
	<%@include file="wechatBase.jsp"%>
	<%@include file="dialog.jsp"%>
	<script type="text/javascript">
	var info = '${info}';
	var openId = '${openId}';
	var wechatOrder = {"info":info, "openId":openId};
	$(function () {
		$.ajax({
			  type : "POST",
			  url : baseUrl + "app/pay/js/api",
			  contentType: "application/json;charset=utf-8",
			  dataType: "json",
			  data : JSON.stringify(wechatOrder),
			  success : function(e){
				  var rj = e.msg;
				  init_pay(rj);
			  }
		  });
	});
	
	function init_pay(rj) {
		 WeixinJSBridge.invoke('getBrandWCPayRequest', {
		       "appId" : rj.appId,
		       "timeStamp" : rj.timeStamp,
		       "nonceStr" : rj.nonceStr,
		       "package" : rj.package,
		       "signType" : rj.signType,
		       "paySign" : rj.paySign
		   }, function(res) {
		       if (res.err_msg == "get_brand_wcpay_request:ok") {
		    	   	dialog("支付成功");
		    	   	window.location.href="http://www.sumer.ink/pay_ok.html";
		       }else {
		    	    dialog("支付失败");
		       }
		   });
	}
	</script>
</body>
</html>
