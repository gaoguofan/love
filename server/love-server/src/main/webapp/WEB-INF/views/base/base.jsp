<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	String qiniuPath = "http://qiniu.jobwisdom.cn/";
%>

<script type="text/javascript">
	var baseUrl = "<%=basePath%>";
	var qiniuUrl = "<%=qiniuPath%>";
</script>
<style>
.province, .city, .area {
	width: 100px;
	border-radius: 12px;
	height: 20px;
	border: none;
	margin-left: 4px;
	text-align: center
}
;
</style>
<link rel="stylesheet"
	href="<%=basePath%>static-resource/css/browser/chosen.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=basePath%>static-resource/css/browser/style.css"
	type="text/css" />

<%-- <script type="text/javascript" src="<%=basePath %>static-resource/javaScript/jQuery/jquery-3.1.1.min.js"></script> --%>
<script type="text/javascript"
	src="<%=basePath %>static-resource/javaScript/jQuery/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="<%=basePath %>static-resource/javaScript/jQuery/jquery-ui-1.9.2.min.js"></script>
<script type="text/javascript"
	src="<%=basePath %>static-resource/javaScript/base/base64Helper.js"></script>
<script type="text/javascript"
	src="<%=basePath %>static-resource/javaScript/base/baseUtil.js"></script>
<script type="text/javascript"
	src="<%=basePath %>static-resource/javaScript/base/browser.js"></script>
<script type="text/javascript"
	src="<%=basePath %>static-resource/javaScript/mobile/base.js"></script>
<script type="text/javascript"
	src="<%=basePath %>static-resource/javaScript/mobile/md5.js"></script>
<script type="text/javascript"
	src="<%=basePath %>static-resource/javaScript/cxSelect/jquery.cxselect.min.js"></script>
<script type="text/javascript"
	src="<%=basePath %>static-resource/javaScript/qiniu/plupload.full.min.js"></script>
<script type="text/javascript"
	src="<%=basePath %>static-resource/javaScript/qiniu/qiniu.min.js"></script>
<script type="text/javascript"
	src="<%=basePath %>static-resource/javaScript/browser/jquery.twbsPagination.js"></script>
<%-- <script type="text/javascript" src="<%=basePath %>static-resource/javaScript/mobile/chosen.jquery.min.js"></script> --%>
<%-- <script type="text/javascript" src="<%=basePath %>static-resource/javaScript/mobile/init.js"></script> --%>

<link href="<%=basePath %>static-resource/images/favicon.ico"
	type="image/x-icon" rel="shortcut icon" />
<script>
	jQuery(function(){
		jQuery('#element_id').cxSelect({
			  url: '../../static-resource/javaScript/cxSelect/cityData.min.js',               // 如果服务器不支持 .json 类型文件，请将文件改为 .js 文件 三级目录
			  
			  selects: ['province', 'city', 'area'],  // 数组，请注意顺序
			  emptyStyle: 'none'
		});
	})
</script>