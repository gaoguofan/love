<!DOCTYPE html>
<html style="background-color: rgb(255, 255, 255); font-size: 50px;">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/";
			String qiniuPath = "http://qiniu.jobwisdom.cn/";
%>
<head>
<meta charset="utf-8">
<meta name="wap-font-scale" content="no">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>个人信息</title>
<meta name="apple-mobile-web-app-capable" content="no">
<meta name="keywords" content="">
<meta name="description" content="">


<script src="<%=basePath %>static-resource/javaScript/uclubdoctor/rembasic.js" type="text/javascript" charset="utf-8"></script>

<link rel="stylesheet" type="text/css" href="<%=basePath %>static-resource/css/uclubdoctor/MultiPicker.css">
<link rel="stylesheet" href="<%=basePath %>static-resource/css/uclubdoctor/pandastar.css">
<link rel="stylesheet" href="<%=basePath %>static-resource/css/uclubdoctor/jquery.datetimepicker.css">
</head>
<body style="">
	<div class="body-container">
		<!-- <div class="toper-wrap">
			<div class="toper-box">
				<div class="toper-left" style="padding: 0;">
					<a class="cb-sgin" href=""> <i class="fa fa-angle-left"
						aria-hidden="true"></i>
					</a>
				</div>
				<div class="toper-middle" style="padding: 0;">个人资料</div>
				<div class="toper-right" style="padding: 0;"></div>
			</div>
		</div> -->
		<div class="datawrap1">
			<div class="databox">
				<div class="databox-left">
					<div class="databox-left-ct">真实者姓名</div>
					<div class="databox-left-et">Real name</div>
				</div>
				<div class="databox-right">
					<input class="text-input" type="text" name="" id="realName" value="${selectByWechatId.userName }"
						placeholder="请填写真实姓名" maxlength="100">
				</div>
			</div>
			<div class="databox">
				<div class="databox-left">
					<div class="databox-left-ct">年龄</div>
					<div class="databox-left-et">Age</div>
				</div>
				<div class="databox-right">
					<input class="age-input" value="${selectByPrimaryKey.birthDate }" type="text" name="" id="datetimepicker" readonly="readonly"  placeholder="请选择" >
				</div>
			</div>
			<div class="databox">
				<div class="databox-left">
					<div class="databox-left-ct">身高</div>
					<div class="databox-left-et">Height</div>
				</div>
				<div class="databox-right">
					<span class="cmtip">&nbsp;CM</span> <input
						class="text-input height-input" type="number" name="" id="userHeight" value="${selectByPrimaryKey.userHeight }"
						placeholder="请填写" maxlength="3">
				</div>
			</div>
			<div class="databox">
				<div class="databox-left">
					<div class="databox-left-ct">体重</div>
					<div class="databox-left-et">Weight</div>
				</div>
				<div class="databox-right">
					<span class="cmtip">&nbsp;KG</span> <input
						class="text-input height-input" type="number" name="" id="userWeight" value="${selectByPrimaryKey.userWeight }"
						placeholder="请填写" maxlength="3">
				</div>
			</div>
		</div>
		<div class="datawrap2">
			<div class="databox">
				<div class="databox-left">
					<div class="databox-left-ct">差点</div>
					<div class="databox-left-et">Handicap</div>
				</div>
				<div class="databox-right">
					<input class="text-input" type="number" name="" id="userCap" value="${selectByPrimaryKey.userCap }"
						placeholder="差点" maxlength="50">
				</div>
			</div>
			<div class="databox">
				<div class="databox-left">
					<div class="databox-left-ct">左右手</div>
					<div class="databox-left-et">  L/R</div>
				</div>
				<div class="databox-right">
					<input class="text-input division-input" type="text" name="" readonly="" id="userHand" value="${selectByPrimaryKey.userHand }"
						placeholder="左右手" maxlength="128">
				</div>
			</div>
			
			
			<div class="databox">
				<div class="databox-left">
					<div class="databox-left-ct">手汗指数</div>
					<div class="databox-left-et">Choose Hand sweat</div>
				</div>
				<div class="databox-right">
					<input class="text-input division-input" type="text" name="" readonly="" id="userHandSweat" value="${selectByPrimaryKey.userHandSweat }"
						placeholder="请选择手汗" maxlength="128">
				</div>
			</div>
			
			
			
			<div class="databox">
				<div class="databox-left">
					<div class="databox-left-ct">手掌长度/中指长度</div>
					<div class="databox-left-et">Choose Hand length</div>
				</div>
				<div class="databox-right">
					<span class="cmtip">&nbsp;mm</span>
					<input class="text-input height-input" type="number" name="" id="userHandLength" value="${selectByPrimaryKey.userHandLength }"
						placeholder="" maxlength="128">
				</div>
			</div>
			
			
			<div class="databox">
				<div class="databox-left">
					<div class="databox-left-ct">锻炼频率</div>
					<div class="databox-left-et">Choose frequency</div>
				</div>
				<div class="databox-right">
					<span class="cmtip">&nbsp;次/周</span>
					<input class="text-input height-input" style="padding-right: 0.7rem;" type="number" name="" id="frequency" value="${selectByPrimaryKey.frequency }"  maxlength="5">
				</div>
			</div>
			
			<div class="databox">
				<div class="databox-left">
					<div class="databox-left-ct">历史伤病</div>
					<div class="databox-left-et">set injury</div>
				</div>
				<div class="databox-right">
					<input class="text-input " type="text" name="" id="injury" value="${selectByPrimaryKey.injury }"
						placeholder="" maxlength="128">
				</div>
			</div>			
			
			
			<div class="databox">
				<div class="databox-left">
					<div class="databox-left-ct">手套尺码</div>
					<div class="databox-left-et">Glove Size</div>
				</div>
				<div class="databox-right">
					<input class="text-input" type="number" name="" id="userGloveSize" value="${selectByPrimaryKey.userGloveSize }"
						placeholder="手套尺码" maxlength="128">
				</div>
			</div>
			<div class="databox">
				<div class="databox-left">
					<div class="databox-left-ct">鞋子尺码</div>
					<div class="databox-left-et">Shoes Size</div>
				</div>
				<div class="databox-right">
					<input class="text-input" type="number" name="" id="userShoesSize" value="${selectByPrimaryKey.userShoesSize }"
						placeholder="记录您的鞋子尺码" maxlength="128">
				</div>
			</div>
			<!-- <div class="databox">
				<div class="databox-left" style="width: 41%;">
					<div class="databox-left-ct">国籍及地区</div>
					<div class="databox-left-et">Nationality and area</div>
				</div>
				<div class="databox-right" style="width: 59%;">
					<input class="text-input Nationality-input" type="text" name=""
						id="Nationality-input" value="" placeholder="国籍" readonly="">
					<input class="text-input area-input" type="text" name=""
						id="area-input" value="" placeholder="请选择地区" readonly="">
					<input class="text-input foreign-area-input" type="text" name=""
						id="foreign-area-input" value="" placeholder="请填写地区"
						maxlength="100">
				</div>
			</div>
			<div class="databox">
				<div class="databox-left">
					<div class="databox-left-ct">选择赛区</div>
					<div class="databox-left-et">Choose division</div>
				</div>
				<div class="databox-right">
					<input class="text-input division-input" type="text" name=""
						id="division-input" value="" placeholder="请选择赛区" readonly="">
				</div>
			</div>
			<div class="databox">
				<div class="databox-left" style="width: 61%;">
					<div class="databox-left-ct">身份证/护照号码</div>
					<div class="databox-left-et">Identity card/passport number</div>
				</div>
				<div class="databox-right" style="width: 39%;">
					<input class="text-input" type="text" name="" id="" value=""
						placeholder="身份证/护照号码" maxlength="100">
				</div>
			</div>
			 -->
		</div>



		<!-- <div class="datawrap5">
			<div class="databox">
				<div class="databox-left">
					<div class="databox-left-ct">家长联系电话</div>
					<div class="databox-left-et">Parents of telephone</div>
				</div>
				<div class="databox-right">
					<input class="text-input" type="text" name="" id="" value=""
						placeholder="家长联系电话" maxlength="11">
				</div>
			</div>
			<div class="databox databox-b0">
				<div class="databox-left" style="width: 21%;">
					<div class="databox-left-ct">家庭住址</div>
					<div class="databox-left-et">Address</div>
				</div>
				<div class="databox-right" style="width: 79%;">
					<input class="text-input Nationality-input2" type="text" name=""
						id="Nationality-input2" value="" placeholder="选择国家" readonly="">
					<input class="text-input area-input2" type="text" name=""
						id="area-input2" value="" placeholder="请选择地区" readonly="">
					<input class="text-input foreign-area-input2" type="text" name=""
						id="foreign-area-input2" value="" placeholder="请填写地区"
						maxlength="100">
				</div>
			</div> 
			<div class="databox-addr">
				<div class="databox-addr-box">
					<textarea class="textarea-input" name="" id="symptomTxt"
						oninput="autoTextAreaHeight(this)" placeholder="请填入详细地址"
						maxlength="100" style="height: 31px;"></textarea>
				</div>
			</div>
		</div>
		<div class="datawrap1 dataw-margint">
			<div class="databox">
				<div class="databox-left">
					<div class="databox-left-ct">推荐机构</div>
					<div class="databox-left-et">Recommendation agency</div>
				</div>
				<div class="databox-right">
					<input class="text-input" type="text" name="" id="" value=""
						placeholder="推荐机构" maxlength="50">
				</div>
			</div>
			<div class="databox">
				<div class="databox-left">
					<div class="databox-left-ct">组别</div>
					<div class="databox-left-et">Group</div>
				</div>
				<div class="databox-right">
					<input class="text-input Group-input" type="text" name=""
						id="Group-input" value="" placeholder="请选择组别" readonly="">
				</div>
			</div>
			<div class="databox">
				<div class="databox-left" style="width: 61%;">
					<div class="databox-left-ct">是否参加走T台</div>
					<div class="databox-left-et">Whether or not attend Image</div>
				</div>
				<div class="databox-right" style="width: 39%;">
					<input class="text-input attend-input" type="text" name=""
						id="attend-input" value="" placeholder="请选择" readonly="">
				</div>
			</div>
		</div>
		<div class="datawrap1 dataw-margint">
			<div class="databox">
				<div class="databox-left">
					<div class="databox-left-ct">作品要求</div>
					<div class="databox-left-et">Entry Requirements</div>
				</div>
				<div class="databox-right">
					<div class="Entry-Requirements">细节详见大赛文创本要求</div>
				</div>
			</div>
		</div> -->
		<div class="datawrap1 dataw-margint">
			<div class="databox">
				<div class="databox-left">
					<div class="databox-left-ct">家长/监护人</div>
					<div class="databox-left-et">The parent or guardian</div>
				</div>
				<div class="databox-right">
					<input class="text-input" type="text" name="" id="userParentName" value=""
						placeholder="请填写家长/监护人" maxlength="50">
				</div>
			</div>
		</div>
		<div class="signupDataSumbit-wrap">
			<div class="sinputSumbit" onclick="saveData()" type="submit" name="" value="提交">Submit</div>
		</div>
		<div class="input-errortip" style="top: 50%;">输入错误</div>
		<!--年龄选择容器-->
		<div id="age-targetContainer">
			<div class="multi-picker-bg" id="multi-picker-bg-age-targetContainer">
				<div class="multi-picker-container"
					id="multi-picker-container-age-targetContainer">
					<div class="multi-picker-btn-box">
						<div class="multi-picker-btn" id="multi-picker-btn-cancel">返回</div>
						<div class="multi-picker-btn"
							id="multi-picker-btn-save-age-targetContainer">确定</div>
					</div>
					<div class="multi-picker-content">
						<div class="multi-picker" style="width: 100%;">
							<ul id="multi-picker-age-targetContainer-0">
								<li data-id="-99"></li>
								<li data-id="-99"></li>
								<li data-id="undefined">6</li>
								<li data-id="undefined">7</li>
								<li data-id="undefined">8</li>
								<li data-id="undefined">9</li>
								<li data-id="undefined">10</li>
								<li data-id="undefined">11</li>
								<li data-id="undefined">12</li>
								<li data-id="undefined">13</li>
								<li data-id="undefined">14</li>
								<li data-id="undefined">15</li>
								<li data-id="undefined">16</li>
								<li data-id="undefined">17</li>
								<li data-id="undefined">18</li>
								<li data-id="undefined">19</li>
								<li data-id="undefined">20</li>
								<li data-id="undefined">21</li>
								<li data-id="undefined">22</li>
								<li data-id="undefined">23</li>
								<li data-id="undefined">24</li>
								<li data-id="-99"></li>
								<li data-id="-99"></li>
							</ul>
						</div>
						<div class="multi-picker-up-shadow"></div>
						<div class="multi-picker-down-shadow"></div>
						<div class="multi-picker-line"></div>
					</div>
				</div>
			</div>
		</div>
		<!--性别选择容器-->
		<div id="sex-targetContainer">
			<div class="multi-picker-bg" id="multi-picker-bg-sex-targetContainer">
				<div class="multi-picker-container"
					id="multi-picker-container-sex-targetContainer">
					<div class="multi-picker-btn-box">
						<div class="multi-picker-btn" id="multi-picker-btn-cancel">返回</div>
						<div class="multi-picker-btn"
							id="multi-picker-btn-save-sex-targetContainer">确定</div>
					</div>
					<div class="multi-picker-content">
						<div class="multi-picker" style="width: 100%;">
							<ul id="multi-picker-sex-targetContainer-0">
								<li data-id="-99"></li>
								<li data-id="-99"></li>
								<li data-id="undefined">男</li>
								<li data-id="undefined">女</li>
								<li data-id="-99"></li>
								<li data-id="-99"></li>
							</ul>
						</div>
						<div class="multi-picker-up-shadow"></div>
						<div class="multi-picker-down-shadow"></div>
						<div class="multi-picker-line"></div>
					</div>
				</div>
			</div>
		</div>
		<!--国籍选择容器-->
		<div id="Nationality-targetContainer">
			<div class="multi-picker-bg"
				id="multi-picker-bg-Nationality-targetContainer">
				<div class="multi-picker-container"
					id="multi-picker-container-Nationality-targetContainer">
					<div class="multi-picker-btn-box">
						<div class="multi-picker-btn" id="multi-picker-btn-cancel">返回</div>
						<div class="multi-picker-btn"
							id="multi-picker-btn-save-Nationality-targetContainer">确定</div>
					</div>
					<div class="multi-picker-content">
						<div class="multi-picker" style="width: 100%;">
							<ul id="multi-picker-Nationality-targetContainer-0">
								<li data-id="-99"></li>
								<li data-id="-99"></li>
								<li data-id="undefined">中国</li>
								<li data-id="undefined">海外</li>
								<li data-id="-99"></li>
								<li data-id="-99"></li>
							</ul>
						</div>
						<div class="multi-picker-up-shadow"></div>
						<div class="multi-picker-down-shadow"></div>
						<div class="multi-picker-line"></div>
					</div>
				</div>
			</div>
		</div>
		<!--地区选择容器-->
		<div id="area-targetContainer">
			<div class="multi-picker-bg"
				id="multi-picker-bg-area-targetContainer">
				<div class="multi-picker-container"
					id="multi-picker-container-area-targetContainer">
					<div class="multi-picker-btn-box">
						<div class="multi-picker-btn" id="multi-picker-btn-cancel">返回</div>
						<div class="multi-picker-btn"
							id="multi-picker-btn-save-area-targetContainer">确定</div>
					</div>
					<div class="multi-picker-content">
						<div class="multi-picker" style="width: 100%;">
							<ul id="multi-picker-area-targetContainer-0">
								<li data-id="-99"></li>
								<li data-id="-99"></li>
								<li data-id="undefined">北京市</li>
								<li data-id="undefined">上海市</li>
								<li data-id="undefined">天津市</li>
								<li data-id="undefined">重庆市</li>
								<li data-id="undefined">黑龙江省</li>
								<li data-id="undefined">吉林省</li>
								<li data-id="undefined">辽宁省</li>
								<li data-id="undefined">山东省</li>
								<li data-id="undefined">山西省</li>
								<li data-id="undefined">陕西省</li>
								<li data-id="undefined">河北省</li>
								<li data-id="undefined">河南省</li>
								<li data-id="undefined">湖北省</li>
								<li data-id="undefined">湖南省</li>
								<li data-id="undefined">海南省</li>
								<li data-id="undefined">江苏省</li>
								<li data-id="undefined">江西省</li>
								<li data-id="undefined">广东省</li>
								<li data-id="undefined">广西壮族自治区</li>
								<li data-id="undefined">云南省</li>
								<li data-id="undefined">贵州省</li>
								<li data-id="undefined">四川省</li>
								<li data-id="undefined">内蒙古自治区</li>
								<li data-id="undefined">宁夏回族自治区</li>
								<li data-id="undefined">甘肃省</li>
								<li data-id="undefined">青海省</li>
								<li data-id="undefined">西藏自治区</li>
								<li data-id="undefined">新疆维吾尔自治区</li>
								<li data-id="undefined">安徽省</li>
								<li data-id="undefined">浙江省</li>
								<li data-id="undefined">福建省</li>
								<li data-id="undefined">台湾省</li>
								<li data-id="undefined">香港特别行政区</li>
								<li data-id="undefined">澳门特别行政区</li>
								<li data-id="-99"></li>
								<li data-id="-99"></li>
							</ul>
						</div>
						<div class="multi-picker-up-shadow"></div>
						<div class="multi-picker-down-shadow"></div>
						<div class="multi-picker-line"></div>
					</div>
				</div>
			</div>
		</div>
		<!--地址国籍选择容器-->
		<div id="Nationality-targetContainer2">
			<div class="multi-picker-bg"
				id="multi-picker-bg-Nationality-targetContainer2">
				<div class="multi-picker-container"
					id="multi-picker-container-Nationality-targetContainer2">
					<div class="multi-picker-btn-box">
						<div class="multi-picker-btn" id="multi-picker-btn-cancel">返回</div>
						<div class="multi-picker-btn"
							id="multi-picker-btn-save-Nationality-targetContainer2">确定</div>
					</div>
					<div class="multi-picker-content">
						<div class="multi-picker" style="width: 100%;">
							<ul id="multi-picker-Nationality-targetContainer2-0">
								<li data-id="-99"></li>
								<li data-id="-99"></li>
								<li data-id="undefined">中国</li>
								<li data-id="undefined">海外</li>
								<li data-id="-99"></li>
								<li data-id="-99"></li>
							</ul>
						</div>
						<div class="multi-picker-up-shadow"></div>
						<div class="multi-picker-down-shadow"></div>
						<div class="multi-picker-line"></div>
					</div>
				</div>
			</div>
		</div>
		<!--地址地区选择容器-->
		<div id="area-targetContainer2">
			<div class="multi-picker-bg"
				id="multi-picker-bg-area-targetContainer2">
				<div class="multi-picker-container"
					id="multi-picker-container-area-targetContainer2">
					<div class="multi-picker-btn-box">
						<div class="multi-picker-btn" id="multi-picker-btn-cancel">返回</div>
						<div class="multi-picker-btn"
							id="multi-picker-btn-save-area-targetContainer2">确定</div>
					</div>
					<div class="multi-picker-content">
						<div class="multi-picker" style="width: 100%;">
							<ul id="multi-picker-area-targetContainer2-0">
								<li data-id="-99"></li>
								<li data-id="-99"></li>
								<li data-id="undefined">北京市</li>
								<li data-id="undefined">上海市</li>
								<li data-id="undefined">天津市</li>
								<li data-id="undefined">重庆市</li>
								<li data-id="undefined">黑龙江省</li>
								<li data-id="undefined">吉林省</li>
								<li data-id="undefined">辽宁省</li>
								<li data-id="undefined">山东省</li>
								<li data-id="undefined">山西省</li>
								<li data-id="undefined">陕西省</li>
								<li data-id="undefined">河北省</li>
								<li data-id="undefined">河南省</li>
								<li data-id="undefined">湖北省</li>
								<li data-id="undefined">湖南省</li>
								<li data-id="undefined">海南省</li>
								<li data-id="undefined">江苏省</li>
								<li data-id="undefined">江西省</li>
								<li data-id="undefined">广东省</li>
								<li data-id="undefined">广西壮族自治区</li>
								<li data-id="undefined">云南省</li>
								<li data-id="undefined">贵州省</li>
								<li data-id="undefined">四川省</li>
								<li data-id="undefined">内蒙古自治区</li>
								<li data-id="undefined">宁夏回族自治区</li>
								<li data-id="undefined">甘肃省</li>
								<li data-id="undefined">青海省</li>
								<li data-id="undefined">西藏自治区</li>
								<li data-id="undefined">新疆维吾尔自治区</li>
								<li data-id="undefined">安徽省</li>
								<li data-id="undefined">浙江省</li>
								<li data-id="undefined">福建省</li>
								<li data-id="undefined">台湾省</li>
								<li data-id="undefined">香港特别行政区</li>
								<li data-id="undefined">澳门特别行政区</li>
								<li data-id="-99"></li>
								<li data-id="-99"></li>
							</ul>
						</div>
						<div class="multi-picker-up-shadow"></div>
						<div class="multi-picker-down-shadow"></div>
						<div class="multi-picker-line"></div>
					</div>
				</div>
			</div>
		</div>
		<!--组别选择容器-->
		<div id="Group-targetContainer">
			<div class="multi-picker-bg"
				id="multi-picker-bg-Group-targetContainer">
				<div class="multi-picker-container"
					id="multi-picker-container-Group-targetContainer">
					<div class="multi-picker-btn-box">
						<div class="multi-picker-btn" id="multi-picker-btn-cancel">返回</div>
						<div class="multi-picker-btn"
							id="multi-picker-btn-save-Group-targetContainer">确定</div>
					</div>
					<div class="multi-picker-content">
						<div class="multi-picker" style="width: 100%;">
							<ul id="multi-picker-Group-targetContainer-0">
								<li data-id="-99"></li>
								<li data-id="-99"></li>
								<li data-id="undefined">设计组</li>
								<li data-id="undefined">表演组</li>
								<li data-id="-99"></li>
								<li data-id="-99"></li>
							</ul>
						</div>
						<div class="multi-picker-up-shadow"></div>
						<div class="multi-picker-down-shadow"></div>
						<div class="multi-picker-line"></div>
					</div>
				</div>
			</div>
		</div>
		<!--是否参加走T台选择容器-->
		<div id="attend-targetContainer">
			<div class="multi-picker-bg"
				id="multi-picker-bg-attend-targetContainer">
				<div class="multi-picker-container"
					id="multi-picker-container-attend-targetContainer">
					<div class="multi-picker-btn-box">
						<div class="multi-picker-btn" id="multi-picker-btn-cancel">返回</div>
						<div class="multi-picker-btn"
							id="multi-picker-btn-save-attend-targetContainer">确定</div>
					</div>
					<div class="multi-picker-content">
						<div class="multi-picker" style="width: 100%;">
							<ul id="multi-picker-attend-targetContainer-0">
								<li data-id="-99"></li>
								<li data-id="-99"></li>
								<li data-id="undefined">是</li>
								<li data-id="undefined">否</li>
								<li data-id="-99"></li>
								<li data-id="-99"></li>
							</ul>
						</div>
						<div class="multi-picker-up-shadow"></div>
						<div class="multi-picker-down-shadow"></div>
						<div class="multi-picker-line"></div>
					</div>
				</div>
			</div>
		</div>
		<!--赛区选择-->
		<div id="division-targetContainer">
			<div class="multi-picker-bg"
				id="multi-picker-bg-division-targetContainer">
				<div class="multi-picker-container"
					id="multi-picker-container-division-targetContainer">
					<div class="multi-picker-btn-box">
						<div class="multi-picker-btn" id="multi-picker-btn-cancel">返回</div>
						<div class="multi-picker-btn"
							id="multi-picker-btn-save-division-targetContainer">确定</div>
					</div>
					<div class="multi-picker-content">
						<div class="multi-picker" style="width: 100%;">
							<ul id="multi-picker-division-targetContainer-0">
								<li data-id="-99"></li>
								<li data-id="-99"></li>
								<li data-id="undefined">粤港澳赛区</li>
								<li data-id="undefined">东三省赛区</li>
								<li data-id="-99"></li>
								<li data-id="-99"></li>
							</ul>
						</div>
						<div class="multi-picker-up-shadow"></div>
						<div class="multi-picker-down-shadow"></div>
						<div class="multi-picker-line"></div>
					</div>
				</div>
			</div>
		</div>
		
		
		<!--走右手选择-->
		<div id="hand-targetContainer">
			<div class="multi-picker-bg"
				id="multi-picker-bg-division-targetContainer">
				<div class="multi-picker-container"
					id="multi-picker-container-division-targetContainer">
					<div class="multi-picker-btn-box">
						<div class="multi-picker-btn" id="multi-picker-btn-cancel">返回</div>
						<div class="multi-picker-btn"
							id="multi-picker-btn-save-division-targetContainer">确定</div>
					</div>
					<div class="multi-picker-content">
						<div class="multi-picker" style="width: 100%;">
							<ul id="multi-picker-division-targetContainer-0">
								<li data-id="-99"></li>
								<li data-id="-99"></li>
								<li data-id="undefined">左手</li>
								<li data-id="undefined">右手</li>
								<li data-id="-99"></li>
								<li data-id="-99"></li>
							</ul>
						</div>
						<div class="multi-picker-up-shadow"></div>
						<div class="multi-picker-down-shadow"></div>
						<div class="multi-picker-line"></div>
					</div>
				</div>
			</div>
		</div>
		
		<!--手汗选择-->
		<div id="hand-sweat-targetContainer">
			<div class="multi-picker-bg"
				id="multi-picker-bg-division-targetContainer">
				<div class="multi-picker-container"
					id="multi-picker-container-division-targetContainer">
					<div class="multi-picker-btn-box">
						<div class="multi-picker-btn" id="multi-picker-btn-cancel">返回</div>
						<div class="multi-picker-btn"
							id="multi-picker-btn-save-division-targetContainer">确定</div>
					</div>
					<div class="multi-picker-content">
						<div class="multi-picker" style="width: 100%;">
							<ul id="multi-picker-division-targetContainer-0">
								<li data-id="-99"></li>
								<li data-id="-99"></li>
								<li data-id="undefined">较多</li>
								<li data-id="undefined">适中</li>
								<li data-id="undefined">较少</li>
								<li data-id="-99"></li>
								<li data-id="-99"></li>
							</ul>
						</div>
						<div class="multi-picker-up-shadow"></div>
						<div class="multi-picker-down-shadow"></div>
						<div class="multi-picker-line"></div>
					</div>
				</div>
			</div>
		</div>


	</div>
	<script src="<%=basePath %>static-resource/javaScript/uclubdoctor/jquery-2.1.3.min.js"></script>
	<script src="<%=basePath %>static-resource/javaScript/uclubdoctor/MultiPicker.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath %>static-resource/javaScript/uclubdoctor/jquery.datetimepicker.js" type="text/javascript" charset="utf-8"></script>
	
	<script type="text/javascript">
		var baseUrl = "<%=basePath%>";
		//$('#datetimepicker').datetimepicker({format: "yyyy-MM-dd",autoclose:true,minView: 2,language:"CN"});
		jQuery('#datetimepicker').datetimepicker({
			format : "Y-m-d",//格式化时间
			timepicker : false, //关闭时间选项
			lang : 'zh',
			validateOnBlur: false
		});
		/* var ages = new Array();
		for (var i = 1; i < 100; i++) {
			ages[i-1] = {value : i};
		}
		//选择年龄
		new MultiPicker({
			input : 'age-input',//点击触发插件的input框的id
			container : 'age-targetContainer',//插件插入的容器id
			jsonData : ages,
			success : function(arr) {
				$('.age-input').attr('value',
						JSON.stringify(arr[0].value).replace(/\"/g, ""));
			}//回调
		}); */
		
		// 选择手汗 
		new MultiPicker({
			input : 'userHandSweat',//点击触发插件的input框的id
			container : 'hand-sweat-targetContainer',//插件插入的容器id
			jsonData : [ {
				value : '较多',
			}, {
				value : '适中',
			} , {
				value : '较少',
			} ],
			success : function(arr) {
				$('#userHandSweat').attr('value',
						JSON.stringify(arr[0].value).replace(/\"/g, ""));
			}//回调
		});
		
		
		// 选择左右手
		new MultiPicker({
			input : 'userHand',//点击触发插件的input框的id
			container : 'hand-targetContainer',//插件插入的容器id
			jsonData : [ {
				value : '左手',
			}, {
				value : '右手',
			} ],
			success : function(arr) {
				$('#userHand').attr('value',
						JSON.stringify(arr[0].value).replace(/\"/g, ""));
			}//回调
		});
		
		//选择性别
		new MultiPicker({
			input : 'sex-input',//点击触发插件的input框的id
			container : 'sex-targetContainer',//插件插入的容器id
			jsonData : [ {
				value : '男',
			}, {
				value : '女',
			} ],
			success : function(arr) {
				$('.sex-input').attr('value',
						JSON.stringify(arr[0].value).replace(/\"/g, ""));
			}//回调
		});
		//选择赛区
		new MultiPicker({
			input : 'division-input',//点击触发插件的input框的id
			container : 'division-targetContainer',//插件插入的容器id
			jsonData : [ {
				value : '粤港澳赛区',
			}, {
				value : '东三省赛区',
			} ],
			success : function(arr) {
				$('.division-input').attr('value',
						JSON.stringify(arr[0].value).replace(/\"/g, ""));
			}//回调
		});
		//选择国籍
		new MultiPicker({
			input : 'Nationality-input',//点击触发插件的input框的id
			container : 'Nationality-targetContainer',//插件插入的容器id
			jsonData : [ {
				value : '中国',
			}, {
				value : '海外',
			} ],
			success : function(arr) {
				var nationality = JSON.stringify(arr[0].value).replace(/\"/g,
						"");
				if (nationality == '中国') {
					$('.area-input').show();
					$('.foreign-area-input').hide();
					$('.Nationality-input').attr('value',
							JSON.stringify(arr[0].value).replace(/\"/g, ""));
				} else {
					$('.area-input').hide();
					$('.foreign-area-input').show();
					$('.Nationality-input').attr('value',
							JSON.stringify(arr[0].value).replace(/\"/g, ""));
				}

			}//回调
		});
		//选择地区
		new MultiPicker({
			input : 'area-input',//点击触发插件的input框的id
			container : 'area-targetContainer',//插件插入的容器id
			jsonData : [ {
				value : '北京市',
			}, {
				value : '上海市',
			}, {
				value : '天津市',
			}, {
				value : '重庆市',
			}, {
				value : '黑龙江省',
			}, {
				value : '吉林省',
			}, {
				value : '辽宁省',
			}, {
				value : '山东省',
			}, {
				value : '山西省',
			}, {
				value : '陕西省',
			}, {
				value : '河北省',
			}, {
				value : '河南省',
			}, {
				value : '湖北省',
			}, {
				value : '湖南省',
			}, {
				value : '海南省',
			}, {
				value : '江苏省',
			}, {
				value : '江西省',
			}, {
				value : '广东省',
			}, {
				value : '广西壮族自治区',
			}, {
				value : '云南省',
			}, {
				value : '贵州省',
			}, {
				value : '四川省',
			}, {
				value : '内蒙古自治区',
			}, {
				value : '宁夏回族自治区',
			}, {
				value : '甘肃省',
			}, {
				value : '青海省',
			}, {
				value : '西藏自治区',
			}, {
				value : '新疆维吾尔自治区',
			}, {
				value : '安徽省',
			}, {
				value : '浙江省',
			}, {
				value : '福建省',
			}, {
				value : '台湾省',
			}, {
				value : '香港特别行政区',
			}, {
				value : '澳门特别行政区',
			} ],
			success : function(arr) {
				$('.area-input').attr('value',
						JSON.stringify(arr[0].value).replace(/\"/g, ""));
			}//回调
		});
		//地址选择国籍
		new MultiPicker({
			input : 'Nationality-input2',//点击触发插件的input框的id
			container : 'Nationality-targetContainer2',//插件插入的容器id
			jsonData : [ {
				value : '中国',
			}, {
				value : '海外',
			} ],
			success : function(arr) {
				var nationality = JSON.stringify(arr[0].value).replace(/\"/g,
						"");
				if (nationality == '中国') {
					$('.area-input2').show();
					$('.foreign-area-input2').hide();
					$('.Nationality-input2').attr('value',
							JSON.stringify(arr[0].value).replace(/\"/g, ""));
				} else {
					$('.area-input2').hide();
					$('.foreign-area-input2').show();
					$('.Nationality-input2').attr('value',
							JSON.stringify(arr[0].value).replace(/\"/g, ""));
				}

			}//回调
		});
		//地址选择地区
		new MultiPicker({
			input : 'area-input2',//点击触发插件的input框的id
			container : 'area-targetContainer2',//插件插入的容器id
			jsonData : [ {
				value : '北京市',
			}, {
				value : '上海市',
			}, {
				value : '天津市',
			}, {
				value : '重庆市',
			}, {
				value : '黑龙江省',
			}, {
				value : '吉林省',
			}, {
				value : '辽宁省',
			}, {
				value : '山东省',
			}, {
				value : '山西省',
			}, {
				value : '陕西省',
			}, {
				value : '河北省',
			}, {
				value : '河南省',
			}, {
				value : '湖北省',
			}, {
				value : '湖南省',
			}, {
				value : '海南省',
			}, {
				value : '江苏省',
			}, {
				value : '江西省',
			}, {
				value : '广东省',
			}, {
				value : '广西壮族自治区',
			}, {
				value : '云南省',
			}, {
				value : '贵州省',
			}, {
				value : '四川省',
			}, {
				value : '内蒙古自治区',
			}, {
				value : '宁夏回族自治区',
			}, {
				value : '甘肃省',
			}, {
				value : '青海省',
			}, {
				value : '西藏自治区',
			}, {
				value : '新疆维吾尔自治区',
			}, {
				value : '安徽省',
			}, {
				value : '浙江省',
			}, {
				value : '福建省',
			}, {
				value : '台湾省',
			}, {
				value : '香港特别行政区',
			}, {
				value : '澳门特别行政区',
			} ],
			success : function(arr) {
				$('.area-input2').attr('value',
						JSON.stringify(arr[0].value).replace(/\"/g, ""));
			}//回调
		});
		//详细地址栏输入下拉效果
		function autoTextAreaHeight(o) {
			o.style.height = o.scrollTop + o.scrollHeight + "px";
		}
		$(function() {
			var ele = document.getElementById("symptomTxt");
			autoTextAreaHeight(ele);
		})
		//选择组别
		new MultiPicker({
			input : 'Group-input',//点击触发插件的input框的id
			container : 'Group-targetContainer',//插件插入的容器id
			jsonData : [ {
				value : '设计组',
			}, {
				value : '表演组',
			} ],
			success : function(arr) {
				$('.Group-input').attr('value',
						JSON.stringify(arr[0].value).replace(/\"/g, ""));
			}//回调
		});
		//是否参加走T台
		new MultiPicker({
			input : 'attend-input',//点击触发插件的input框的id
			container : 'attend-targetContainer',//插件插入的容器id
			jsonData : [ {
				value : '是',
			}, {
				value : '否',
			} ],
			success : function(arr) {
				$('.attend-input').attr('value',
						JSON.stringify(arr[0].value).replace(/\"/g, ""));
			}//回调
		});
		//吸顶效果
		$(window).scroll(function() {
			var scrollTop = $(window).scrollTop();
			if (scrollTop > 0) {
				$(".toper-box").stop(true, true).fadeIn();
			} else {
				$(".toper-box").stop(true, true).fadeIn();
			}
			;
		});
		
		function saveData() {
			var requestBody = {
						"realName":$("#realName").val(), "birthDate":$("#datetimepicker").val(), "userHeight":$("#userHeight").val(), "userWeight":$("#userWeight").val(),
						"userCap":$("#userCap").val(), "userHand":	$("#userHand").val(), "userGloveSize":$("#userGloveSize").val(), "userShoesSize":$("#userShoesSize").val(), 
						"userParentName":$("#userParentName").val(), "userHandSweat":$("#userHandSweat").val(), "userHandLength":$("#userHandLength").val(), 
						"frequency":$("#frequency").val(), "injury":$("#injury").val()
						};
			console.log(requestBody)
			$.ajax({
				url : baseUrl + "app/user/personal",
				data : JSON.stringify(requestBody),
				type : "POST",
				contentType : "application/json",
				dataType : "JSON",
				async : false,
				cache : false,
				success : function(data) {
					history.go(-1)
				}
			})
		}
	</script>


</body>
</html>