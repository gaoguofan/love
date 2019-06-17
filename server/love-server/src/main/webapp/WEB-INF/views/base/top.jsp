
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="<%=basePath%>static-resource/css/browser/reset.css"
	type="text/css" />

<div class="site_header clearfix">
	<div class="site_header_left">
		<!-- <img src="http://qiniu.jobwisdom.cn/system/images/new_logo.png"> -->
		<img src="http://qiniu.jobwisdom.cn/ucd/f5148b_gaitubao_com_800x272.jpg" style="width: 130px; margin-top: 10;">
	</div>
	<style>
.header_active_1 {
	color: #72b39f !important;
}

.common_active {
	display: inline-block;
	border-bottom: 2px solid white;
	height: 30px;
	position: absolute;
	width: 30px
}

.site_header_right_ul ul {
	display: none
}
</style>
	<style>
.fenye {
	overflow: hidden;
	float: right;
	height: 60px;
	line-height: 35px
}

.fenye span {
	float: left;
	margin-right: 10px;
}

.fenye ul {
	float: right
}

.pagination li {
	float: left;
	text-align: center;
	height: 28px;
	line-height: 28px;
	border: 1px solid #d8e9e9;
	width: 28px;
	margin-right: 10px;
	background: #ccc;
}

.pagination li a {
	color: #fff
}

.pagination li.active {
	border: 1px solid #d8e9e9;
	background-color: #323a4c;
	color: #fff !important
}

.pagination li.active a {
	color: #fff
}

.pagination li.first, .pagination li.last, .pagination li.next,
	.pagination li.prev {
	width: 60px;
	height: 30px;
	background-color: #323a4c
}

.pagination li:hover {
	background: #5d6c8f
}
</style>
	<div class="site_header_right">

		${session_key_system_head_menu } ${session_key_system_left_submenu }
		<!-- 		      <ul class="clearfix"> -->
		<!-- 			    <li><span class="active">业务</span><em><img src="http://qiniu.jobwisdom.cn/system/images/index_xg.png"></em></li> -->
		<!-- 				<li><span>微信</span><em><img src="http://qiniu.jobwisdom.cn/system/images/index_xg.png"></em></li> -->
		<!-- 				<li><span>统计</span><em><img src="http://qiniu.jobwisdom.cn/system/images/index_xg.png"></em></li> -->
		<!-- 				<li><span>服务</span><em><img src="http://qiniu.jobwisdom.cn/system/images/index_xg.png"></em></li> -->
		<!-- 				<li><span>设置</span><em><img src="http://qiniu.jobwisdom.cn/system/images/index_xg.png"></em></li> -->
		<!-- 			  </ul> -->

		<!-- 				 <ul class="clearfix"> -->
		<!-- 				  <li class="fc">基础设置</li> -->
		<!-- 				  <li>短信充值</li> -->
		<!-- 				  <li>管理员设置</li> -->
		<!-- 				  <li>角色管理</li> -->
		<!-- 				  <li>短信发送流水</li>   -->
		<!-- 				</ul> -->
		<!-- 			  </div> -->
	</div>


	<div class="logout">
		<a href="javascript:showPass();"><img
			src="http://qiniu.jobwisdom.cn/system/images/adjust-password.png">修改密码</a>
		<a href="javascript:loginOut()"><img
			src="http://qiniu.jobwisdom.cn/system/images/logout.png">退出</a>
	</div>
</div>
<div class="adjust-password-mask" style="display: none">
	<div class="adjust-password">
		<p>修改密码</p>
		<div class="adjust-password-content">
			<p>
				<span>原密码</span><input type="password" name="maskCode">
			</p>
			<p>
				<span>修改密码</span><input type="password" name="newCode">
			</p>
			<p>
				<span>确认密码</span><input type="password" name="newCode2">
			</p>
		</div>
		<div class="base_set_button">
			<button onclick="adjustPasswordSave()">确定</button>
			<button onclick="adjustPasswordHide()">取消</button>
		</div>
	</div>
</div>

<script type="text/javascript">
var requestUrl = document.URL;

function showPass(){
	jQuery('.adjust-password-mask').show();
}

function adjustPasswordHide(){
	jQuery('.adjust-password-mask').hide();
	jQuery('.adjust-password-mask input[name="maskCode"]').val("");
	jQuery('.adjust-password-mask input[name="newCode"]').val("");
	jQuery('.adjust-password-mask input[name="newCode2"]').val("");
}
function adjustPasswordSave(){
	var maskCode = jQuery('.adjust-password-mask input[name="maskCode"]').val();
	var newCode = jQuery('.adjust-password-mask input[name="newCode"]').val();
	var newCode2 = jQuery('.adjust-password-mask input[name="newCode2"]').val();

	oldPwd = CryptoJS.MD5(CryptoJS.MD5(maskCode).toString().toUpperCase()).toString().toUpperCase();
	newPwd = CryptoJS.MD5(CryptoJS.MD5(newCode2).toString().toUpperCase()).toString().toUpperCase();
	if(newCode != newCode2){
		alert("两次密码不一致");
		return;
	}
	if(confirm("你确定修改密码？")){
		jQuery.ajax({
			type : "post",
			url : baseUrl + "user/change/password",
			data: "oldPwd="+ oldPwd + "&newPwd=" + newPwd,
			success : function(data) {
				if(data.code ==0){
					window.location.href = baseUrl;
				}
				else{
					alert(data.msg);
				}
			}
		});
	}
	
}

function loginOut() {
	if(confirm("你确定退出登录吗？")){
		jQuery.ajax({
			type : "post",
			url : baseUrl + "login/out/login",
			data: null,
			success : function(data) {
				console.log(data.msg);
			}
		});
		window.location.href = baseUrl;
	}
	//window.location.href = "http://"+location.host+"/jobwisdom/user/logout";
// 	if (isLoginAgain!=null){
// 		alert("您的账号在其他终端登陆,若非本人操作,请及时修改密码!");
// 	}
}


function tUrl(){
	jQuery('.site_header_right>ul li').click(function(){
    	window.location.href=jQuery(this).attr("url");
    	var u=window.location.href;
	})
}

var menu = {"product":"product/view/productInfo", "project":"project/view/categorys", 
		"comboInfo":"comboInfo/view/comboInfoList", "KeepAccounts" : "KeepAccounts/initializeManuallyOpenOrder", 
		"activity":"activity/view/showactivitysign", "selfcashier":"selfcashier/view/list","member":"member/view/list",
		"member1":"member/combo/view/list","temp":"service/view/view","webchat":"wechat/items/manage"
};
//二级菜单
function munuSecond(u){
		if (typeof(jQuery(".site_header_right_ul ul").find("a[href='"+u+"']").html()) == 'undefined'){
			if (u.indexOf("goods")!=-1){
				u = baseUrl + menu["goods"];
			}
			if (u.indexOf("project")!=-1){
				u = baseUrl + menu["project"];
			}
			if(u.indexOf("artic")!=-1){
				u = baseUrl + menu["webchat"];
				
			}
			if (u.indexOf("comboInfo")!=-1){
				u = baseUrl + menu["comboInfo"];
			}
			if (u.indexOf("KeepAccounts")!=-1){
				u = baseUrl + menu["KeepAccounts"];
			}
			if (u.indexOf("activity")!=-1){
				u = baseUrl + menu["activity"];
			}
			if (u.indexOf("selfcashier")!=-1){
				u = baseUrl + menu["selfcashier"];
			}
			if (u.indexOf("member/view/list")!=-1){
				u = baseUrl + menu["member"]; 
			}
			if(u.indexOf('member/combo/view/list')!=-1){
				u = baseUrl + menu["member1"];		
			}
			if(u.indexOf('temp')!=-1){
				u = baseUrl + menu["temp"];		
			}
			u = u.replace(":80","");
			search(u)
		}else{
			search(u)
		}
}
  function search(url){
	  jQuery('.site_header_right_ul ul').each(function(i,e){
		jQuery(this).find("a[href='"+url+"']").parents('ul').show();
//   		console.log(url)
// 		console.log(jQuery('.ul_content ul').find("a[href='"+url+"']").parents('ul').html())
			var ind=jQuery('.site_header_right_ul').find("a[href='"+url+"']").parents('ul').attr('index');
//			console.log(ind)
			jQuery(".site_header_right>ul li[index="+ind+"] span").addClass('common_active'); 
			jQuery('.site_header_right_ul').find("a[href='"+url+"']").find('li').addClass('header_active_1')
   })	
  }

jQuery(function(){
	tUrl();
    munuSecond(requestUrl);
    hoverlocaltion();
})


function hoverlocaltion(){
	jQuery('.ul_content ul li').hover(function(){
		jQuery(this).find('span').addClass('localtion')
	},function(){		
		jQuery(this).find('span').removeClass('localtion')
	})
}
</script>
