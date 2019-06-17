$.ajax({
	url : baseUrl + "qiniu/uptoken",
	success : function(res) {
		var token = res.uptoken;
		var domain = res.domain;
		var config = {
			useCdnDomain : true,
			disableStatisticsReport : false,
			retryCount : 6
		};
		var putExtra = {
			fname : "",
			params : {},
			mimeType : null
		};
		uploadWithSDK(token, putExtra, config, domain);
	}
})

function uploadWithSDK(token, putExtra, config, domain) {
	$("input[type='file']").unbind("change").bind("change", function() {
		var file = this.files[0];
		// eslint-disable-next-line
		var finishedAttr = [];
		// eslint-disable-next-line
		var compareChunks = [];
		var observable;
		if (file) {
			var key = file.name;
			console.log(key)
			var error = function(err) {
				console.log(err);
				alert("上传出错")
			};

			var complete = function(res) {
				alert(res.key)
			};
			var next = function(response) {
				var chunks = response.chunks || [];
				var total = response.total;
				console.log("next-->" + response.total)
			};

			var subObject = {
				next : next,
				error : error,
				complete : complete
			};
			var subscription;
			// 调用sdk上传接口获得相应的observable，控制上传和暂停
			observable = qiniu.upload(file, null, token, putExtra, config);
			subscription = observable.subscribe(subObject)
		}
	})
}
