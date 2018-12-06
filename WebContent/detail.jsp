
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>问题详情</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="keywords" content="fly,layui,前端社区">
		<meta name="description" content="">
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<link rel="stylesheet" href="res/css/global.css">
		<script src="res/layui/layui.js"></script>
		<script src="js/jquery.js"></script>
		<style type="text/css" rel="stylesheet">
			form {
				margin: 0;
			}			
			.editor {
				margin-top: 5px;
				margin-bottom: 5px;
			}
		</style>
	</head>
	<body style="margin: -2px">
		<iframe src="head.jsp" scrolling="no" width="100%" height="100%"></iframe>
		<div class="main layui-clear">
			<div class="wrap">
				<div class="content detail">
					<div class="fly-panel detail-box">	
						<h1><s:property value="#paste.title"/></h1>
						<div class="fly-tip fly-detail-hint" data-id="">
							<span class="fly-tip-stick">置顶帖</span>
							<span class="jie-admin">
								<a href="">点击置顶</a>
							</span>
							<span class="layui-btn layui-btn-mini jie-admin">
								<a href="">取消置顶</a>
							</span>
							<span class="jie-admin" type="del" style="margin-left: 20px;">
								<a>删除该帖</a>
							</span>
							<div class="fly-list-hint">
								<i class="iconfont" title="回答">&#xe60c;</i>
								<s:property value="#paste.ansnum"/>
							</div>
						</div>
						<div class="detail-about">
							<a class="jie-user" href="">
								<img src="${pageContext.request.contextPath }<s:property value="#paste.user.image"/>" alt="头像">
								<cite>
									<s:property value="#paste.user.username"/>
									<em><s:property value="#paste.createtime"/>发布</em>
								</cite>
							</a>
							<div class="detail-hits" data-id="{{rows.id}}">
								<span class="layui-btn layui-btn-mini jie-admin">
									<a href="#">已完帖，无法编辑</a>
								</span>
								<span class="layui-btn layui-btn-mini jie-admin" type="collect" data-type="add">
									<a id="collectPost">收藏</a>
								</span>
								<span class="layui-btn layui-btn-mini jie-admin  layui-btn-danger" type="collect" data-type="add">
									<a>取消收藏</a>
								</span>	
							</div>
						</div>
						<div class="detail-body photos" style="margin-bottom: 20px;">
							<p><s:property value="#paste.content"/></p>
						</div>
					</div>
					<div class="fly-panel detail-box" style="padding-top: 0;">
						<a name="comment"></a>
						<ul class="jieda photos" id="jieda">
							<li data-id="12" class="jieda-daan">
								<a name="item-121212121212"></a>
								<div class="detail-about detail-about-reply">
									<a class="jie-user" href="">
										<img src="res/images/uer.jpg" alt="">
										<cite>
											<i>纸飞机</i>
											<!-- <em>(楼主)</em>
	                  							<em style="color:#5FB878">(管理员)</em> -->
										</cite>
									</a>
									<div class="detail-hits">
										<span>3分钟前</span>
									</div>
									<i class="iconfont icon-caina" title="最佳答案"></i>
								</div>
								<div class="detail-body jieda-body">
									<p>么么哒</p>
								</div>
								<div class="jieda-reply">
									<span class="jieda-zan zanok" type="zan">
										<i class="iconfont icon-zan"></i>
										<em>12</em>
									</span>
									<!-- <div class="jieda-admin">
						                <span type="del">删除</span>
						                <span class="jieda-accept" type="accept">采纳</span>
						              	</div> -->
								</div>
							</li>
							<li data-id="13">
								<a name="item-121212121212"></a>
								<div class="detail-about detail-about-reply">
									<a class="jie-user" href="">
										<img src="res/images/uer.jpg" alt="">
										<cite>
											<i>香菇</i>
											<em style="color: #FF9E3F">活雷锋</em>
										</cite>
									</a>
									<div class="detail-hits">
										<span>刚刚</span>
									</div>
								</div>
								<div class="detail-body jieda-body">
									<p>蓝瘦</p>
								</div>
								<div class="jieda-reply">
									<span class="jieda-zan" type="zan">
										<i class="iconfont icon-zan"></i>
										<em>0</em>
									</span>
									<div class="jieda-admin">
										<span type="del">
											<a href="#" class="layui-btn layui-btn-danger layui-btn-small">删除</a>
										</span>
										<span class="jieda-accept" type="accept">
											<a href="#" class="layui-btn  layui-btn-small">采纳</a>
										</span>
									</div>
								</div>
							</li>	
							<!-- <li class="fly-none">没有任何回答</li> -->
						</ul>
						<span id="toName">@ 压缩(楼主)</span>
						<div class="layui-form layui-form-pane">
							<form action="">
								<div class="layui-form-item layui-form-text">
									<div class="layui-input-block">
										<textarea id="L_content" name="content" required lay-verify="required" placeholder="我要回答" class="layui-textarea fly-editor"
											style="height: 150px;"></textarea>
									</div>
								</div>
								<div class="layui-form-item">
									<button class="layui-btn" lay-filter="*" lay-submit>提交回答</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
	
			<div class="edge">
				<dl class="fly-panel fly-list-one">
					<dt class="fly-panel-title">最近热帖</dt>
					<s:iterator value="#glanceoverPageBean.list" var="paste">
						<dd>
							<a href="${pageContext.request.contextPath }/PasteAction_getDetail?pasteid=<s:property value="#paste.id"/>">
								<s:property value="#paste.title"/>
							</a>
							<span>
								<i class="iconfont">&#xe60b;</i>
								<s:property value="#paste.glanceover"/>
							</span>
						</dd>
					</s:iterator>
				</dl>	
				<dl class="fly-panel fly-list-one">
					<dt class="fly-panel-title">近期热议</dt>
					<s:iterator value="#ansnumPageBean.list" var="paste">
						<dd>
							<a href="${pageContext.request.contextPath }/PasteAction_getDetail?pasteid=<s:property value="#paste.id"/>">
								<s:property value="#paste.title"/>
							</a>
							<span>
								<i class="iconfont">&#xe60c;</i>
								<s:property value="#paste.ansnum"/>
							</span>
						</dd>
					</s:iterator>
				</dl>
			</div>
		</div>
		<script type="text/javascript" charset="utf-8" src="res/js/kindeditor.js"></script>
		<script type="text/javascript">
			KE.show({
				id : 'L_content',
				resizeMode : 1,
				items : [ 'fontname', 'fontsize', 'textcolor', 'bgcolor', 'bold',
						'italic', 'underline', 'removeformat', 'justifyleft',
						'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', 'emoticons', 'image', 'link' ]
			});
		</script>
	</body>
</html>