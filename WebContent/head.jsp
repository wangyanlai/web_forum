<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
			<div class="dvlogo"><a href="${pageContext.request.contextPath }/GetDataAction_getData" target="_parent">论 坛</a></div>
			<div class="dvsearch">提出你的问题，找到你的同学！！</div>
			<div class="nav-user">
				<s:if test="#session.user != null">
					<a class="avatar" href="">
						<img src="${pageContext.request.contextPath }<s:property value="#session.user.image"/>" />
						<cite><s:property value="#session.user.username"/></cite>
					</a>
					<div class="nav">
						<a href="${pageContext.request.contextPath }/UserAction_logout" target="_parent">
							<i class="iconfont icon-tuichu" style="font-size: 22px;"></i>退出
						</a>
					</div>
				</s:if>  
				<s:else>     
	                <a class="iconfont icon-touxiang layui-hide-xs" style="margin-top: 4px; display: inline-block;"></a>
	                <div class="nav"  style="font-size:14px;color: white;margin-top: -5px;margin-left: 1px;" >
		                <a href="${pageContext.request.contextPath }/login.jsp"  target="_parent" >登录</a>
		                <a href="${pageContext.request.contextPath }/register.jsp" target="_parent" >注册</a>
		            </div>
	            </s:else>  
			</div>
		</div>
	</body>
</html>