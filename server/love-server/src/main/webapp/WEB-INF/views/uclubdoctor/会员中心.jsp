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
<style>
.inmem{height:500px;margin-top:10px;padding:0px 10px;}
.inmem p{width:100%;height:2em;line-height:2em;font-size:1.6rem;display:block;text-align:center;}
.inmem p a{line-height:2em;font-size:1.6rem;display:block;text-align:center;color:red;}
.mtab{width:70%;height:3em;line-height:4em;font-size:1.6rem;text-align:center;border:1px solid #ddd;border-radius:10px;margin:10px auto;background:#fff;}
.mtab a{line-height:3em;font-size:1.6rem;display:block;text-align:center;color:red;}
</style>

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
	<div style="width:100%;height:40px;text-align:center;line-height:40px;background:#fff;">
		<a href="/a/gonggao/10427.html" style="color:#000;text-decoration:none;">点会员中心-在线升级-看4万话术和案例-找到女朋友</a>

	</div>	<div class="H-text-list H-flexbox-horizontal  H-theme-background-color-white H-border-vertical-bottom-after H-vertical-middle H-touch-active">
		<div class="H-flex-item H-font-size-16">
			<a href="/a/keceng/kechengzhongxin/2018/1027/10696.html?1540653984"><img src="<%=basePath %>/static-resource/images/hytb.jpg" width="100%"></a>
		</div>
	</div>
	<div style="margin-top:15px;padding-bottom: 20px;" class="H-flexbox-horizontal H-box-sizing-border-box H-theme-background-color-white H-border-vertical-bottom-after H-clear-both H-padding-horizontal-both-10 H-padding-vertical-both-8 H-touch-active">
        <div style="width:50px;height:50px;"><img src="${userInfo.imagePath }" class="H-width-100-percent H-height-100-percent H-display-block H-border-radius-circle H-border-both"></div>
        <div class="H-flex-item H-padding-horizontal-both-10 H-vertical-middle H-overflow-hidden" style="padding-left: 20px;">
            <div class="H-width-100-percent">
                <strong class="H-font-weight-normal H-display-block H-font-weight-500 H-font-size-16 H-text-show-row-1">${userInfo.phone }</strong>
                <div style="font-size: 1.2rem;" class="H-theme-font-color-999 H-font-size-14 H-padding-vertical-top-3 H-text-show-row-1">
					<c:if test="${userInfo.isVip }">您已是会员用户，继续保持哦</c:if>
					<c:if test="${!userInfo.isVip }">您还不是会员用户，升级后解锁更多姿势哦</c:if>
				</div>
            </div>
        </div>
    </div>
	<div class="H-n-grid H-border-vertical-top-after H-clear-both  H-overflow-auto">
		<a href="<%=basePath %>app/mvp" style="color:#000;text-decoration:none;">
			<div class="H-display-table-cell H-float-left H-box-sizing-border-box H-width-avg-3 H-center-all H-theme-background-color-white H-border-horizontal-right-after H-border-vertical-bottom-after H-padding-vertical-both-10 H-touch-active" style="height: 100px;">
				<div class="H-text-align-center">
					<span class="H-icon H-display-block H-horizontal-center"><i class="H-theme-font-color-red H-iconfont H-icon-official H-font-size-28 H-vertical-middle"></i></span>
					<label class="H-display-block H-font-size-11">会员升级</label>
				</div>
			</div>
		</a>
		<a href="javascript:void(0)" style="color:#000;text-decoration:none;">
			<div class="H-display-table-cell H-float-left H-box-sizing-border-box H-width-avg-3 H-center-all H-theme-background-color-white H-border-horizontal-right-after H-border-vertical-bottom-after H-padding-vertical-both-10 H-touch-active" style="height: 100px;">
				<div class="H-text-align-center">
					<span class="H-icon H-display-block H-horizontal-center"><i class="H-theme-font-color-blue H-iconfont H-icon-group-user H-font-size-28 H-vertical-middle"></i></span>
					<label class="H-display-block H-font-size-11">一对一指导</label>
				</div>
			</div>
		</a>
		<a href="<%=basePath %>app/class" style="color:#000;text-decoration:none;">
			<div class="H-display-table-cell H-float-left H-box-sizing-border-box H-width-avg-3 H-center-all H-theme-background-color-white H-border-horizontal-right-after H-border-vertical-bottom-after H-padding-vertical-both-10 H-touch-active" style="height: 100px;">
				<div class="H-text-align-center">
					<span class="H-icon H-display-block H-horizontal-center"><i class="H-theme-font-color-black H-iconfont H-icon-kefu H-font-size-28 H-vertical-middle"></i></span>
					<label class="H-display-block H-font-size-11">课程中心</label>
				</div>
			</div>
		</a>
	</div>
	<div class="H-text-list H-flexbox-horizontal  H-theme-background-color-white H-border-vertical-bottom-after H-vertical-middle H-touch-active">
		<div class="H-flex-item H-padding-horizontal-both-10 H-font-size-16 H-padding-vertical-both-8">微信搜索：170828958,170828958 联系我们吧</div>
	</div>
	<a href="<%=basePath %>app/order" style="color:#000;text-decoration:none;">
		<div class="H-text-list H-flexbox-horizontal  H-theme-background-color-white H-border-vertical-bottom-after H-vertical-middle H-touch-active">
			<span class="H-icon H-display-block H-margin-horizontal-left-10"><i class="H-iconfont H-icon-search-list H-font-size-18 H-vertical-middle H-theme-font-color5"></i></span>
			<div class="H-flex-item H-padding-horizontal-both-10 H-font-size-16 H-padding-vertical-both-8">订单列表</div>
			<span class="H-icon H-padding-horizontal-right-5 H-display-block"><i class="H-iconfont H-icon-arrow-right H-theme-font-color-ccc H-font-size-14 H-vertical-middle"></i></span>
		</div>
	</a>
	<a href="/static/kefu.html" style="color:#000;text-decoration:none;">
		<div class="H-text-list H-flexbox-horizontal  H-theme-background-color-white H-border-vertical-bottom-after H-vertical-middle H-touch-active">
			<span class="H-icon H-display-block H-margin-horizontal-left-10"><i class="H-iconfont H-icon-user-set H-font-size-18 H-vertical-middle H-theme-font-color1"></i></span>
			<div class="H-flex-item H-padding-horizontal-both-10 H-font-size-16 H-padding-vertical-both-8">联系客服</div>
			<span class="H-icon H-padding-horizontal-right-5 H-display-block"><i class="H-iconfont H-icon-arrow-right H-theme-font-color-ccc H-font-size-14 H-vertical-middle"></i></span>
		</div>
	</a>
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
