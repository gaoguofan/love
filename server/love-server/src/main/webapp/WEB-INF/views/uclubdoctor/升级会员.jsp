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
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
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
<!-- 	<header class="H-header H-theme-background-color2" id="header">
		<form  name="formsearch" action="/plus/search.php">
        <div class="H-header-title H-flexbox-horizontal H-vertical-middle H-font-size-18 H-text-show-row-1 H-theme-font-color-white H-position-absolute H-width-100-percent">
            <span class="H-icon H-position-relative H-display-inline-block H-vertical-middle H-theme-font-color-white H-padding-horizontal-right-5 H-z-index-100" style="margin-left: 10px;"><a href="/member" style="color:#fff;"><i class="H-iconfont H-icon-user2 H-font-size-18 H-vertical-middle"></i></a></span>
			<div class="H-header-search H-flex-item H-margin-horizontal-both-10 H-padding-horizontal-both-10 H-position-relative H-theme-background-color2-active H-border-radius-15 H-line-height-normal" style="background:#fff;color:#999;">
                <span class="H-icon H-display-block H-position-absolute H-float-left H-z-index-10 H-vertical-middle" style="height: 100% !important;"><i class="H-iconfont H-icon-search H-font-size-16"></i></span>
				<input type="hidden" name="kwtype" value="0" />
                <input id="search-keyword" value=""  name="q" type="text" name=q" placeholder="复制女生话中的两个字，搜索即可" id="H-header-search-text" class="H-width-100-percent H-box-sizing-border-box H-border-none H-padding-horizontal-both-10 H-font-size-14 H-padding-vertical-both-8 H-theme-background-color-transparent H-theme-font-color-white H-padding-horizontal-left-25 H-vertical-middle" style="color:#999;">
            </div>
            <button class="H-icon H-position-relative H-display-inline-block H-vertical-middle H-theme-font-color-white H-padding-horizontal-right-10 H-z-index-100"  type="submit" style="background:#f78;border:0px;"><i class="H-iconfont H-icon-search H-font-size-18 H-vertical-middle"></i></button>
        </div>
        <input type="hidden" name="search_types" id="search_type" value="">
		</form>
    </header> -->
	<!-- <div style="width:100%;height:40px;text-align:center;line-height:40px;background:#fff;">
		<a href="/a/gonggao/10427.html" style="color:#000;text-decoration:none;">点会员中心-在线升级-看4万话术和案例-找到女朋友</a>

	</div>	
	<div class="H-text-list H-flexbox-horizontal  H-theme-background-color-white H-border-vertical-bottom-after H-vertical-middle H-touch-active">
		<div class="H-flex-item H-padding-horizontal-both-10 H-font-size-16 H-padding-vertical-both-8">
			恋爱话术库VIP会员
		</div>
	</div> -->
<form name="f1" action="buy_action.php" method="post">
              <input type="hidden" name="product" value="member" />
	<div class="test-box">
        
<div class='test-tab'>
			<input type='radio' name='pid' class='test-radio' value='26' id='radio26'>
            <label for='radio26' class='test-label'>
				<div style='width:100%;height:24px;line-height:24px;font-size:14px;font-weight:bold;margin-top:10px;'>4万恋爱话术</div>
				<div style='width:100%;height:24px;line-height:24px;font-size:14px;margin-bottom:8px;'>永久vip会员</div>
				<div style='width:100%;height:24px;line-height:24px;font-size:14px;font-weight:bold;color:red;margin-bottom:10px;'>￥ 199.00</div>
			</label>
        </div>
    
<div class='test-tab'>
			<input type='radio' name='pid' class='test-radio' value='4' id='radio4'>
            <label for='radio4' class='test-label'>
				<div style='width:100%;height:24px;line-height:24px;font-size:14px;font-weight:bold;margin-top:10px;'>4万话术+聊天实战</div>
				<div style='width:100%;height:24px;line-height:24px;font-size:14px;margin-bottom:8px;'>永久高级会员【推荐】</div>
				<div style='width:100%;height:24px;line-height:24px;font-size:14px;font-weight:bold;color:red;margin-bottom:10px;'>￥ 299.00</div>
			</label>
        </div>
    
<div class='test-tab'>
			<input type='radio' name='pid' class='test-radio' value='8' id='radio8'>
            <label for='radio8' class='test-label'>
				<div style='width:100%;height:24px;line-height:24px;font-size:14px;font-weight:bold;margin-top:10px;'>4万话术实战+教程</div>
				<div style='width:100%;height:24px;line-height:24px;font-size:14px;margin-bottom:8px;'>永久高级会员【推荐】</div>
				<div style='width:100%;height:24px;line-height:24px;font-size:14px;font-weight:bold;color:red;margin-bottom:10px;'>￥ 399.00</div>
			</label>
        </div>
    
<div class='test-tab'>
			<input type='radio' name='pid' class='test-radio' value='22' id='radio22'>
            <label for='radio22' class='test-label'>
				<div style='width:100%;height:24px;line-height:24px;font-size:14px;font-weight:bold;margin-top:10px;'>全部+恋爱四步视频</div>
				<div style='width:100%;height:24px;line-height:24px;font-size:14px;margin-bottom:8px;'>永久至尊会员</div>
				<div style='width:100%;height:24px;line-height:24px;font-size:14px;font-weight:bold;color:red;margin-bottom:10px;'>￥ 1000.00</div>
			</label>
        </div>
    
<div class='test-tab'>
			<input type='radio' name='pid' class='test-radio' value='12' id='radio12'>
            <label for='radio12' class='test-label'>
				<div style='width:100%;height:24px;line-height:24px;font-size:14px;font-weight:bold;margin-top:10px;'>5000恋爱话术</div>
				<div style='width:100%;height:24px;line-height:24px;font-size:14px;margin-bottom:8px;'>永久初级会员</div>
				<div style='width:100%;height:24px;line-height:24px;font-size:14px;font-weight:bold;color:red;margin-bottom:10px;'>￥ 99.00</div>
			</label>
        </div>
            <div style="font: 0px/0px sans-serif;clear: both;display: block"> </div>
		  <div style="width:90%;height:40px;margin:20px auto;"><button class="goumaibt" type="submit">立 即 支 付</button></div>
		   <!-- <li>【注意】广大学员强烈推荐高级会员，千万人千万次的经验，万金买不到</li> -->
		<div style="font: 0px/0px sans-serif;clear: both;display: block"> </div>
    </div>
</form>
            
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
