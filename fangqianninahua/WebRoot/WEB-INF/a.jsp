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
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />


<link href="<%=basePath%>H/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>H/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>skin/default/skin.css" rel="stylesheet" type="text/css" id="skin" />
<link href="<%=basePath%>H/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>H/css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=basePath%>H/lib/jquery/1.9.1/jquery.min.js"></script> 
<title>V3</title>

<script type="text/javascript">

$(function() {
	$.ajax({
		type:'POST',
		url : "menu/menulist.json",
		async: false,
		success : function(data) {
		if(data!=null){
			 $("#SCMENUs").append(data);
			}else{
				alert("异常！返回为空");  
			}
		
		},error : function() {  
			alert("异常！");  
		}  
	});

});
</script>


</head>
<body>
<header class="Hui-header cl"> <a class="Hui-logo l">V3网路平台</a> <a class="Hui-logo-m l"  title="V3">V3网路平台</a>  
<!--	<nav class="mainnav cl" id="Hui-nav">-->
<!--		<ul>-->
<!--			<li class="dropDown dropDown_click"><a href="javascript:;" class="dropDown_A"><i class="Hui-iconfont">&#xe600;</i> 新增 <i class="Hui-iconfont">&#xe6d5;</i></a>-->
<!--				<ul class="dropDown-menu radius box-shadow">-->
<!--					<li><a href="javascript:;" onclick="article_add('添加资讯','article-add.html')"><i class="Hui-iconfont">&#xe616;</i> 资讯</a></li>-->
<!--					<li><a href="javascript:;" onclick="picture_add('添加资讯','picture-add.html')"><i class="Hui-iconfont">&#xe613;</i> 图片</a></li>-->
<!--					<li><a href="javascript:;" onclick="product_add('添加资讯','product-add.html')"><i class="Hui-iconfont">&#xe620;</i> 产品</a></li>-->
<!--					<li><a href="javascript:;" onclick="member_add('添加用户','member-add.html','','510')"><i class="Hui-iconfont">&#xe60d;</i> 用户</a></li>-->
<!--				</ul>-->
<!--			</li>-->  
<!--		</ul>-->
<!--	</nav>--> 
	<ul class="Hui-userbar"> 
		<li>超级管理员少时诵诗书谁水水水水水水水水</li>
		<li class="dropDown dropDown_hover"><a href="#" class="dropDown_A">admin <i class="Hui-iconfont">&#xe6d5;</i></a>
			<ul class="dropDown-menu radius box-shadow">
				<li><a href="#">个人信息</a></li>
				<li><a href="#">切换账户</a></li>
				<li><a href="j_spring_security_logout">退出</a></li>
			</ul>
		</li>
<!--		<li id="Hui-msg"> <a href="#" title="消息"><span class="badge badge-danger">1</span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a> </li>-->
<!--		<li id="Hui-skin" class="dropDown right dropDown_hover"><a href="javascript:;" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>-->
<!--			<ul class="dropDown-menu radius box-shadow">-->
<!--				<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>-->
<!--				<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>-->
<!--				<li><a href="javascript:;" data-val="	" title="绿色">绿色</a></li>-->
<!--				<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>-->
<!--				<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>-->
<!--				<li><a href="javascript:;" data-val="orange" title="绿色">橙色</a></li>-->
<!--			</ul>-->
<!--		</li>-->
	</ul>
	<a aria-hidden="false" class="Hui-nav-toggle" href="#"></a> </header>
<aside class="Hui-aside">
	<input runat="server" id="divScrollValue" type="hidden" value="" />
	<div class="menu_dropdown bk_2">
<div  id="SCMENUs" >	</div>
<!--		<dl id="menu-product">-->
<!--			<dt><i class="Hui-iconfont">&#xe613;</i> 图片管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>-->
<!--			<dd>-->
<!--				<ul>-->
<!--					<li><a _href="picture-list.html" href="javascript:void(0)">图片管理</a></li>-->
<!--				</ul>-->
<!--			</dd>-->
<!--		</dl>-->
<!--	-->
<!--		<dl id="menu-product">-->
<!--			<dt><i class="Hui-iconfont">&#xe620;</i> 产品管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>-->
<!--			<dd>-->
<!--				<ul>-->
<!--					<li><a _href="product-brand.html" href="javascript:void(0)">品牌管理</a></li>-->
<!--					<li><a _href="product-category.html" href="javascript:void(0)">分类管理</a></li>-->
<!--					<li><a _href="product-list.html" href="javascript:void(0)">产品管理</a></li>-->
<!--				</ul>-->
<!--			</dd>-->
<!--		</dl>-->
<!--		-->
<!--		</dl>-->
<!--		<dl id="menu-comments">-->
<!--			<dt><i class="Hui-iconfont">&#xe622;</i> 评论管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>-->
<!--			<dd>-->
<!--				<ul>-->
<!--					<li><a _href="http://h-ui.duoshuo.com/admin/" href="javascript:;">评论列表</a></li>-->
<!--					<li><a _href="feedback-list.html" href="javascript:void(0)">意见反馈</a></li>-->
<!--				</ul>-->
<!--			</dd>-->
<!--		</dl>-->
<!--	-->
<!--		<dl id="menu-member">-->
<!--			<dt><i class="Hui-iconfont">&#xe60d;</i> 会员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>-->
<!--			<dd>-->
<!--				<ul>-->
<!--					<li><a _href="member-list.html" href="javascript:;">会员列表</a></li>-->
<!--					<li><a _href="member-del.html" href="javascript:;">删除的会员</a></li>-->
<!--					<li><a _href="member-level.html" href="javascript:;">等级管理</a></li>-->
<!--					<li><a _href="member-scoreoperation.html" href="javascript:;">积分管理</a></li>-->
<!--					<li><a _href="member-record-browse.html" href="javascript:void(0)">浏览记录</a></li>-->
<!--					<li><a _href="member-record-download.html" href="javascript:void(0)">下载记录</a></li>-->
<!--					<li><a _href="member-record-share.html" href="javascript:void(0)">分享记录</a></li>-->
<!--				</ul>-->
<!--			</dd>-->
<!--		</dl>-->
<!--		<dl id="menu-admin">-->
<!--			<dt><i class="Hui-iconfont">&#xe62d;</i> 管理员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>-->
<!--			<dd>-->
<!--				<ul>-->
<!--					<li><a _href="admin-role.html" href="javascript:void(0)">角色管理</a></li>-->
<!--					<li><a _href="admin-permission.html" href="javascript:void(0)">权限管理</a></li>-->
<!--					<li><a _href="admin-list.html" href="javascript:void(0)">管理员列表</a></li>-->
<!--				</ul>-->
<!--			</dd>-->
<!--		</dl>-->
		<dl id="menu-tongji">
			<dt><i class="Hui-iconfont">&#xe61a;</i> 系统统计<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a _href="/page/charts/charts-1.jsp" href="javascript:void(0)">折线图</a></li>
					<li><a _href="/page/charts/charts-2.jsp" href="javascript:void(0)">时间轴折线图</a></li>
					<li><a _href="/page/charts/charts-3.jsp" href="javascript:void(0)">区域图</a></li>
					<li><a _href="/page/charts/charts-4.jsp" href="javascript:void(0)">柱状图</a></li>
					<li><a _href="/page/charts/charts-5.jsp" href="javascript:void(0)">饼状图</a></li>
					<li><a _href="/page/charts/charts-6.jsp" href="javascript:void(0)">3D柱状图</a></li>
					<li><a _href="/page/charts/charts-7.jsp" href="javascript:void(0)">3D饼状图</a></li>
						<li><a _href="/WEB-INF/a.jsp" href="javascript:void(0)">3D饼状图</a></li>
				</ul>
			</dd>
		</dl>
<!--		<dl id="menu-system">--> 
<!--			<dt><i class="Hui-iconfont">&#xe62e;</i> 系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>-->
<!--			<dd>-->
<!--				<ul>-->
<!--					<li><a _href="system-base.html" href="javascript:void(0)">系统设置</a></li>-->
<!--					<li><a _href="system-category.html" href="javascript:void(0)">栏目管理</a></li>-->
<!--					<li><a _href="system-data.html" href="javascript:void(0)">数据字典</a></li>-->
<!--					<li><a _href="system-shielding.html" href="javascript:void(0)">屏蔽词</a></li>-->
<!--					<li><a _href="system-log.html" href="javascript:void(0)">系统日志</a></li>-->
<!--				</ul>-->
<!--			</dd>-->
<!--		</dl>-->
	</div>
</aside>
<div class="dislpayArrow"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active"><span title="我的桌面" data-href="welcome.html">我的桌面</span><em></em></li>
			</ul>
		</div>
		<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
	</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" src="welcome.html"></iframe>
		</div>
	</div>
</section>

<script type="text/javascript" src="<%=basePath%>H/lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="<%=basePath%>H/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=basePath%>H/js/H-ui.admin.js"></script> 

<script type="text/javascript">
/*资讯-添加*/
function article_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*图片-添加*/
function picture_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*产品-添加*/
function product_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
</script> 

</body>
</html>