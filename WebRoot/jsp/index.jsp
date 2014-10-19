<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="comm.jsp"%>
<html>
<head>
<link type="text/css" href="${ctx}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link type="text/css" href="${ctx}/css/public.css" rel="stylesheet">
<script type="text/javascript"
	src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>揭阳JYOFFER</title>
</head>
</head>
<body>
	<div id="menu">
		<ul>
			<li><a href="${ctx}/index">首页</a></li>
			<li><a href="#">公司</a></li>
			<li><a href="#">论坛</a></li>
			<li><a href="#">我的简历</a></li>
			<li><a href="#">发布职位</a></li>
		</ul>
		<!--<EMBED src="${ctx}/music/2.mp3" width=0 height=0 type=audio/mpeg loop="-1" autostart="true" volume="0"></EMBED>-->
		
		<div class="login">
		<c:choose>
		<c:when test="${empty worker.name }">
		<a href="#">注册</a>|<a href="${ctx}/users/login">登录</a>
		</c:when>
		<c:otherwise>
		  <a href="${ctx}/worker/edit?userID=${worker.userID}">${worker.name}</a>
		</c:otherwise>
		
		</c:choose>
         </div>
	</div>

	<div id="content-warp">
		<div id="content-left">

			<ul class="topmenu">

				<li><a href="#">五金、机械、模具</a><span></span>
					<div class="submenu">
						<div class="leftdiv">
							<dl>
								<dt>
									<a href="#">电子书</a>
								</dt>
								<dd>
									<a href="#">免费</a> <a href="#">小说</a> <a href="#">励志与成功</a> <a
										href="#">婚恋/两性</a> <a href="#">文学</a> <a href="#">经管</a> <a
										href="#">畅读VIP</a>
								</dd>
							</dl>
						</div>
					</div></li>

				<li><a href="#">鞋业、服装、纺织</a><span></span>
					<div class="submenu">
						<div class="leftdiv">
							<dl>
								<dt>
									<a href="#">电dff</a>
								</dt>
								<dd>
									<a href="#">免gg费</a> <a href="#">小gg说</a> <a href="#">励志与hhh成功</a>
									<a href="#">婚恋/两性</a> <a href="#">文gg学</a> <a href="#">经gg管</a>
									<a href="#">畅读VgggIP</a>
								</dd>
							</dl>
						</div>
					</div></li>

				<li><a href="#">工艺、玩具、塑料</a><span></span>
					<div class="submenu">
						<div class="leftdiv">
							<dl>
								<dt>
									<a href="#">电dfddddddf</a>
								</dt>
								<dd>
									<a href="#">免gg费</a> <a href="#">小gg说</a> <a href="#">励志与hhh成功</a>
									<a href="#">婚恋/两性</a> <a href="#">文gg学</a> <a href="#">经gg管</a>
									<a href="#">畅读VgggIP</a>
								</dd>
							</dl>
						</div>
					</div></li>
				<li><a href="#">房产、装饰、建材</a><span></span>
					<div class="submenu">
						<div class="leftdiv">
							<dl>
								<dt>
									<a href="#">电dff电dff电dff电dff</a>
								</dt>
								<dd>
									<a href="#">免gg费</a> <a href="#">小gg说</a> <a href="#">励志与hhh成功</a>
									<a href="#">婚恋/两性</a> <a href="#">文gg学</a> <a href="#">经gg管</a>
									<a href="#">畅读VgggIP</a>
								</dd>
							</dl>
						</div>
					</div></li>
				<li><a href="#">家居、家具、家装、厨具</a><span></span>
					<div class="submenu">
						<div class="leftdiv">
							<dl>
								<dt>
									<a href="#">电dff</a>
								</dt>
								<dd>
									<a href="#">免gg费</a> <a href="#">小gg说</a> <a href="#">励志与hhh成功</a>
									<a href="#">婚恋/两性</a> <a href="#">文gg学</a> <a href="#">经gg管</a>
									<a href="#">畅读VgggIP</a>
								</dd>
							</dl>
							<dl>
								<dt>
									<a href="#">电dff</a>
								</dt>
								<dd>
									<a href="#">免gg费</a> <a href="#">小gg说</a> <a href="#">励志与hhh成功</a>
									<a href="#">婚恋/两性</a> <a href="#">文gg学</a> <a href="#">经gg管</a>
									<a href="#">畅读VgggIP</a>
								</dd>
							</dl>
						</div>
					</div></li>
				<li><a href="#">服饰内衣、珠宝首饰</a><span></span>
					<div class="submenu">
						<div class="leftdiv">
							<dl>
								<dt>
									<a href="#">电dff</a>
								</dt>
								<dd>
									<a href="#">免gg费</a> <a href="#">小gg说</a> <a href="#">励志与hhh成功</a>
									<a href="#">婚恋/两性</a> <a href="#">文gg学</a> <a href="#">经gg管</a>
									<a href="#">畅读VgggIP</a>
								</dd>
							</dl>
							<dl>
								<dt>
									<a href="#">电dff</a>
								</dt>
								<dd>
									<a href="#">免gg费</a> <a href="#">小gg说</a> <a href="#">励志与hhh成功</a>
									<a href="#">婚恋/两性</a> <a href="#">文gg学</a> <a href="#">经gg管</a>
									<a href="#">畅读VgggIP</a>
								</dd>
							</dl>
							<dl>
								<dt>
									<a href="#">电dff</a>
								</dt>
								<dd>
									<a href="#">免gg费</a> <a href="#">小gg说</a> <a href="#">励志与hhh成功</a>
									<a href="#">婚恋/两性</a> <a href="#">文gg学</a> <a href="#">经gg管</a>
									<a href="#">畅读VgggIP</a>
								</dd>
							</dl>
						</div>
					</div></li>
			</ul>

		</div>
		<div id="content-right"></div>
	</div>

	<div id="bottom"></div>

</body>
</html>