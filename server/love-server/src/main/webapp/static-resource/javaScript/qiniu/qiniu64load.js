var qiniu = new QiniuJsSDK();
qiniu.uploader({
    runtimes: 'html5,flash,html4',    //上传模式,依次退化
    browse_button: 'pickfiles',       //上传选择的点选按钮，**必需**
    uptoken_url: baseUrl+'qiniu/uptoken',            //Ajax请求upToken的Url，**强烈建议设置**（服务端提供）
    domain: qiniuUrl,   //bucket 域名，下载资源时用到，**必需**
    container: 'container',           //上传区域DOM ID，默认是browser_button的父元素，
    filters : {mime_types : [{title : "Image files", extensions : "jpg,jpeg,png,bmp"}],max_file_size: '10m'},
    flash_swf_url: baseUrl+'static-resource/javaScript/qiniu/Moxie.swf', //引入flash,相对路径
	max_retries : 3, //上传失败最大重试次数
	dragdrop : true, //开启可拖曳上传
	drop_element : 'container', //拖曳上传区域元素的ID，拖曳文件或文件夹后可触发上传
	chunk_size : '2mb', //分块上传时，每片的体积
	auto_start : true, //选择文件后自动上传，若关闭需要自己绑定事件触发上传,
	init : {
		'FilesAdded' : function(up, files) {
			console.log("FilesAdded invoked ...");
			var err = false;
			plupload.each(files, function(file) {
				if(!qiniu.isImage(file.name)){
					err = true;
					return false;
				}
			});
			if(err) {
				dialog("只能上传图片文件");
				up.removeFile(files[0]);
				up.stop();
				jQuery('#mask').remove();
			}
		},
		'BeforeUpload' : function(up, file) {
			console.log("BeforeUpload invoked ...");
		},
		'UploadProgress' : function(up, file) {
			console.log("UploadProgress invoked ...");
		},
		'FileUploaded' : function(up, file, info) {
			var domain = up.getOption('domain');
			var res = eval('(' + info + ')');
			var sourceLink = domain + res.key;
			container_image_path(domain, res.key);
		},
		'Error' : function(up, err, errTip) {
			console.log("UploadComplete Error ..." + err);
		},
		'UploadComplete' : function() {
			
		},
		'Key' : function(up, file) {
			console.log("Key invoked ...");
			var key = "bkn/project/info/" + new Date().getTime();
			return key;
		}
	}
});
