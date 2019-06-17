<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<link rel="stylesheet"
	href="<%=basePath %>static-resource/css/browser/common.css"
	type="text/css" />
<style>
#clipArea {
	height: 300px;
	position: relative;
	width: 500px;
	float: left
}

.htmleaf-container p>img {
	position: absolute;
	top: -8px;
	right: -5px;
	cursor: pointer;
}

#view {
	margin: 0 auto;
	width: 200px;
	height: 200px;
}

.mask-crop {
	position: fixed;
	top: 0px;
	height: 1090px;
	left: 0px;
	width: 100%;
	z-index: 10000;
	background: rgba(102, 108, 121, 0.8);
}

.htmleaf-container {
	width: 500px;
	height: 400px;
	position: relative;
	margin: 50px auto;
	text-align: center
}

.mask-crop button {
	background: #e1e1e1;
	cursor: pointer;
	border-radius: 5px;
	width: 100px;
	height: 30px;
	text-align: center;
	line-height: 30px;
	border: none
}

.input-image {
	line-height: 30px;
	background: #e1e1e1;
	display: inline-block;
	cursor: pointer;
	position: relative;
	display: inline-block;
	border-radius: 5px;
	width: 100px;
	height: 30px;
	margin-right: 40px
}

.input-image input {
	border-radius: 5px;
	width: 100px;
	height: 30px;
	text-align: center;
	line-height: 30px;
	opacity: 0;
	position: absolute;
	z-index: 2;
	cursor: pointer;
	left: 0;
	font-size: 0
}

.htmleaf-container>p {
	background: rgb(74, 184, 255);
	color: white;
	text-align: left;
	padding-left: 15px;
	height: 30px;
	line-height: 30px;
	border-radius: 4px 4px 0 0
}

.mask-crop-right {
	float: left;
	background: white;
	width: 250px;
	height: 300px;
	position: relative;
}

.save-file {
	height: 50px;
	line-height: 50px;
	background: #efefef;
	border-radius: 0 0 5px 5px;
	position: relative;
}
</style>

</head>
<body>


	<div class="mask-crop" style="display: none;">
		<article class="htmleaf-container">
			<p>
				裁剪图片 <img onclick="jQuery('.mask-crop').hide();"
					src="http://qiniu.jobwisdom.cn/system/images/close1.png">
			</p>
			<div class="clearfix">
				<div id="clipArea"></div>
				<!-- <div class="mask-crop-right">
		  <p>预览</p>
			<div id="view"></div>
		</div> -->
			</div>
			<div class="save-file">
				<div class="input-image">
					<input type="file" id="file"> <span>选择图片</span>
				</div>

				<button id="clipBtn">保存</button>
			</div>
		</article>

	</div>




	<script type="text/javascript"
		src="<%=basePath %>static-resource/javaScript/photoClip/iscroll-zoom.js"></script>
	<script type="text/javascript"
		src="<%=basePath %>static-resource/javaScript/photoClip/hammer.js"></script>
	<script type="text/javascript"
		src="<%=basePath %>static-resource/javaScript/photoClip/jquery.photoClip.js"></script>
	<script>
	//document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);

	function photoClipInit(width, height, imgObject){
		var size1=jQuery("#clipArea .photo-clip-view").size()+1;
		if(size1>1){
			jQuery("#clipArea .photo-clip-view,#clipArea .photo-clip-mask").remove()
		}
		jQuery('.mask-crop').show();
		var type = 1;
		jQuery("#clipArea").photoClip({
			width: width,
			height: height,
			file: "#file",
			view: "#view",
			ok: "#clipBtn",
			loadStart: function() {
				console.log("照片读取中");
			},
			loadComplete: function() {
				console.log("照片读取完成sss");
			},
			clipFinish: function(dataURL) {
				if(type ==1){
					
				zccCallback(dataURL,imgObject);
				type =2;
				}
				
			}
		});
	}
	
	
	
	function zccCallback(dataBase64, imgObject) {
		var key = "bkn/project/" + new Date().getTime();
		var data = {
			"stringBase64" : dataBase64,
			"key" : key
		};
		jQuery.ajax({
				type : "POST",
				url : baseUrl + "qiniu/base64",
				data : JSON.stringify(data),
				contentType : "application/json",
				dataType : "json",
				async : true,
				beforeSend : function() {
					console.log("beforeSend upload image");
				},
				error : function() {
					console.log("upload image error");
				},
				complete : function() {
					console.log("complete upload image");
				},
				success : function(data) {
					var imageUrl = data.msg.imageUrl;
					var key = data.msg.key;
					jQuery('.mask-crop').hide();
					jQuery(imgObject).attr("src", qiniuUrl + key);
						
// 					} else {
// 						u1.execCommand(
// 										'insertHtml',
// 										'<img style="margin-top: 0px; width: 100%; padding: 0px; border-color: rgb(30, 155, 232); color: inherit; height: 100%;" data-width="100%" border="0" vspace="0" src="'
// 												+ qiniuUrl + key + '">');
// 					}
				}
			});
	}
	</script>
</body>
</html>