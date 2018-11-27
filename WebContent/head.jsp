<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<link rel="stylesheet" href="res/css/global.css">
		<link rel="stylesheet" type="text/css" href="css/index.css">
		<script src="res/layui/layui.js"></script>
		<style></style>
	</head>
	<body>
		<div class="dvhead">
			<div class="dvlogo"><a href="index.html">你问我答</a></div>
			<div class="dvsearch">10秒钟注册账号，找到你的同学</div>
			<div class="nav-user">
				<!--
                  	描述：登录后的样子 
				<a class="avatar" href="">
					<img src="res/images/avatar/11.jpg" />
					<cite>贤心</cite>
				</a>
				<div class="nav">
					<a href=""><i class="iconfont icon-tuichu" style="font-size: 22px;"></i>退出</a>
				</div> -->
				<!--
                 	描述：未登录的样子     -->          
                <a class="iconfont icon-touxiang layui-hide-xs" style="margin-top: 4px; display: inline-block;"></a>
                <div class="nav"  style="font-size:14px;color: white;margin-top: -5px;margin-left: 1px;" >
	                <a href="${pageContext.request.contextPath }/login.jsp"  target="_parent" >登录</a>
	                <a href="${pageContext.request.contextPath }/register.jsp" target="_parent" >注册</a>
	            </div>  
			</div>
		</div>
	</body>
</html>