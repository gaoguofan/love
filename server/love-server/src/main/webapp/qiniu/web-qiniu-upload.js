var uploader = Qiniu
		.uploader({
			runtimes : 'html5,flash,html4', // 上传模式,依次退化
			browse_button : 'pickfiles', // 上传选择的点选按钮，**必需**
			uptoken : token,
			unique_names : true, // 默认
									// false，key为文件名。若开启该选项，SDK为自动生成上传成功后的key（文件名）。
			domain : 'http://file.sumernetwork.com/', // bucket
														// 域名，下载资源时用到，**必需**
			get_new_uptoken : false, // 设置上传文件的时候是否每次都重新获取新的token
			container : 'container', // 上传区域DOM ID，默认是browser_button的父元素，
			max_file_size : '100mb', // 最大文件体积限制
			flash_swf_url : basePath + "qiniu/Moxie.swf", // 引入flash,相对路径
			max_retries : 3, // 上传失败最大重试次数
			dragdrop : true, // 开启可拖曳上传
			drop_element : 'container', // 拖曳上传区域元素的ID，拖曳文件或文件夹后可触发上传
			chunk_size : '4mb', // 分块上传时，每片的体积
			auto_start : true, // 选择文件后自动上传，若关闭需要自己绑定事件触发上传
			mimeType : [ "vedio/mp4" ],
			init : {
				'FilesAdded' : function(up, files) {
					$("#dialog2").fadeIn();
					$("#dialog").fadeIn();
					plupload.each(files, function(file) {
					});
				},
				'BeforeUpload' : function(up, file) {
				},
				'UploadProgress' : function(up, file) {
					$("#progressbar2").css("width", file.percent + "%");
				},
				'FileUploaded' : function(up, file, info) {
					var domain = up.getOption('domain');
					var res = JSON.parse(info);
					var sourceLink = domain + res.key;
				},
				'Error' : function(up, err, errTip) {
					console.log(errTip)
					// 上传出错时,处理相关的事情
				},
				'UploadComplete' : function() {
				}
			}
		});