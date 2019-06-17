function dialog(msg) {
	jQuery("#alertToast").html(msg);
	jQuery(".alertWrap").fadeIn();
	setTimeout(function() {
		jQuery(".alertWrap").fadeOut(500);
	}, 1000);
}

// 加载时弹出框效果
jQuery.ajaxSetup({
	timeout : 60000,
	error : function(xhr, textStatus, error) {
		console.log(xhr.status);
		console.log(textStatus);
		console.log(error);
		var err_code = xhr.status;
		switch (err_code) {
		case 404:
			dialog('对不起，系统未找到您访问的地址');
			break;
		case 500:
			dialog('出错啦，刷新页面再试试看');
			break;
		case 405:
			dialog('错误的请求方式.');
			setTimeout(function() {
				window.location.href = baseUrl;
			}, 500)
			break;
		case 403:
			dialog('操作权限不足.');
			setTimeout(function() {
				window.location.href = baseUrl;
			}, 500)
			break;
		case 999:
			dialog('会话失效，请重新登录');
			setTimeout(function() {
				window.location.href = baseUrl;
			}, 500)
			break;
		default:
			dialog(xhr.responseText);
			break;
		}
	},
	contentType : "application/x-www-form-urlencoded; charset=UTF-8",
	beforeSend : function() {
		// if (!(document.cookie || navigator.cookieEnabled)) {
		// dialog('您的浏览器关闭了cookie功能, 这样可能会影响您在本站的体验.');
		// }
		jQuery(".loading").fadeIn();// 发起请求前显示加载中...
	},
	complete : function() {
		jQuery(".loading").fadeOut();// 请求完毕后将加载效果移除
	},
	// crossDomain: true,
	cache : false,
	headers : {
		'isAjax' : "1"
	}
});

jQuery(document).on("mouseover",".refer",function(){
	 if(jQuery(this).find(".refer_bubble span").text()==""){
		 jQuery(this).find(".refer_bubble em").hide()
	 }else{
		 jQuery(this).find(".refer_bubble em").show()
	 }
	   jQuery(this).find(".refer_bubble").stop(true,true).fadeIn(); 	   
})  	   
jQuery(document).on("mouseout",".refer",function(){
  jQuery(this).find(".refer_bubble").stop(true,true).fadeOut();      
})

var audio = null;
function textToVoice(per, text) {
	jQuery.ajax({
		url : baseUrl + "qiniu/textToVoice",
		type : "POST",
		data : "text=" + text + "&per=" + 0,
		beforeSend : function() {
		},
		complete : function() {
		},
		success : function(e) {
			if (e.code != 0) {
				return;
			}
			if (audio != null)
				audio.pause();
			var dingdong = new Audio();
			dingdong.src = baseUrl + "music/voice.mp3";

			audio = new Audio();
			console.log(picUrl + e.msg);
			audio.src = picUrl + e.msg;
			dingdong.play();
			setTimeout("audio.play();", 1000);
			console.log("语音播放结束");
		}
	});
}

function coumon_noficy(msg){
	var options = {
			lang : "UTF-8",
			icon : "http://7xss26.com1.z0.glb.clouddn.com/system/image/go.png",
			body : msg
	}
	if(Notification && Notification.permission === "granted"){
		 var noficy = new Notification("中邦我道提醒您 : ", options); 
		 noficy.onshow = function (){
			 console.log();
		 }
		 noficy.onclick = function() {
//			 window.location.href = baseUrl + "administrator/query/system/update";
         };
	}
	else if (Notification && Notification.permission != "denied"){
		Notification.requestPermission(function(status){
			if(Notification.permission !== status){
                Notification.permission = status;
            }
		})
	}
	else {
		console.log("客户端禁止通知提醒!");
	}
}
window.addEventListener("load", function (){
	if (Notification && Notification.permission != "granted"){
		 Notification.requestPermission(function(status){
			 if(Notification.permission !== status){
	                Notification.permission = status;
			 }
		 })
	}
});


function printTable(str) {
	var orderhtml = "";
	if (document.getElementById(str)) {
		orderhtml = document.getElementById(str).outerHTML;
	} else
		orderhtml = str;
	/* 创建iframe */
	var headobj = document.getElementsByTagName("head").item(0); // 提取head
	printFrame = document.getElementById("lldxi_printRegionFrame_2012_0112");
	if (printFrame) {
		document.body.removeChild(printFrame);
	}
	printFrame = document.createElement("iframe");
	printFrame.setAttribute("src", "about:blank");
	printFrame.setAttribute("id", "lldxi_printRegionFrame_2012_0112");
	printFrame.setAttribute("marginheight", "0");
	printFrame.setAttribute("marginwidth", "0");
	printFrame.style.display = "none";
	document.body.appendChild(printFrame);
	if (window.ActiveXObject)// ie
	{
		var htmlobj = printFrame.contentWindow.document.createElement("html");
		var bodyobj = printFrame.contentWindow.document.createElement("body");
		bodyobj.innerHTML = orderhtml;
		htmlobj.appendChild(headobj.cloneNode(true));
		htmlobj.appendChild(bodyobj);
		printFrame.contentWindow.document.appendChild(htmlobj);
		printFrame.contentWindow.document.execCommand("Print", true);
	} else {
		var htmlstr = "<html>"
				+ headobj.outerHTML
				+ "<body>"
				+ orderhtml
				+ "<script type=\"text/javascript\">window.print();<\/script><\/body>"
				+ "<\/html>";
		printFrame.contentWindow.document.write(htmlstr);
	}
}
var extNotIe = (function() {
	var uri = 'data:application/vnd.ms-excel;base64,', template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]-->  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head><body><table>{table}</table></body></html>', base64 = function(
			s) {
		return window.btoa(unescape(encodeURIComponent(s)))
	}, format = function(s, c) {
		return s.replace(/{(\w+)}/g, function(m, p) {
			return c[p];
		})
	}
	return function(table, name) {
		if (!table.nodeType)
		var	$html = document.getElementById(table)
		var $tables = jQuery($html).clone(true);
		$tables.find("img").remove();
		$tables.find("style").remove();
		var ctx = {
			worksheet : 'Worksheet' || 'Worksheet',
			table : jQuery($tables).html()
		};
		var elementA = jQuery("<a id='jsFileDownLoadByName' href=" + uri
				+ base64(format(template, ctx)) + " download='" + name
				+ ".xls'>下载</a>");
		jQuery($html).eq(0).after(elementA);
		document.getElementById("jsFileDownLoadByName").click();
		elementA.remove();
	}
})()

function exportTable(tableId, name) {
	if (!!window.ActiveXObject || "ActiveXObject" in window) {
		alert('请使用其他浏览器进行导出!');
	} else {
		extNotIe(tableId, name + "　" + getNowDate());
	}
}

Date.prototype.pattern = function(fmt) {
	var o = {
		"M+" : this.getMonth() + 1, // 月份
		"d+" : this.getDate(), // 日
		"h+" : this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, // 小时
		"H+" : this.getHours(), // 小时
		"m+" : this.getMinutes(), // 分
		"s+" : this.getSeconds(), // 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
		"S" : this.getMilliseconds()
	// 毫秒
	};
	var week = {
		"0" : "/u65e5",
		"1" : "/u4e00",
		"2" : "/u4e8c",
		"3" : "/u4e09",
		"4" : "/u56db",
		"5" : "/u4e94",
		"6" : "/u516d"
	};
	if (/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}
	if (/(E+)/.test(fmt)) {
		fmt = fmt
				.replace(
						RegExp.$1,
						((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f"
								: "/u5468")
								: "")
								+ week[this.getDay() + ""]);
	}
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
}
/* console.log(new Date().pattern("yyyy-MM-dd HH:mm:ss SS")); */
/**
 * checkBok 全选、全不选
 */
function checkAllAndFalse(input, name) {
	var fatherCheck = jQuery(input).is(':checked');
	var childrenCheck = jQuery("input[name='" + name + "']");
	if (fatherCheck == true) {
		jQuery(childrenCheck).prop("checked", true);
	} else {
		jQuery(childrenCheck).prop("checked", false);
	}
}

/** 数组检验是否存在摸一个值 */
Array.prototype.contains = function(item) {
	return RegExp("\\b" + item + "\\b").test(this);
};

String.prototype.startWith = function(str) {
	var reg = new RegExp("^" + str);
	return reg.test(this);
}

String.prototype.endWith = function(str) {
	var reg = new RegExp(str + "$");
	return reg.test(this);
}

/** 强制保留2位小数，如：2，会在2后面补上00.即2.00 */
function toDecimal2(x) {
	var f = parseFloat(x); // 将字符串转换为浮点型
	var f = Math.round(x * 100) / 100;
	var s = f.toString();
	var rs = s.indexOf('.');
	if (rs < 0) {
		rs = s.length;
		s += '.';
	}
	while (s.length <= rs + 2) {
		s += '0';
	}
	return s;
}

/** 获取当前的日期时间 格式“yyyy-MM-dd HH:MM:SS” */
function getNowFormatDate() {
	var date = new Date();
	var seperator1 = "-";
	var seperator2 = ":";
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	var hours = date.getHours();
	var minutes = date.getMinutes();
	var seconds = date.getSeconds();
	if (month >= 1 && month <= 9) {
		month = "0" + month;
	}
	if (strDate >= 0 && strDate <= 9) {
		strDate = "0" + strDate;
	}
	if (hours >= 0 && hours <= 9) {
		hours = "0" + hours;
	}
	if (minutes >= 0 && minutes <= 9) {
		minutes = "0" + minutes;
	}
	if (seconds >= 0 && seconds <= 9) {
		seconds = "0" + seconds;
	}
	var currentdate = date.getFullYear() + seperator1 + month + seperator1
			+ strDate + " " + hours + seperator2 + minutes
			+ seperator2 + seconds;
	return currentdate;
}

/** 获取当前的日期时间 格式“yyyy-MM-dd” */
function getNowDate() {
	var date = new Date();
	var seperator1 = "-";
	var seperator2 = ":";
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	if (month >= 1 && month <= 9) {
		month = "0" + month;
	}
	if (strDate >= 0 && strDate <= 9) {
		strDate = "0" + strDate;
	}
	var currentdate = year + seperator1 + month + seperator1 + strDate;

	return currentdate;
}

/** 判断数组中是否含有该项(基本类型和对象都满足) */
Array.prototype.contains = function(obj) {
	var i = this.length;
	while (i--) {
		if (this[i] === obj) {
			return true;
		}
	}
	return false;
}

/** 数组删除坐标为i的元素 */
Array.prototype.remove = function(dx) {
	if (isNaN(dx) || dx > this.length) {
		return false;
	}
	for (var i = 0, n = 0; i < this.length; i++) {
		if (this[i] != this[dx]) {
			this[n++] = this[i];
		}
	}
	this.length -= 1;
}

/** 手牌刷卡 */
var objVal = "";
function changeElectronNum(s) {
	var input = jQuery(s).val();
	if (!isEmpty(objVal)) {
		input = input.replace(objVal, "");
	}
	objVal = input;
	jQuery(s).val(input);
}

function method(tableid) {// 整个表格拷贝到EXCEL中
	// 检索浏览器
	if (navigator.userAgent.indexOf("MSIE") < 0) {
		alert('请用ie浏览器进行表格导出');
		return;
	}

	var curTbl = document.getElementById(tableid);
	var oXL = null;
	try {
		oXL = GetObject("", "Excel.Application");
	} catch (E) {
		try {
			oXL = new ActiveXObject("Excel.Application");
		} catch (E2) {
			alert("请确认:\n1.Microsoft Excel已被安装.\n2.工具 => Internet 选项=> 安全 => 设置 \"启用不安全的 ActiveX\"");
			return;
		}
	}

	// 创建AX对象excel
	var oWB = oXL.Workbooks.Add();
	// 获取workbook对象
	var oSheet = oWB.ActiveSheet;

	// 在此进行样式控制
	oSheet.Rows(1 + ":" + 35).RowHeight = 25;// 定义行高
	oSheet.Rows(36 + ":" + 37).RowHeight = 15;
	// 定义列宽
	oSheet.Columns('A:K').ColumnWidth = 10;

	oSheet.Rows(1).HorizontalAlignment = 3;

	var sel = document.body.createTextRange(); // 激活当前sheet
	sel.moveToElementText(curTbl); // 把表格中的内容移到TextRange中
	sel.select(); // 全选TextRange中内容
	sel.execCommand("Copy"); // 复制TextRange中内容
	oSheet.Paste(); // 粘贴到活动的EXCEL中
	oXL.Visible = true; // 设置excel可见属性
	oXL.document.execcommand('saveas', true, "test");
	oSheet.Application.Quit(); // 结束当前进程

	window.opener = null;
	// window.close();//关闭当前窗口

}

/** 获取某个URL参数 */
function getParam(paramName) {
	paramValue = "";
	isFound = false;
	if (this.location.search.indexOf("?") == 0
			&& this.location.search.indexOf("=") > 1) {
		arrSource = unescape(this.location.search).substring(1,
				this.location.search.length).split("&");
		i = 0;
		while (i < arrSource.length && !isFound) {
			if (arrSource[i].indexOf("=") > 0) {
				if (arrSource[i].split("=")[0].toLowerCase() == paramName
						.toLowerCase()) {
					paramValue = arrSource[i].split("=")[1];
					isFound = true;
				}
			}
			i++;
		}
	}
	return paramValue;
}

/**
 *  时间格式匹配
 * @param fmtCode  格式
 * @param date  时间
 * @returns {String}
 */
function formatTime(fmtCode, date) {
	var result, d, arr_d;
	var patrn_now_1 = /^y{4}-M{2}-d{2}\sh{2}:m{2}:s{2}$/;
	var patrn_now_11 = /^y{4}-M{1,2}-d{1,2}\sh{1,2}:m{1,2}:s{1,2}$/;

	var patrn_now_2 = /^y{4}\/M{2}\/d{2}\sh{2}:m{2}:s{2}$/;
	var patrn_now_22 = /^y{4}\/M{1,2}\/d{1,2}\sh{1,2}:m{1,2}:s{1,2}$/;

	var patrn_now_3 = /^y{4}年M{2}月d{2}日\sh{2}时m{2}分s{2}秒$/;
	var patrn_now_33 = /^y{4}年M{1,2}月d{1,2}日\sh{1,2}时m{1,2}分s{1,2}秒$/;

	var patrn_date_1 = /^y{4}-M{2}-d{2}$/;
	var patrn_date_11 = /^y{4}-M{1,2}-d{1,2}$/;

	var patrn_date_2 = /^y{4}\/M{2}\/d{2}$/;
	var patrn_date_22 = /^y{4}\/M{1,2}\/d{1,2}$/;

	var patrn_date_3 = /^y{4}年M{2}月d{2}日$/;
	var patrn_date_33 = /^y{4}年M{1,2}月d{1,2}日$/;

	var patrn_time_1 = /^h{2}:m{2}:s{2}$/;
	var patrn_time_11 = /^h{1,2}:m{1,2}:s{1,2}$/;
	var patrn_time_2 = /^h{2}时m{2}分s{2}秒$/;
	var patrn_time_22 = /^h{1,2}时m{1,2}分s{1,2}秒$/;

	if (!fmtCode) {
		fmtCode = "yyyy/MM/dd hh:mm:ss";
	}
	if (date) {
		d = new Date(date);
		if (isNaN(d)) {
			msgBox("时间参数非法\n正确的时间示例:\nThu Nov 9 20:30:37 UTC+0800 2006\n或\n2006/      10/17");
			return;
		}
	} else {
		d = new Date();
	}

	if (patrn_now_1.test(fmtCode)) {
		arr_d = splitDate(d, true);
		result = arr_d.yyyy + "-" + arr_d.MM + "-" + arr_d.dd + " "
				+ arr_d.hh + ":" + arr_d.mm + ":" + arr_d.ss;
	} else if (patrn_now_11.test(fmtCode)) {
		arr_d = splitDate(d);
		result = arr_d.yyyy + "-" + arr_d.MM + "-" + arr_d.dd + " "
				+ arr_d.hh + ":" + arr_d.mm + ":" + arr_d.ss;
	} else if (patrn_now_2.test(fmtCode)) {
		arr_d = splitDate(d, true);
		result = arr_d.yyyy + "/" + arr_d.MM + "/" + arr_d.dd + " "
				+ arr_d.hh + ":" + arr_d.mm + ":" + arr_d.ss;
	} else if (patrn_now_22.test(fmtCode)) {
		arr_d = splitDate(d);
		result = arr_d.yyyy + "/" + arr_d.MM + "/" + arr_d.dd + " "
				+ arr_d.hh + ":" + arr_d.mm + ":" + arr_d.ss;
	} else if (patrn_now_3.test(fmtCode)) {
		arr_d = splitDate(d, true);
		result = arr_d.yyyy + "年" + arr_d.MM + "月" + arr_d.dd + "日" + " "
				+ arr_d.hh + "时" + arr_d.mm + "分" + arr_d.ss + "秒";
	} else if (patrn_now_33.test(fmtCode)) {
		arr_d = splitDate(d);
		result = arr_d.yyyy + "年" + arr_d.MM + "月" + arr_d.dd + "日" + " "
				+ arr_d.hh + "时" + arr_d.mm + "分" + arr_d.ss + "秒";
	}

	else if (patrn_date_1.test(fmtCode)) {
		arr_d = splitDate(d, true);
		result = arr_d.yyyy + "-" + arr_d.MM + "-" + arr_d.dd;
	} else if (patrn_date_11.test(fmtCode)) {
		arr_d = splitDate(d);
		result = arr_d.yyyy + "-" + arr_d.MM + "-" + arr_d.dd;
	} else if (patrn_date_2.test(fmtCode)) {
		arr_d = splitDate(d, true);
		result = arr_d.yyyy + "/" + arr_d.MM + "/" + arr_d.dd;
	} else if (patrn_date_22.test(fmtCode)) {
		arr_d = splitDate(d);
		result = arr_d.yyyy + "/" + arr_d.MM + "/" + arr_d.dd;
	} else if (patrn_date_3.test(fmtCode)) {
		arr_d = splitDate(d, true);
		result = arr_d.yyyy + "年" + arr_d.MM + "月" + arr_d.dd + "日";
	} else if (patrn_date_33.test(fmtCode)) {
		arr_d = splitDate(d);
		result = arr_d.yyyy + "年" + arr_d.MM + "月" + arr_d.dd + "日";
	} else if (patrn_time_1.test(fmtCode)) {
		arr_d = splitDate(d, true);
		result = arr_d.hh + ":" + arr_d.mm + ":" + arr_d.ss;
	} else if (patrn_time_11.test(fmtCode)) {
		arr_d = splitDate(d);
		result = arr_d.hh + ":" + arr_d.mm + ":" + arr_d.ss;
	} else if (patrn_time_2.test(fmtCode)) {
		arr_d = splitDate(d, true);
		result = arr_d.hh + "时" + arr_d.mm + "分" + arr_d.ss + "秒";
	} else if (patrn_time_22.test(fmtCode)) {
		arr_d = splitDate(d);
		result = arr_d.hh + "时" + arr_d.mm + "分" + arr_d.ss + "秒";
	} else {
		msgBox("没有匹配的时间格式!");
		return;
	}

	return result;
};

/**
 * 时间分割返回
 */
function splitDate(d, isZero) {
	var yyyy, MM, dd, hh, mm, ss;
	if (isZero) {
		yyyy = d.getFullYear();
		MM = (d.getMonth() + 1) < 10 ? "0" + (d.getMonth() + 1) : d
				.getMonth() + 1;
		dd = d.getDate() < 10 ? "0" + d.getDate() : d.getDate();
		hh = d.getHours() < 10 ? "0" + d.getHours() : d.getHours();
		mm = d.getMinutes() < 10 ? "0" + d.getMinutes() : d.getMinutes();
		ss = d.getSeconds() < 10 ? "0" + d.getSeconds() : d.getSeconds();
	} else {
		yyyy = d.getYear();
		MM = d.getMonth() + 1;
		dd = d.getDate();
		hh = d.getHours();
		mm = d.getMinutes();
		ss = d.getSeconds();
	}
	return {
		"yyyy" : yyyy,
		"MM" : MM,
		"dd" : dd,
		"hh" : hh,
		"mm" : mm,
		"ss" : ss
	};
}

/**
 * 获取当前网络时间
 * @param format  时间格式 (年月日时分秒 或者 时分秒)
 */
function getNowDate(format){
		var time ;
		jQuery.ajax({
			type:"OPTIONS",
			url:"/",
			async : false,
			success : function(data, status, xhr){
				time =  formatTime(format,xhr.getResponseHeader("Date"));
			}
		})
		return time ;
}

/** 系统升级 */
window.addEventListener("message", function (event) {
    if (event.source != window)
        return;
    if (event.data.from == 'cs') {
        switch (event.data.msg) {
            case 'clearCacheOK':
                alert('系统升级完成, 请重新登录');
                window.location.href = baseUrl;
                break;
            default:
        }
    }
});
/*window.postMessage({ from: 'page', msg: 'clearCache'}, '*');*/