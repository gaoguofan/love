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
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
<meta content="telephone=no" name="format-detection"/>
<script type="text/javascript" src="<%=basePath %>static-resource/javaScript/j.js"></script>
<script type="text/javascript" src="<%=basePath %>static-resource/javaScript/load.js"></script>
<script type="text/javascript" src="<%=basePath %>static-resource/javaScript/leftmenu.js"></script>
<script src="<%=basePath %>static-resource/javaScript/H.js" type="text/javascript"></script>
<link href="<%=basePath %>static-resource/css/Hui.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<%@include file="wechatBase.jsp"%>
	<%@include file="dialog.jsp"%>
    <header class="H-header H-theme-background-color7" id="header">
        <span tapmode="" onclick="H.closeWin();" class="H-icon H-position-relative H-display-inline-block H-float-left H-vertical-middle H-theme-font-color-white H-padding-horizontal-left-5 H-z-index-100"><i class="H-iconfont H-icon-arrow-left H-font-size-18 H-vertical-middle"></i><label class="H-display-block H-vertical-middle H-font-size-15">返回</label></span>
        <div class="H-header-title H-center-all H-font-size-18 H-text-show-row-1 H-theme-font-color-white H-position-absolute H-width-100-percent"><b><a href="/" style="color:#fff;text-decoration:none;">恋爱话术库</a></b></div>
    </header>
	<header class="H-header H-theme-background-color2" id="header">
		<form  name="formsearch" action="/plus/search.php">
        <div class="H-header-title H-flexbox-horizontal H-vertical-middle H-font-size-18 H-text-show-row-1 H-theme-font-color-white H-position-absolute H-width-100-percent">
            <span class="H-icon H-position-relative H-display-inline-block H-vertical-middle H-theme-font-color-white H-padding-horizontal-right-5 H-z-index-100" style="margin-left: 10px;"><a href="/member" style="color:#fff;"><i class="H-iconfont H-icon-user2 H-font-size-18 H-vertical-middle"></i></a></span>
			<div class="H-header-search H-flex-item H-margin-horizontal-both-10 H-padding-horizontal-both-10 H-position-relative H-theme-background-color2-active H-border-radius-15 H-line-height-normal" style="background:#fff;color:#999;">
                <!--<span class="H-icon H-display-block H-position-absolute H-float-left H-z-index-10 H-vertical-middle" style="height: 100% !important;"><i class="H-iconfont H-icon-search H-font-size-16"></i></span>-->
				<input type="hidden" name="kwtype" value="0" />
                <input id="search-keyword" value=""  name="q" type="text" name=q" placeholder="请输入关键字..." id="H-header-search-text" class="H-width-100-percent H-box-sizing-border-box H-border-none H-padding-horizontal-both-10 H-font-size-14 H-padding-vertical-both-8 H-theme-background-color-transparent H-theme-font-color-white H-padding-horizontal-left-25 H-vertical-middle" style="color:#999;">
            </div>
            <button class="H-icon H-position-relative H-display-inline-block H-vertical-middle H-theme-font-color-white H-padding-horizontal-right-10 H-z-index-100"  type="submit" style="background:#f78;border:0px;"><i class="H-iconfont H-icon-search H-font-size-18 H-vertical-middle"></i></button>
        </div>
		</form>
    </header>
	<!--<div style="width:100%;height:40px;text-align:center;line-height:40px;background:#fff;">
		<a href="/a/gonggao/10427.html" style="color:#000;text-decoration:none;">点会员中心-在线升级-看4万话术和案例-找到女朋友</a>

	</div>-->	<div class="H-channel-title H-flexbox-horizontal H-theme-background-color-white H-vertical-middle H-border-vertical-bottom-after" style="background:#f8f8f8;">
        <div class="H-channel-text H-theme-font-color10 H-flex-item H-font-size-15 H-theme-font-color-black H-padding-10 H-margin-horizontal-right-10 H-text-show-row-1" style="padding:6px 10px;">订单列表</div>
    </div>
	<div class="H-overflow-scrolling H-margin-10 H-position-relative" style="margin:5px;">
        <table style="width: 100%;" class="H-table H-table-fixed H-theme-background-color-white H-border-vertical-top-after H-border-horizontal-left-after">
            <thead>
                <tr>
                    <th style="width: 18%;" class="H-padding-10 H-vertical-align-middle H-font-size-15 H-font-weight-500 H-theme-background-color-f4f4f4 H-border-vertical-bottom-after H-border-horizontal-right-after">订单号</th>
                    <th style="width: 10%;" class="H-padding-10 H-vertical-align-middle H-font-size-15 H-font-weight-500 H-theme-background-color-f4f4f4 H-border-vertical-bottom-after H-border-horizontal-right-after">产品</th>
					<th style="width: 6%;" class="H-padding-10 H-vertical-align-middle H-font-size-15 H-font-weight-500 H-theme-background-color-f4f4f4 H-border-vertical-bottom-after H-border-horizontal-right-after">状态</th>
                    <th style="width: 10%;" class="H-padding-10 H-vertical-align-middle H-font-size-15 H-font-weight-500 H-theme-background-color-f4f4f4 H-border-vertical-bottom-after H-border-horizontal-right-after">时间</th>
                </tr>
            </thead>
            <tbody>
				                <tr>
                    <td style="width: 18%;text-align: center;padding:10px 4px;" class="H-padding-10 H-vertical-align-middle H-font-size-10 H-border-vertical-bottom-after H-border-horizontal-right-after">
						M92471T1560134957RN299					</td>
                    <td style="width: 10%;text-align: center;padding:10px 4px;" class="H-padding-10 H-vertical-align-middle H-font-size-10 H-border-vertical-bottom-after H-border-horizontal-right-after">
						4万话术+聊天实战					</td>
					<td style="width: 6%;text-align: center;padding:10px 4px;" class="H-padding-10 H-vertical-align-middle H-font-size-10 H-border-vertical-bottom-after H-border-horizontal-right-after">未付款</td>
                    <td style="width: 10%;text-align: center;padding:10px 4px;" class="H-padding-10 H-vertical-align-middle H-font-size-10 H-border-vertical-bottom-after H-border-horizontal-right-after">2019-06-10</td>
                </tr>
				            </tbody>
        </table>
    </div>
<div style="width:100%;height:55px;">
</div>
</div>
	<%@include file="footer.jsp"%>
<script>
$(document).ready(function(){
function wSize(){
	var heights = $(window).height(); 
	var heighttop=$(".foc").height();
	var focHeights = $("#header").height();
	var mainboxheight=heights - heighttop - focHeights ;
	//var widths = $(window).width();
	//var left = heights ;//heights - ($("#header").height()+71);
	//$(".mianbox").height(left);
	$("#footer").css('marginBottom', heighttop);	
	//$(".cont").css('minHeight', mainboxheight);	
	
	
}
wSize();
/*
if($(window).height() > 810){
	var heights = $(window).height(); 
	var mgtp = (heights - 810)/2;
	$(".mianbox").height(810);	
	$(".mianbox").css('marginTop', mgtp);	
	};
*/

})
</script>
<script type="text/javascript">
        if (self!=top){
             window.top.location.replace(self.location); 
            }
</script>
</body>
</html>
