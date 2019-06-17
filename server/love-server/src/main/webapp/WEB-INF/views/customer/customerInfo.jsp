<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../base/base.jsp"%>
<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="<%=basePath%>static-resource/css/browser/customerInfo.css?time=20161209"
	type="text/css" />
<script type="text/javascript"
	src="<%=basePath%>static-resource/javaScript/My97DatePicker/WdatePicker.js?time=20161207"></script>
<style>
.province2 {
	width: 100px;
	border-radius: 12px;
	height: 20px;
	border: none;
	margin-left: 4px;
	text-align: center
}

.zzc_2_new_content input[type='number'] {
    width: 100px;
    border-radius: 12px;
    height: 20px;
    margin-left: 4px;
    text-align: center;
</style>
<body>
	<div class="content">
		<%@include file="../base/top.jsp"%>
		<!-- 弹出框 -->
		<div class="zzc">
			<div class="zzc_password_manage">
				<p>账号管理</p>
				<div class="zzc_password_manage_content">
					<p>
						<span>添加</span>
					</p>
					<div class="password_manage">
						<p>
							<span>账号<input type="text"></span> <span>密码<input
								type="text"></span> <em><i>-</i></em>
						</p>
						<p>
							<span>账号<input type="text"></span> <span>密码<input
								type="text"></span> <em><i>-</i></em>
						</p>
						<p>
							<span>账号<input type="text"></span> <span>密码<input
								type="text"></span> <em><i>-</i></em>
						</p>
					</div>
				</div>

				<div class="base_set_button">
					<button>确定</button>
					<button>取消</button>
				</div>
			</div>
		</div>
		<!-- 新增客户 -->
		<div class="zzc_1">
			<div class="zzc_1_new" style="height: 95%">
				<div class="customer_manage_content" style="height: 92%;">
				<div class="customer_manage_content_table" id="tobal">
					<table>
						<thead>
							<tr>
								<td>选择球具</td>
								<td>球具产品</td>
								<td>挥重SW</td>
								<td>球杆重量</td>
								<td>尺寸长度</td>
								<td>新增一条</td>
							</tr>
						</thead>
						<tbody>
								<tr id="1">
									<td><select><option>你好</option></select></td>
									<td>165</td>
									<td>男</td>
									<td>1991-1-1</td>
									<td></td>
									<td><span class="deleted">删除</span></td>
								</tr>
							
						</tbody>
					</table>
				</div>
			</div>

				<div class="base_set_button">
					<button>确定</button>
					<button onclick="$('.zzc_1').hide()">取消</button>
				</div>
			</div>
		</div>		
		<!-- 新增客户 -->
		<div class="zzc_2">
			<div class="zzc_2_new">
				<p>组合订单下单任务</p>
				<div class="zzc_2_new_content">
					<p>
						<span><em>客户姓名</em><input readonly="readonly" type="text"></span> <span><em>手机号码</em><input type="text" maxlength="11" readonly="readonly"></span>
					</p>
					<p>
						<span><em>下单门店</em>&nbsp;<select id="storeId" class="province2"><c:forEach items="${storeInfos }" var="storeInfo"><option value="${storeInfo.id }">${storeInfo.storeName }</option></c:forEach></select></span>
					</p>
					<div id="element_id">
						<p>
							<span><em>收货地址</em> <select class="province"></select> <select class="city"></select> <select class="area"></select> </span>
						</p>
					</div>
					<p>
						<span><em>详细地址</em>
						<textarea id="address" style="height: 30px;" placeholder="输入地址详情如：XXX街道00号"></textarea></span>
					</p>
					<p>
						<span><em>选择订单图</em>&nbsp;<img src="<%=basePath %>static-resource/images/wsc.png" width="100" height="100" value=""></span>
					</p>
					<p>
						<span><em>订单详情</em>
						<textarea id="orderText" placeholder="输入订单商品详情如：Apple 苹果 iPhone8 Plus 4G手机 深空灰 移动联通版....."></textarea></span>
					</p>
					<!-- <p>
						<span><em>开户行</em><input type="text" style="width: 330px;"></span>
					</p>
					<p>
						<span><em>状态</em><input type="radio" value="0"
							name="status">启用<input type="radio" value="2"
							name="status" checked="checked">未启用<input type="radio"
							value="3" name="status">占位</span>
					</p> -->
					<p>
						<span><em>订单金额</em><input type="number"></span>
					</p>
				</div>

				<div class="base_set_button">
					<button id="nice" onclick="saveUcdOrderInfo();">确定</button>
					<button onclick="$('.zzc_2').hide();">取消</button>
				</div>
			</div>
		</div>
		<!-- 内容 -->
		<div class="customer_manage">
			<div class="customer_manage_content">
				<p>
					<!-- <span class="add_btn"><em>新增</em></span>  --><span class="goods">精准查询<input type="text" placeholder="输入手机号查询" style="width: 140px;"></span>
					<%-- <span class="goods">客户类别<select><option value="-1">全部</option>
							<option value="0">忠诚客户</option>
							<option value="1">黄金客户</option>
							<option value="2">白金客户</option>
							<option value="3">钻石客户</option>
							<option value="4">介绍人</option></select></span> 
					<span class="goods">一级推荐人<select
						class="chosen-select"><option value="-1">全部</option>
							<c:forEach items="${allCustomer }" var="customer">
								<option value="${customer.customerId }">${customer.customerName }</option>
							</c:forEach></select></span> <span class="goods">二级推荐人<select class="chosen-select"><option
								value="-1">全部</option>
							<c:forEach items="${allCustomer }" var="customer">
								<option value="${customer.customerId }">${customer.customerName }</option>
							</c:forEach></select></span> <span class="goods">时间<input type="text"
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"><em
						style="margin-left: 5px">至</em><input type="text"
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd '})"></span> <span
						class="goods">地区<input type="text" placeholder="省/市/地区 名称"></span> --%>
					<span class="goods_imformation_search">查询</span>
				</p>
				<!-- <table><tbody></tbody></table> -->
				<div class="customer_manage_content_table">
					<table>
						<thead>
							<tr>
								<td>微信昵称</td>
								<td>号码</td>
								<td>SEX</td>
								<td>实名</td>
								<td>生日</td>
								<td>身高</td>
								<td>体重</td>
								<td>差点</td>
								<td>左右手</td>
								<td>手套尺码</td>
								<td>鞋子尺码</td>
								<td>信息操作</td>
								<td>组合订单</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.results }" var="customer">
								<tr id="${customer.id }">
									<td>${customer.userName }</td>
									<td>${customer.phone }</td>
									<td>${customer.sex }</td>
									<td>${customer.bknNewMemberDesc.realName}</td>
									<td>${customer.bknNewMemberDesc.birthDate}</td>
									<td>${customer.bknNewMemberDesc.userHeight}</td>
									<td>${customer.bknNewMemberDesc.userWeight}</td>
									<td>${customer.bknNewMemberDesc.userCap}</td>
									<td>${customer.bknNewMemberDesc.userHand}</td>
									<td>${customer.bknNewMemberDesc.userGloveSize}</td>
									<td>${customer.bknNewMemberDesc.userShoesSize}</td>
									<td><span class="xianqing">查看</span>&nbsp;<span class="enable">初始化</span></td>
									<td><span class="catchUp">下单</span></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<%@include file="../base/page.jsp"%>
	</div>
	<%@include file="../base/cropit.jsp"%>
</body>
<script>

	var bknProductCategories = $.parseJSON('${bknProductCategories}');

	jQuery(function(){
		
		jQuery('.zzc_2 img:first').click(function(){
			var size1=jQuery("#clipArea .photo-clip-view").size()+1;
			var size2=jQuery("#clipArea .photo-clip-view").size()+1;
			
			if(size1>1){
				jQuery("#clipArea .photo-clip-view,#clipArea .photo-clip-mask").remove()
			}
			photoClipInit(200,200, this);
			
		});
		
		jQuery('.add_btn>em').click(function(){
			jQuery('.zzc_1').show().find(':text,textarea').val('');
			jQuery('.zzc_1 select:first').prop('selectedIndex', 0).change();
			jQuery('.zzc_1 select:first>option').show();
			jQuery('.select-search li[class]').removeAttr('class');
			jQuery('.zzc_1_new_content :text[readonly]').removeAttr('readonly');
			jQuery('.zzc_1_new').height(550).find('.zzc_1_new_content>p:eq(6)').show().find(':radio:eq(1)').prop('checked', true);
			jQuery('.zzc_1 .chosen-select>option[status=1]').hide();		// 隐藏停用客户
			jQuery('.zzc_1 .chosen-select').prop('selectIndex', 0).trigger('chosen:updated');
			
		});
		jQuery('.base_set_button:last>button:first').click(function(){
			if ($(this).attr("id") == 'nice') return;
			var property = ['customerName', 'customerPhone', 'category', 'companyName', 'joinTime', 'recommenderOne', 'totalAmount', 'receiveAmount', 'bankCardNumber', 'openBank', 'detailAddress'];
			var requestData = {};
			var districts = [];
			jQuery('.zzc_1_new_content :text:not(.chosen-search-input), .zzc_1_new_content select:not(.province,.city,.area),.zzc_1_new_content textarea').each(function(i, e){
				requestData[property[i]] = e.value;
			});
			var customerId = jQuery('.zzc_1').data('customerId');
			var category = jQuery('.customer_manage_content_table tr[customerId=' + customerId + ']').attr('category');
			var condition = "";
			if (requestData.category < 4 && isEmpty(requestData.receiveAmount)) {
				requestData.receiveAmount = 0.00;
			}
			if ((isEmpty(requestData.totalAmount) || isNaN(requestData.totalAmount) || requestData.totalAmount <= 0) 
					&& (isEmpty(customerId) || category > 3) 
					&& (requestData.category < 4)) {
				alert("请输入正确的总加盟费！");
				return;
			}
			if (!isEmpty(customerId)) {
				requestData['customerId'] = customerId;
				condition = '[customerId!=' + customerId + ']';
				if (isEmpty(requestData.recommenderOne)) {
					// 设置为无推荐人
					requestData.recommenderOne = -999;
				} else if(customerId == requestData.recommenderOne) {
					alert('推荐人不能为自己！');
					return;
				}
				if (category < 4) {
					delete requestData['totalAmount'];
					delete requestData['receiveAmount'];
				} else if (requestData.category < 4 && parseFloat(requestData.receiveAmount) > requestData.totalAmount) {
					alert('错误,已收加盟费，已经超过总加盟费！');
					return ;
				}
			} 
			// 为新增客户
			else {
				// 设置状态
				requestData['status'] = jQuery('.zzc_1_new_content :radio:checked').val();
				if (parseFloat(requestData.receiveAmount) > requestData.totalAmount) {
					alert('错误,已收加盟费，已经超过总加盟费！');
					return ;
				}
			}
			
			if (!isEmpty(requestData.customerCode)) {
				var $element = jQuery('.customer_manage_content_table tr' + condition + '>td:nth-child(1)[customerCode=' + requestData.customerCode + ']');
				if ($element.length > 0) {
					alert('已存在该客户编号！');
					return;
				}
			}
			
			var size = jQuery('#element_id select:visible').size();
			// 获取地区
			jQuery('#element_id select:not(:empty):visible').each(function(i, e){
				if (!isEmpty(e.value)) {
					districts.push(e.value);
				}
			})
			
			requestData['district'] = districts.join('-');
			if (requestData.category < 4 && districts.length != size) { alert('还有区域未选择！'); return; }
			if (districts.length == 1 && districts[0] == '直辖区') { alert('直辖区不能作为忠诚客户！'); return; }
			saveCustomerInfo(requestData);
		})
		
		jQuery('.base_set_button:last>button:last').click(function(){
			jQuery('.zzc_1').hide().removeData('customerId');
		})
		
		// 查询
		jQuery('.goods_imformation_search').click(function(){
			isFalsh = true;
			pageNo = 1;
			var property = ['phone'];
			var requestData = {};
			jQuery('.goods>input,.goods>select').each(function(i, e){
				if (!isEmpty(e.value) && e.value != -1) {
					requestData[property[i]] = e.value; 
				}
			});
			pageNo = 1;
			window.page.params = requestData;
			changePage();
			
		});
		
		$(".xianqing").click(function () {
			var $even = jQuery(this).parents('tr');
			var userId = $even.attr('id');
			jQuery.ajax({
				url : baseUrl + "customer/query/goods?userId=" + userId,
				type : "GET",
				success : function(data) {
					var html = '<table>'+
									'<thead>'+
										'<tr>'+
											'<td>球具大类</td>'+
											'<td>球具产品</td>'+
											'<td>挥重SW</td>'+
											'<td>球杆重量</td>'+
											'<td>尺寸长度</td>'+
										'</tr>'+
									'</thead>'+
									'<tbody>';
					for (var i = 0; i < data.msg.length; i++) {
						html += '<tr id="1">'+
									'<td>'+data.msg[i].categoryName+'</td>'+
									'<td>'+data.msg[i].bollName+'</td>'+
									'<td>'+data.msg[i].bollSw+'</td>'+
									'<td>'+data.msg[i].bollCw+'</td>'+
									'<td>'+data.msg[i].bollLength+'</td>'+
								'</tr>';
					}
					html += '</tbody></table>';
					$("#tobal").empty();
					$("#tobal").append(html);
					$(".base_set_button").eq(2).find("button").eq(0).click(function () {
						$(".zzc_1").hide();
					})
					$(".zzc_1").show();
				}
			})
		})
		
		$(".enable").click(function () {
			var $even = jQuery(this).parents('tr');
			var userId = $even.attr('id');
			if (confirm('你确定要初始化改信息?')) {
				var html = '<table userId='+userId+'>'+
								'<thead>'+
									'<tr>'+
										'<td>球具大类</td>'+
										'<td>球具产品</td>'+
										'<td>挥重SW</td>'+
										'<td>球杆重量</td>'+
										'<td>尺寸长度</td>'+
										'<td>新增</td>'+
									'</tr>'+
								'</thead>'+
								'<tbody>';
				html += '</tbody></table>';
				$("#tobal").empty();
				$("#tobal").append(html);
				clickQr();
				$(".base_set_button").eq(2).find("button").eq(0).click(function () {
					saveCustomerInfo(userId);
				})
				$(".zzc_1").show();
			};
		})
		
		
		// 操作
		jQuery(document).on("click", ".customer_manage_content_table tr>td:last-child>span", function(){
			var $even = jQuery(this).parents('tr');
			var userId = $even.attr('id');
			switch(this.getAttribute('class')) {
				case 'deleted':
					if (confirm('你确定删除该客户,那么该客户的所有流水信息都将会被删除！')) {
						var requestData = {
								'customerId' : customerId,
								'isDeleted' : 1
							};
							saveCustomerInfo(requestData);
					}
					break;
				// 补交
				case 'catchUp':
					$(".zzc_2").attr("userId", $(this).parents("tr").attr("id"));
					$(".zzc_2").find("input").eq(0).val($(this).parents("tr").children("td").eq(0).text());
					$(".zzc_2").find("input").eq(1).val($(this).parents("tr").children("td").eq(1).text());
					$(this).parent("tr").children("td").eq(1);
					$(".zzc_2").show();
					/* var deductibleAmount = $even.attr('deductibleAmount');
					if (isEmpty(deductibleAmount) || deductibleAmount <= 0) {alert('该客户无加盟款补交！');return;}
					if (confirm('你确定将该补交该客户的加盟款抵扣！')) {
						var requestData = {'customerId':customerId,'deductibleAmount':deductibleAmount};
						saveCustomerInfo(requestData);
					} */
					break;
				// 初始化密码
				case 'initPwd':
					if (confirm('你确定要初始化该客户的密码！')) {
						var requestData = {'customerId':customerId,'passWord':'123456'};
						saveCustomerInfo(requestData);
					}
					break;
			}	
		})
		
		jQuery('.zzc_1 select:first').change(function(){
			if (this.value < 4) {
				jQuery('#element_id em').text(this.value > 2 ? '所属区域 ' : '管辖区域');
				jQuery('.city,.area').remove();
				switch(this.value) {
					case '1':
						jQuery('#element_id>p>span').append(jQuery('#element_id').data('city'));
						break;
					case '2':
					case '3':
						jQuery('#element_id>p>span').append(jQuery('#element_id').data('city') + jQuery('#element_id').data('area'));
						break;
				}
				jQuery('#element_id').cxSelect({
					  url: '../../static-resource/javaScript/cxSelect/cityData.min.js',               // 如果服务器不支持 .json 类型文件，请将文件改为 .js 文件
					  selects: ['province', 'city', 'area'],  // 数组，请注意顺序
				});
				jQuery('.zzc_1_new_content p:gt(1) :text:gt(0),.zzc_1_new_content textarea,.zzc_1_new_content p:gt(1) select').removeProp('disabled');
			} else {
				jQuery('.zzc_1_new_content p:gt(1) select').prop({'selectedIndex':0, 'disabled':'disabled'});
				jQuery('.zzc_1_new_content p:gt(1) :text:gt(0):lt(3),.zzc_1_new_content textarea').prop('disabled', 'disabled').val('');
			}
		});
		
		loadRecommenderName();
		// 城市选择框
		jQuery('#element_id').data({'city':'<select class="city" ><option value="">请选择</option></select>','area':'<select class="area" ><option value="">请选择</option></select>'});
		jQuery('.zzc_1 .chosen-select>option[status=1]').hide();
	})
	
	function saveCustomerInfo(userId){
		var tbody = $("#tobal").find("tbody");
		var userId = $("#tobal").find("table").attr("userid");
		var requestBody = {"userId":userId};
		var requestList = new Array();
		for (var i = 0; i < tbody.children("tr").length; i++) {
			requestList.push({"userId":userId, "goodsId":tbody.children("tr").eq(i).find("select").eq(1).val()})
		}
		requestBody["requestlist"] = requestList;
		console.log(requestBody)
		jQuery.ajax({
			url : baseUrl + "action/customer/addOrUpdate",
			data : JSON.stringify(requestBody),
			type : "POST",
			contentType : "application/json",
			dataType : "JSON",
			async : false,
			cache : false,
			success : function(data) {
				if (data.code == 0) {
					location.reload();
				} else {
					alert(data.msg);				
				}
			}
		})
	}
	
	//function loadRecommenderName(){jQuery('.customer_manage_content_table tr:gt(0)>td:nth-child(6):not(:empty),.customer_manage_content_table tr:gt(0)>td:nth-child(7):not(:empty)').each(function(i, e){e.innerText = jQuery('.customer_manage_content select:last>option[value=' + e.innerText.trim() + ']').text();});}
	function isNull(str){return isEmpty(str) || str == 'null' ? '' : str;}
	function toFixed(value){return isEmpty(value) ? "" : value.toFixed(2);}
</script>
<script type="text/javascript">
	//分页信息
	var pageNo = '${page.pageNo}';	
	var pageSize = '${page.pageSize}';
	var totalPage = '${page.totalPage}';
	var totalRecord = '${page.totalRecord}';
	window.page = {'pageNo':pageNo,'pageSize':pageSize,'params':{}}
	
	function changePage(){
		window.page.pageNo = pageNo;
		jQuery.ajax({
			url : baseUrl + "customer/view/customerInfo",
			data : JSON.stringify(window.page),
			type : "POST",
			contentType : "application/json",
			dataType : "JSON",
			async : false,
			cache : false,
			success : function(data) {
				if (data.code == 0) {
					var html = '';
					jQuery.each(data.msg.results, function(i, customer){
						 html += '<tr id='+customer.id+'>' +
								    '<td>' + customer.userName + '</td>' +
								    '<td>' + customer.phone + '</td>' +
									'<td>' + customer.sex + '</td>';
									if (customer.bknNewMemberDesc != null) {
										html += 
											'<td>' + customer.bknNewMemberDesc.realName +'</td>' +
											'<td>' + customer.bknNewMemberDesc.birthDate +'</td>' +
											'<td>' + customer.bknNewMemberDesc.userHeight +'</td>' +
											'<td>' + customer.bknNewMemberDesc.userWeight +'</td>' +
											'<td>' + customer.bknNewMemberDesc.userCap +'</td>' +
											'<td>' + customer.bknNewMemberDesc.userHand +'</td>' +
											'<td>' + customer.bknNewMemberDesc.userGloveSize +'</td>' +
											'<td>' + customer.bknNewMemberDesc.userShoesSize +'</td>' +
											'<td><span class="xianqing">查看</span><span class="enable">初始化</span></td>'+
										 '</tr>';
									} else {
										html += 
											'<td>暂无</td>' +
											'<td>暂无</td>' +
											'<td>暂无</td>' +
											'<td>暂无</td>' +
											'<td>暂无</td>' +
											'<td>暂无</td>' +
											'<td>暂无</td>' +
											'<td>暂无</td>' +
											'<td><span class="xianqing">查看</span><span class="enable">初始化</span></td>'+
										 '</tr>';
									}
					});
					jQuery('.customer_manage_content_table tbody').empty().append(html);
					//jQuery('.customer_manage_content_table td:contains(null)').text('');
					//loadRecommenderName();
					delete data.msg.results;
					window.page = data.msg;
					
					pageNo = data.msg.pageNo;
					pageSize = data.msg.pageSize;
					totalPage = data.msg.totalPage;
					totalRecord=data.msg.totalRecord;
				} else {
					alert(data.msg);
					totalRecord = totalPage = 0;
				}
				if (isFalsh) unbuildPagination();
			}
		})
	}
	
	
	function clickQr(id){
		var tbody = $("#tobal").find("tbody");
		tbody.empty();
		var categoryOptions = '';
		for (var i = 0; i < bknProductCategories.length; i++) {
			categoryOptions += '<option value="'+bknProductCategories[i].categoryId+'">' + bknProductCategories[i].categoryName + '</option>';
		}
		var bollOptions = '';
		for (var i = 0; i < bknProductCategories[0].bknNewBollDescs.length; i++) {
			bollOptions += '<option value="'+bknProductCategories[0].bknNewBollDescs[i].id+'">' + bknProductCategories[0].bknNewBollDescs[i].bollName + '</option>';
		}
		var html = '<tr>'+
						'<td><select style="width:100px" onchange="changeTboy(this)">'+categoryOptions+'</select></td>'+
						'<td><select onchange="showDesc(this)" class="chosen-select">'+bollOptions+'</select></td>'+ 
						'<td>'+bknProductCategories[0].bknNewBollDescs[0].bollSw+'</td>'+ 
						'<td>'+bknProductCategories[0].bknNewBollDescs[0].bollCw+'</td>'+ 
						'<td>'+bknProductCategories[0].bknNewBollDescs[0].bollLength+'</td>'+ 
						'<td><span onclick="addItem()" class="">+</span></td>'+ 
					'</tr>';
		tbody.append(html);
		$(".chosen-select").chosen();
		$(".zzc_1").show();
	}
	
	function showDesc(select) {
		var categoryId = $(select).parents("tr").find("select").eq(0).val();
		for (var i = 0; i < bknProductCategories.length; i++) {
			if (bknProductCategories[i].categoryId == categoryId) {
				for (var j = 0; j < bknProductCategories[i].bknNewBollDescs.length; j++) {
					if (bknProductCategories[i].bknNewBollDescs[j].id == $(select).val()) {
						$(select).parents("tr").find("td").eq(2).text(bknProductCategories[i].bknNewBollDescs[j].bollSw);
						$(select).parents("tr").find("td").eq(3).text(bknProductCategories[i].bknNewBollDescs[j].bollCw);
						$(select).parents("tr").find("td").eq(4).text(bknProductCategories[i].bknNewBollDescs[j].bollLength);
					}
				}
			}
		}
	}
	
	function changeTboy(select) {
		var id = $(select).val();
		$(select).parents("tr").find(".chosen-select").empty();
		var bollOptions = '';
		for (var i = 0; i < bknProductCategories.length; i++) {
			if (bknProductCategories[i].categoryId == id) {
				for (var j = 0; j < bknProductCategories[i].bknNewBollDescs.length; j++) {
					bollOptions += '<option value="'+bknProductCategories[i].bknNewBollDescs[j].id+'">' + bknProductCategories[i].bknNewBollDescs[j].bollName + '</option>';
				}
			}
		}
		$(select).parents("tr").find(".chosen-select").append(bollOptions);
		$(select).parents("tr").find(".chosen-select").trigger("chosen:updated");
	}
	
	function addItem() {
		var tbody = $("#tobal").find("tbody");
		var categoryOptions = '';
		for (var i = 0; i < bknProductCategories.length; i++) {
			categoryOptions += '<option value="'+bknProductCategories[i].categoryId+'">' + bknProductCategories[i].categoryName + '</option>';
		}
		var bollOptions = '';
		for (var i = 0; i < bknProductCategories[0].bknNewBollDescs.length; i++) {
			bollOptions += '<option value="'+bknProductCategories[0].bknNewBollDescs[i].id+'">' + bknProductCategories[0].bknNewBollDescs[i].bollName + '</option>';
		}
		var html = '<tr>'+
						'<td><select style="width:100px" onchange="changeTboy(this)">'+categoryOptions+'</select></td>'+
						'<td><select onchange="showDesc(this)" class="chosen-select">'+bollOptions+'</select></td>'+ 
						'<td>'+bknProductCategories[0].bknNewBollDescs[0].bollSw+'</td>'+ 
						'<td>'+bknProductCategories[0].bknNewBollDescs[0].bollCw+'</td>'+ 
						'<td>'+bknProductCategories[0].bknNewBollDescs[0].bollLength+'</td>'+ 
						'<td><span onclick="addItem()" class="">+</span></td>'+ 
					'</tr>';
		tbody.append(html);
		$(".chosen-select").chosen();
	}
	
	function zccCallback(dataBase64, obj){
		var key = "bkn/project/" + new Date().getTime();
	    var data = {"stringBase64":dataBase64,"key":key};
	    jQuery('.cancelinput').click();
	    jQuery.ajax({
			type : "POST",
			url : baseUrl + "qiniu/base64",
		       data: JSON.stringify(data),
		       contentType: "application/json",
		       dataType: "json",
		       async:true,  
		       beforeSend:function(){
		       	console.log("beforeSend upload image");
		       },
		       error:function (){
		       	console.log("upload image error");
		       },
		       complete :function (){
		       	console.log("complete upload image");
		       },
		       success: function(data) {
			       	var imageUrl = data.msg.imageUrl;
			       	var key = data.msg.key;
			       	console.log(imageUrl + ' -- ' + key);
			       	jQuery('.zzc_2 img:first').attr({'src' : imageUrl, 'value' : key});
			       	jQuery('.mask-crop').hide();
		       }
	 	});
	}
	
	function saveUcdOrderInfo() {
		var userId = $('.zzc_2').attr("userId");
		var storeId = $("#storeId").val();
		var address = $(".province").val() + $(".city").val() + $(".area").val() + $("#address").val();
		var orderImage = $(".zzc_2").find("img").attr("src");
		var orderText = $("#orderText").val();
		var orderMoney = $(".zzc_2 input[type='number']").val();
		var orderInfo = {"userId":userId, "storeId":storeId, "orderAddress":address, "orderText":orderText, "orderImage":orderImage, "orderMoney":orderMoney*100};
		jQuery.ajax({
			type : "POST",
			url : baseUrl + "action/customer/order",
		       data: JSON.stringify(orderInfo),
		       contentType: "application/json",
		       dataType: "json",
		       async:true,  
		       success: function(data) {
		    		alert(data.msg);
		    		history.go(0)
		       }
	 	});
		console.log(orderInfo);
	}
</script>
<script type="text/javascript" src="<%=basePath %>static-resource/javaScript/mobile/chosen.jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>static-resource/javaScript/mobile/init.js"></script>
</html>