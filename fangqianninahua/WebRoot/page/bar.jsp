<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 需要引入index.css公告才能运行 -->
<header class="am-topbar admin-header" style="margin: 0">


    <script>
	 function autoScroll(obj){  
			$(obj).find("ul").animate({  
				marginTop : "-39px"  
			},500,function(){  
				$(this).css({marginTop : "0px"}).find("li:first").appendTo(this);  
			})  
		}  
		$(function(){  
			setInterval('autoScroll(".apple")',2000);
		}) ;
		
	</script>

<div class="am-topbar-brand">
	<strong>V3芳网络</strong>
	<small>后台管理</small>
</div>
<div id="topbar-collapse" class="am-collapse am-topbar-collapse">
	<ul
		class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
		<li data-am-dropdown="" class="am-dropdown">
			<a href="javascript:;" data-am-dropdown-toggle=""
				class="am-dropdown-toggle"> <span class="am-icon-users"></span>
				管理员 <span class="am-icon-caret-down"></ span> 
			</a>
			<ul class="am-dropdown-content">
				<li>
					<a style="cursor: pointer;"  data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0, width: 400, height: 225}"><span class="am-icon-user"></span> 资料</a>
				</li>
				<li>
					<a href="#"><span class="am-icon-cog"></span> 设置</a>
				</li>
				<li>
					<a href="j_spring_security_logout"><span class="am-icon-power-off"></span> 退出</a>
				</li>
			</ul>
		</li>
	</ul>
	<div class="am-cf" style="">
		<span class="am-fl am-topbar-brand"
			style="margin: 0px; padding: 0; margin-left: 40px">公告：</span>
		<div class="apple">
			<ul style="padding: 0px;">
				<li>
					<a href="#" target="_blank">V3芳网路平台欢迎您 </a>
				</li>
				<li>
					<a href="#" target="_blank">V3芳网路平台欢迎您 </a>
				</li>

			</ul>
		</div>

	</div>

</div>
<!--弹出的div-->
	<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1">
	  <div class="am-modal-dialog">
	    <div class="am-modal-hd">用户名:<sec:authentication property="name" /><br> 
  		拥有权限:<sec:authentication property="principal.authorities" /><br>  
       	是否可用:<sec:authentication property="principal.enabled" /><br>  
	          未被锁定:<sec:authentication property="principal.accountNonLocked" /><br>  
	     <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
	    </div>
	  </div>
	</div>
</header>
<hr data-am-widget="divider" style="margin: 5px;"
	class="am-divider am-divider-default" />