<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/head.css" />
		<link rel="stylesheet" type="text/css" href="css/login.css" />
	</head>
	<body style="margin: -2px">
		<iframe src="head.jsp" scrolling="no" width="100%" height="100%"></iframe>
		<section class="sec">
			<form action="UserLoginServlet" method="post">
				<div class="register-box">
					<label for="username" class="username_label">
						用 户 名
						<input maxlength="20" name="username" type="text" placeholder="您的用户名或登录名" />
					</label>
					<div class="tips"></div>
				</div>
				<div class="register-box">
					<label for="username" class="other_label">
						密 码
						<input maxlength="20" type="password" name="password" placeholder="请输入密码" />
					</label>
					<div class="tips"></div>
				</div>
				<div class="arguement">
					<input type="checkbox" id="xieyi" />
					阅读并同意
					<a href="javascript:void(0)">《你问我答用户注册协议》</a>
					<a href="register.html">没有账号,立即注册</a>
					<div class="tips"></div>
				</div>
				<div class="submit_btn">
					<button type="submit" id="submit_btn">立 即 登录</button>
				</div>
			</form>
		</section>
		<script src="js/index.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>