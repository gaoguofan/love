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
<script src="<%=basePath %>static-resource/javaScript/H.js" type="text/javascript"></script>
<link href="<%=basePath %>static-resource/css/Hui.css" type="text/css" rel="stylesheet" />
<style>.mainbox img{width:100% !important;}</style>
</head>
<body>
	<%@include file="wechatBase.jsp"%>
	<%@include file="dialog.jsp"%>
	<%@include file="禁止下拉.jsp"%>
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

	</div><div style="width:100%;padding:100px 0px;line-height:2em;font-size:1.6rem;text-align:center;">
这篇文档需要 <font color='red'>永久初级会员</font> 才能访问<br>你目前是：<font color='red'>注册会员</font> ！<br><br><font color='red'><a href='/member/buy.php' style='color:red;'>【登录账号在线升级,持续更新】或联系</a><br>QQ 170828958 开通会员就送聊天秘籍</br></a>【开通会员权限】<br>
			1.开通模糊搜索功能，更精准<br>
			2.可查看4万多全部恋爱话术<br>
			3.可查看100多聊天实战截图<br>
			4.可查看上千精品教程<br>
			5.进500恋爱达人群互动答疑<br>
			6.导师免费在线指导一次<br>			
			</font></div>
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
