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
	<div class="H-flexbox-horizontal H-theme-background-color-white H-border-vertical-top-after" style="padding-top:10px;">
        <div class="H-flex-item H-center-all H-text-align-center H-touch-active H-theme-font-color-red" onclick="window.location.href='/member/buy.php'">
            <div>
                <span class="H-icon H-display-block H-line-height-normal "><i class="H-iconfont H-icon-vip H-font-size-26"></i></span>
                <strong class="H-font-size-11 H-display-block H-font-weight-normal H-margin-vertical-bottom-2">VIP升级</strong>
            </div>
        </div>
        <div class="H-flex-item H-center-all H-text-align-center H-touch-active H-theme-font-color-red">
            <div>
                <span class="H-icon H-display-block H-line-height-normal"><i class="H-iconfont H-icon-log H-font-size-26"></i></span>
                <strong class="H-font-size-11 H-display-block H-font-weight-normal H-margin-vertical-bottom-2">情感课程</strong>
            </div>
        </div>
        <div class="H-flex-item H-center-all H-text-align-center H-touch-active H-theme-font-color-red">
            <div>
                <span class="H-icon H-display-block H-line-height-normal"><i class="H-iconfont H-icon-review-null H-font-size-26"></i></span>
                <strong class="H-font-size-11 H-display-block H-font-weight-normal H-margin-vertical-bottom-2">情感私教</strong>
            </div>
        </div>
    </div>
	<div class="H-channel-title H-flexbox-horizontal H-theme-background-color-white H-vertical-middle H-border-vertical-bottom-after" style="background:#f8f8f8;">
        <div class="H-channel-line H-theme-background-color2 H-padding-vertical-top-15 H-padding-horizontal-left-3  H-margin-horizontal-left-10"></div>
        <div class="H-channel-text H-theme-font-color10 H-flex-item H-font-size-15 H-theme-font-color-black H-padding-10 H-margin-horizontal-right-10 H-text-show-row-1" style="padding:6px 10px;">精品课程</div>
    </div>
<div style="padding-left:3%;background:#fff;">

	<a href="/a/lmhs/gengxin/" style="text-decoration:none;">
		<button class="H-button H-font-size-14 H-outline-none H-theme-background-color-transparent H-padding-vertical-both-8 H-padding-horizontal-both-20 H-theme-font-color3 H-theme-border-color3 H-theme-border-color3-click H-theme-background-color3-click H-theme-font-color3-click H-border-radius-3" style="padding:2px 10px;">软件更新</button>
	</a>

	<a href="/a/keceng/shipinkechenggengxinzhong/" style="text-decoration:none;">
		<button class="H-button H-font-size-14 H-outline-none H-theme-background-color-transparent H-padding-vertical-both-8 H-padding-horizontal-both-20 H-theme-font-color3 H-theme-border-color3 H-theme-border-color3-click H-theme-background-color3-click H-theme-font-color3-click H-border-radius-3" style="padding:2px 10px;">热点话题</button>
	</a>


</div>
	<div class="H-padding-vertical-bottom-10" style="border-bottom:1px solid #ddd;background:#fff;"></div>
		<div class="H-flexbox-horizontal H-theme-background-color-white H-border-vertical-bottom-after" id="lttwList" style="display: block;">
	        <div class="H-padding-vertical-both-10" style="width: 25%;float: left;"><a href="/a/keceng/kechengzhongxin/10695.html" style="text-decoration:none;"><img src="/uploads/181028/1-1Q02P11603L4.jpg" class="H-display-block H-margin-horizontal-left-10" style="width: 70px; height: 70px;"/></a></div>
	        <div class="H-flex-item H-padding-10">
	            <strong class="H-font-weight-normal font-weight-500 H-font-size-16 H-display-block"><a href="/a/keceng/kechengzhongxin/10695.html" style="color:#000;text-decoration:none;">恋爱话术库报名一对一指导请联系</a></strong>
	            <div class="H-font-size-14 H-theme-font-color-999 H-text-show-row-2 H-margin-vertical-top-2"><a href="/a/keceng/kechengzhongxin/10695.html" style="color:#999;text-decoration:none;">恋爱话术库报名一对一指导请联系恋爱话术库安排导师 微信1：tishen998 ​微信2：lianai900 恋爱话术库 报名一对一指导，你能学习到什么？ 1.能学习最直接，最透彻，最具有杀伤力的泡妞...</a></div>
	        </div>
	    </div>
		<div class="H-flexbox-horizontal H-theme-background-color-white H-border-vertical-bottom-after" id="lttwList" style="display: block;">
	        <div class="H-padding-vertical-both-10" style="width: 25%;float: left;"><a href="/plus/view.php?aid=10760" style="text-decoration:none;"><img src="/images/defaultpic.gif" class="H-display-block H-margin-horizontal-left-10" style="width: 70px; height: 70px;"/></a></div>
	        <div class="H-flex-item H-padding-10">
	            <strong class="H-font-weight-normal font-weight-500 H-font-size-16 H-display-block"><a href="/plus/view.php?aid=10760" style="color:#000;text-decoration:none;">相亲女孩不冷不热，怎么把相亲女</a></strong>
	            <div class="H-font-size-14 H-theme-font-color-999 H-text-show-row-2 H-margin-vertical-top-2"><a href="/plus/view.php?aid=10760" style="color:#999;text-decoration:none;">摘要 为什么你邀约相亲女生总是失败你没有其他选择你手上只有一个女孩子的号码,并且长时间没有和女孩子出去约会了。这时候你可能会很紧张。当你没其他选择时,这个女孩就会变得...</a></div>
        </div>
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
