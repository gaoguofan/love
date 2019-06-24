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
<script>
	var _hmt = _hmt || [];
	(function() {
		var hm = document.createElement("script");
		hm.src = "https://hm.baidu.com/hm.js?9b04b6953ffb9872983f02eee2929d23";
		var s = document.getElementsByTagName("script")[0];
		s.parentNode.insertBefore(hm, s);
	})();
</script>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0" />
<meta content="telephone=no" name="format-detection" />
<meta name="description" content="恋爱话术
恋爱话术库
恋爱话题库
恋爱话术库app
恋爱话术库软件
遇知音恋爱话术库
抖音恋爱话术库App
西门恋爱话术库
冰雨恋爱话术库
撩妹恋爱话术库
搭讪恋爱话术库
把妹恋爱话术库
土味情话
撩妹网
5000可复制聊天话术库
恋爱话术库4 万可复制聊天的恋爱话术
高情商聊天话术范例
恋爱聊天话术app
和女生聊天话术
谈恋爱语言技巧
5000可复制聊天话术库
提高自己的恋爱情商
5000可复制聊天话术库
撩妹话术app" />
<meta name="keywords" content="恋爱话术库,恋爱话术,恋爱,话术,脱单大师,遇知音40000恋爱话术库,恋爱话术库App,恋爱话术库软件,西门恋爱话术库,冰雨恋爱话术库,撩妹恋爱话术库,搭讪恋爱话术库,把妹恋爱话术库,土味情话" />
<meta name="author" content="order by dede58.com" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="telephone=no" name="format-detection" />
<script type="text/javascript" language="javascript" src="<%=basePath %>static-resource/javaScript/jq.js"></script>
<script type="text/javascript" language="javascript" src="<%=basePath %>static-resource/javaScript/js.js"></script>
<link href="<%=basePath %>static-resource/css/Hui.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<%@include file="wechatBase.jsp"%>
	<%@include file="dialog.jsp"%>
	<header class="H-header H-theme-background-color7" id="header">
        <span tapmode="" onclick="H.closeWin();" class="H-icon H-position-relative H-display-inline-block H-float-left H-vertical-middle H-theme-font-color-white H-padding-horizontal-left-5 H-z-index-100"></span>
        <div class="H-header-title H-center-all H-font-size-18 H-text-show-row-1 H-theme-font-color-white H-position-absolute H-width-100-percent"><b><a href="/" style="color:#fff;text-decoration:none;">恋爱话术库</a></b></div>
    </header>
	
	<header class="H-header H-theme-background-color2" id="header">
		<form name="formsearch" action="/plus/search.php">
        <div class="H-header-title H-flexbox-horizontal H-vertical-middle H-font-size-18 H-text-show-row-1 H-theme-font-color-white H-position-absolute H-width-100-percent">
            <span class="H-icon H-position-relative H-display-inline-block H-vertical-middle H-theme-font-color-white H-padding-horizontal-right-5 H-z-index-100" style="margin-left: 10px;"><a href="/member" style="color:#fff;"><i class="H-iconfont H-icon-user2 H-font-size-18 H-vertical-middle"></i></a></span>
			<div class="H-header-search H-flex-item H-margin-horizontal-both-10 H-padding-horizontal-both-10 H-position-relative H-theme-background-color2-active H-border-radius-15 H-line-height-normal" style="background:#fff;color:#999;">
                <!--<span class="H-icon H-display-block H-position-absolute H-float-left H-z-index-10 H-vertical-middle" style="height: 100% !important;"><i class="H-iconfont H-icon-search H-font-size-16"></i></span>-->
				<input type="hidden" name="kwtype" value="0">
                <input id="search-keyword" value="" name="q" type="text" placeholder="复制女生话中的两个字，搜索即可" class="H-width-100-percent H-box-sizing-border-box H-border-none H-padding-horizontal-both-10 H-font-size-14 H-padding-vertical-both-8 H-theme-background-color-transparent H-theme-font-color-white H-padding-horizontal-left-25 H-vertical-middle" style="color:#999;">
            </div>
            <button class="H-icon H-position-relative H-display-inline-block H-vertical-middle H-theme-font-color-white H-padding-horizontal-right-10 H-z-index-100" type="submit" style="background:#f78;border:0px;"><i class="H-iconfont H-icon-search H-font-size-18 H-vertical-middle"></i></button>
        </div>
		 <input type="hidden" name="search_types" id="search_type" value="">
		</form>
    </header>

	<div style="width:100%;height:40px;text-align:center;line-height:40px;background:#fff;">
		<a href="/a/gonggao/10427.html" style="color:#000;text-decoration:none;">点会员中心-在线升级-看4万话术和案例-找到女朋友</a>
	</div>
<div class="mainboxbg"></div>
<div class="mainbox">
<!--header-->
	<c:forEach items="${loveCategoryInfos }" var="loveCategoryInfo">
		<div class="H-channel-title H-flexbox-horizontal H-theme-background-color-white H-vertical-middle H-border-vertical-bottom-after" style="background:#f8f8f8;">
	        <div class="H-channel-text H-theme-font-color10 H-flex-item H-font-size-15 H-theme-font-color-black H-padding-10 H-margin-horizontal-right-10 H-text-show-row-1" style="padding:6px 10px;">${loveCategoryInfo.infoText }</div>
	    </div>
		<div style="padding-left:3%;background:#fff;">
			<c:forEach items="${loveCategoryInfo.loveCategoryInfos }" var="children">
				<a href="<%=basePath %>app/query/key?key=${children.infoText }" style="text-decoration:none;">
					<button class="H-button H-font-size-14 H-outline-none H-theme-background-color-transparent H-padding-vertical-both-8 H-padding-horizontal-both-20 H-theme-font-color3 H-theme-border-color3 H-theme-border-color3-click H-theme-background-color3-click H-theme-font-color3-click H-border-radius-3" style="padding:2px 10px;">${children.infoText }</button>
				</a>
			</c:forEach>
		</div>
	</c:forEach>
	<div class="H-padding-vertical-bottom-10"></div>
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
