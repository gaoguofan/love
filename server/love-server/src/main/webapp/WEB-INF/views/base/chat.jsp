<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String chatPath = request.getContextPath();
	String chatPasePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + chatPath + "/";
%>
<script type="text/javascript">
var ip = '${session_chat_ip}';
var userId = '${session_key_user_id}';
var storeId = '${session_key_store_id}';
var storeName = '${session_key_store_name}';
var userType = 'emp';
var user = {"userId" : userId, "storeId" : storeId, "storeName" : storeName, "userType" : userType};
var socket = null;
if(!isEmpty(userId)){
	socket = io.connect('ws://'+ip+':443');
    	//登录聊天室
    socket.emit('initUser', user);
	//接收消息
    socket.on('message', function(data) {
    	/* console.log("message : " + JSON.stringify(data)); */
    	var fid = data.fid;
    	//PC通知类处理
    	if (fid == 2) {
    		var type = data.data.type;
    		var playType = data.data.playType;
    		//新预约或者服务交接
    		if (type == 2) {
    			if (playType == 1 && data.data.appointmentStatus == 1) {
    				//播放语音
        			textToVoice(1, data.data.msg);
    			}
    			// 是否是预约页面
    			if (location.href.indexOf('appoint/view/list') != -1) {
    				appointmentUpdate(data.data.appointmentId, data.data.appointmentStatus, data.data.operateTime);	
    			}
    		}
    		// 修改房台状态
    		else if (type == 12){
    			changeStareRoom(data.data);
    		}
    		else if (type == 4) {
    			if (playType == 1) {
    				//播放语音
        			textToVoice(1, data.data.msg);
    			}
    			var noticeToPayType = data.data.noticeToPayType;
    			if (noticeToPayType == 0) {
    				addOverOrder(data.data.handOrderCode, data.data.orderDto);
    			}
    			else {
    				try 
    				{ 
    					addWaitOverOrder(data.data.orderDto);
    				} 
    				catch (e){} 
    				try 
    				{ 
    					deleteOverOrder(data.data.handOrderCode);
    				} 
    				catch (e) {}
    			}
    		}
    		else if (type == 5) {
    			addNewOrder(data.data.orderId, data.data.handOrderCode, data.data.orderDto)
    		}
    		else if (type == 6){
    			changeStateTypeAddree(data.data);
    		}
    		// 更改轮牌，门店下所有用户更新轮牌顺序
    		else if (type == 7){
    			storeShiftExchangeNotify(data.data)
    		}
    		// 上传处理数据进度条
    		else if (type == 8){
    			increment(data.data.progress);
    		}
    		else if (type == 101){
    			coumon_noficy(data.data.msg);
    		}
    	}
    });
	
	/**刷新指定页面*/
	function load(url){
		if (window.location.pathname == url){
			location.reload(true); 
		}
	}
	
	// 聊天
    socket.on('getMsg', function(data) {
    	var fromUser = data.fromUser;
    	var toUser = data.toUser;
    	data = eval('('+data+')');
    	var msg = data['msg'];
    	console.log(data);
    	console.log(msg);
    	var html = '<li class="media clearfix">'+
				    	'<div class="media-left">'+
				    	'<a href="javascript:void(0);" class="media-object">'+
				    		'<img src="'+baseUrl+'images/dd-img.png" alt="">'+
				        '</a>'+
					    '</div>'+
					    '<div class="media-body">'+
					        '<p class="media-text media-arr">'+msg+'</p>'+
					    '</div>'+
					'</li>';
    	jQuery("ul[ul_id='"+kfId+"']").append(jQuery(html));
    	jQuery("ul[ul_id='"+kfId+"']").animate({scrollTop:jQuery("ul[ul_id='"+kfId+"']").height()}, 800);
    	
   	});
    // 取出离线消息
    socket.emit('getNotOnlineMsg', userId, 'emp');
}

</script>
