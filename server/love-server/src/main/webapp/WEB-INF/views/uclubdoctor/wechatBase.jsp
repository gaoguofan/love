<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String wechatBasePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js?time=20170412"> </script>
<script type="text/javascript">
var appId = "<%=request.getAttribute("appId")%>";
var timestamp = "<%=request.getAttribute("timestamp")%>";
var nonceStr = "<%=request.getAttribute("nonceStr")%>";
var signature = "<%=request.getAttribute("signature")%>";
</script>
<script type="text/javascript">
	var baseUrl = "<%=basePath%>";
</script>
<script src="<%=wechatBasePath%>static-resource/javaScript/mobile/wxapi.js?time=20170412"></script>
<script type="text/javascript" src="<%=basePath %>static-resource/javaScript/jQuery/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>static-resource/javaScript/uclubdoctor/zepto.min.js"></script>