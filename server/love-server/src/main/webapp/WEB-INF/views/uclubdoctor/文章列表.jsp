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
<script type="text/javascript" language="javascript" src="<%=basePath %>static-resource/javaScript/jq.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>static-resource/javaScript/js.js"></script>
<script src="<%=basePath %>static-resource/javaScript/H.js" type="text/javascript"></script>
<link href="<%=basePath %>static-resource/css/Hui.css" type="text/css" rel="stylesheet" />
<style>.jtbj{width:50%;height: 2px;float: left;background:#fff;}</style>

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
                <input id="search-keyword" value=""  name="q" type="text" name=q" placeholder="复制女生话中的两个字，搜索即可" id="H-header-search-text" class="H-width-100-percent H-box-sizing-border-box H-border-none H-padding-horizontal-both-10 H-font-size-14 H-padding-vertical-both-8 H-theme-background-color-transparent H-theme-font-color-white H-padding-horizontal-left-25 H-vertical-middle" style="color:#999;">
            </div>
            <button class="H-icon H-position-relative H-display-inline-block H-vertical-middle H-theme-font-color-white H-padding-horizontal-right-10 H-z-index-100"  type="submit" style="background:#f78;border:0px;"><i class="H-iconfont H-icon-search H-font-size-18 H-vertical-middle"></i></button>
        </div>
        <input type="hidden" name="search_types" id="search_type" value="">
		</form>
    </header>
	<div style="width:100%;height:40px;text-align:center;line-height:40px;background:#fff;">
		<a href="/a/gonggao/10427.html" style="color:#000;text-decoration:none;">点会员中心-在线升级-看4万话术和案例-找到女朋友</a>

	</div>
	<div class="H-flexbox-horizontal H-theme-background-color-white">
        <div class="H-flex-item H-center-all H-padding-vertical-both-10 H-theme-border-color-white H-touch-active H-font-size-16 H-theme-border-color10 H-theme-font-color3" onclick="lttwList.style.display='block';wqtwList.style.display='none';jtbj1.style.display='none';jtbj2.style.display='block';" id="tab1">速约聊天截图</div>
        <div class="H-flex-item H-center-all H-padding-vertical-both-10 H-theme-border-color-white H-touch-active H-font-size-16 H-theme-border-color10 H-theme-font-color3" onclick="lttwList.style.display='none';wqtwList.style.display='block';jtbj1.style.display='block';jtbj2.style.display='none';">长期恋爱解析</div>
    </div>
 <div style="width:100%;height:2px;background:#000;">
<div class="jtbj" id="jtbj1" style="display:none;"></div>
<div class="jtbj" style="background:#000;"></div>
<div class="jtbj" id="jtbj2"></div>
</div>
  <div id="lttwList" style="display: block;">
	<div class="H-flexbox-horizontal H-theme-background-color-white H-border-vertical-bottom-after" >
        <div class="H-padding-vertical-both-10" style="width: 25%;float: left;"><a href="/a/hssz/sy/325.html" style="text-decoration:none;"><img src="/uploads/allimg/180526/1_0526034J34A4.jpg" class="H-display-block H-margin-horizontal-left-10" style="width: 70px; height: 70px;"/></a></div>
        <div class="H-flex-item H-padding-10">
            <strong class="H-font-weight-normal font-weight-500 H-font-size-16 H-display-block"><a href="/a/hssz/sy/325.html" style="color:#000;text-decoration:none;">535期：与20岁的单生美女聊天，超</a></strong>
            <div class="H-font-size-14 H-theme-font-color-999 H-text-show-row-2 H-margin-vertical-top-2"><a href="/a/hssz/sy/325.html" style="color:#999;text-decoration:none;">此截图为未讲解标注版本，如需查看标注版了解为何这样聊天的原理，以及如何像案例中这样搜索话术聊天，可以微信添加导师微信领取与咨询.....</a></div>
        </div>
    </div>
	<div class="H-flexbox-horizontal H-theme-background-color-white H-border-vertical-bottom-after">
        <div class="H-padding-vertical-both-10" style="width: 25%;float: left;"><a href="/plus/view.php?aid=318" style="text-decoration:none;"><img src="/uploads/allimg/180526/1_0526034J34A4.jpg" class="H-display-block H-margin-horizontal-left-10" style="width: 70px; height: 70px;"/></a></div>
        <div class="H-flex-item H-padding-10">
            <strong class="H-font-weight-normal font-weight-500 H-font-size-16 H-display-block"><a href="/plus/view.php?aid=318" style="color:#000;text-decoration:none;">320期：与酒吧里眼睛超大超美超可</a></strong>
            <div class="H-font-size-14 H-theme-font-color-999 H-text-show-row-2 H-margin-vertical-top-2"><a href="/plus/view.php?aid=318" style="color:#999;text-decoration:none;">此截图为未讲解标注版本，如需查看标注版了解为何这样聊天的原理，以及如何像案例中这样搜索话术聊天，可以微信添加导师微信领取与咨询.....</a></div>
        </div>
    </div>
  <div style="font: 0px/0px sans-serif;clear: both;display: block"> </div>
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
