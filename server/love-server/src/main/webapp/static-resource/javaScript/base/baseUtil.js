	
	// 今天的日期
	var nowDate=new Date();
	/*
	 * 判断字符是否为空
	 */
	function isEmptyOrSpace(str) {
		return str == null 
			|| jQuery.trim(str) == "" 
			|| str.length == 0;
	}
	
	/*
	 * 时间比较
	 */
	function timeCompare(beginTime,entTime) {
		if (!isEmptyOrSpace(beginTime) && beginTime != entTime) {
			var b_time = new Date(beginTime.replace("-","/").replace("-","/"));
			var e_time = new Date(entTime.replace("-","/").replace("-","/"));
			if (e_time < b_time) {
				return false;	
			}
		}
		return true;
	}
	
	/*
	 * 获取今天的日期
	 * (尾部多一个空格)
	 */
	function getCurData() {
		return timeFormat(nowDate);
	}
	
	/*
	 * 获得当前月
	 */
	function getCurMonty() {
		var month = nowDate.getMonth();
		return nowDate.getFullYear() + "-" + (month + 1　< 10 ? "0" +(month+1) : month + 1);
	}
	
	/*
	 * 时间格式转换 
	 * (尾部多一个空格)
	 */
	function timeFormat(time) {
		var nowYear = time.getFullYear() ; //年
		var nowMonth = time.getMonth() + 1 < 10 ? "0" +(time.getMonth()+1) : time.getMonth() + 1; //月
		var nowDay = time.getDate() < 10 ? "0" + time.getDate() : time.getDate(); //日期
		var nowDate = nowYear + "-" + nowMonth + "-" + nowDay + " " ;
		return nowDate;
	}
	
	/*
	 * 字符串填充
	 */
	function strFill(str) {
		var r_str = "";
		if (isEmptyOrSpace(str) || str == 0) {
			r_str="0.00";
		} else {
			r_str = str + ""
			var index = r_str.indexOf(".");
			if (index == -1) {
				r_str = str + ".00";
			} else {
				var strEnd = r_str.substring(index + 1);
				r_str = strEnd.length == 1 ? str + "0" : r_str;
			}
		}
		return r_str;
	}
	
	/**
	 * 百分比
	 * @param 除数
	 * @param 被除数
	 * @param 结果为零的时候需要显示的字符 （默认为0.00）
	 * @returns string
	 */
	function percentage(divisor, theDividend, showStr) {
		return isEmptyOrSpace(divisor) 
					|| isEmptyOrSpace(theDividend) 
					|| divisor == 0 
					|| theDividend == 0 
					? isEmptyOrSpace(showStr)  ? '00.00' : showStr 
					: ((divisor / theDividend) * 100).toFixed(2);
	}
	
	//隐藏元素
	function hide(className){
		jQuery("." + className).hide();
	}
	
	//显示元素
	function show(className){
		jQuery("." + className).show();
	}
	
	/**
	 * 表格汇总
	 * @param 汇总表格的样式名称
	 * @param 汇总展示位置上一级的样式名称
	 */
	function tableSummary(tClassName, sClassName) {
		var $trs = jQuery("." + tClassName + " tr");
		var length = $trs.eq(0).find("td").length;
		var tr_values = new Array(length);
		$trs.each(function(i, e){
			var $td = jQuery(e).find("td");
			for (var index = 0; index < length; index++) {
				tr_values[index] = (isNaN(tr_values[index]) 
						? 0 
						: parseFloat(tr_values[index])) + (isNaN($td.eq(index).text()) 
								? 0 
								:　parseFloat($td.eq(index).text()));
			}
		});
		var html = "<tr>"
		jQuery.each (tr_values, function(i, value){
			html += "<td>" + strFill(value.toFixed(2)) + "</td>";
		});
		html += "</tr>";
		jQuery("." + sClassName).empty().append(html);
	}
	 