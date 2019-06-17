<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<script>
	function dialog(text) {
		$(".refer").text(text);
		zepto('.refer').fadeIn(function() {
			setTimeout(function() {
				zepto('.refer').fadeOut();
			}, 1000)
		});
	}
</script>
<style>
html {
	width: 100%;
	overflow-x: hidden
}

body {
	font-family: '微软雅黑', 'san-serif';
	background: #fafafa
}

.refer {
	width: 5rem;
	background: rgba(0, 0, 0, 0.7);
	z-index: 10;
	position: fixed;
	left: 50%;
	font-size: 0.6rem;
	color: white;
	border-radius: 0.4rem;
	height: 1.8rem;
	line-height: 1.8rem;
	text-align: center;
	margin-left: -2.5rem;
	bottom: 5rem;
	display: none
}
</style>
</head>
<div class="refer">请重新输入</div>