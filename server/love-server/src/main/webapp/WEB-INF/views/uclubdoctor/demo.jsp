<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/";
			String qiniuPath = "http://qiniu.jobwisdom.cn/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0"/>
<meta content="telephone=no" name="format-detection"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
</head>
<body>
	<%@include file="wechatBase.jsp"%>
	<%@include file="dialog.jsp"%>
</body>
</html>
