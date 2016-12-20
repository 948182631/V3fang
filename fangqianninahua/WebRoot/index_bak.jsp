<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html> 
	<head>
		<base href="<%=basePath%>">
		<title>微信后台管理系统</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<script src="<%=basePath%>/js/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" href="<%=basePath%>css/amazeui.min.css">
		<link rel="stylesheet" href="<%=basePath%>css/index.css">
		<script src="<%=basePath%>js/amazeui.min.js"></script>
		
			<link rel="stylesheet" href="<%=basePath%>css/dist/remodal.css">
  			<link rel="stylesheet" href="<%=basePath%>css/dist/remodal-default-theme.css">
				
		<style>
.am-tabs-nav li {
	position: relative;
	z-index: 1;
}

.am-tabs-nav .am-icon-close {
	position: absolute;
	top: 0;
	right: 10px;
	color: #888;
	cursor: pointer;
	z-index: 100;
}

.am-tabs-nav .am-icon-close:hover {
	color: #333;
}

.am-tabs-nav .am-icon-close   ~ a {
	padding-right: 25px !important;
}
</style>
	</head>
	<body>
		<%@include file="page/bar.jsp"%>
		<!-- 菜单 -->
		<div class="am-u-sm-2" style="padding: 0">
			<%@include file="/page/admin/menu.jsp"%>
		</div>


		<!-- 内容 -->
		<div class="am-u-sm-10" style="padding: 0">
			<%@include file="/page/tab/tab.jsp"%>
		</div>

	</body>
</html>
