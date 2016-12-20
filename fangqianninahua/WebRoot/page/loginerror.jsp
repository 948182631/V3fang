<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">




		<link href="<%=basePath%>H/css/H-ui.min.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>H/css/H-ui.login.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>H/css/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>H/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
		
		
		<script type="text/javascript" src="<%=basePath%>H/lib/jquery/1.9.1/jquery.min.js"></script> 
		<script type="text/javascript" src="<%=basePath%>H/js/H-ui.js"></script> 





<title>V3后台登录</title>
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="loginWraper">
 <div class="loginWraper">
  <div id="loginform" class="loginBox">
   <form name="f"  class="form form-horizontal"  action="j_spring_security_check" method="POST">
      <div class="row cl">
        <label class="form-label col-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-8">
          <input id="" name="j_username" type="text" placeholder="账户" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-8">
          <input id="" name="j_password" type="password" placeholder="密码" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
      </div>
      <div class="row">
        <div class="formControls col-8 col-offset-3">
          <input name="" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <a ><div id="error" style="font-size: 20px;color: #FF0000;font-family:'Droid Sans' "></div></a>
        </div>
      </div>
    </form>
  </div> 
</div>
<div class="footer">Copyright V3芳</div>


	<script src="<%=basePath%>/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript">
		 $(function() {
				var msg=  '<%=session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION") %>';
				if(msg.indexOf("Bad credentials")>0){
					 $("#error").html("密码错误 ");
				}else{

					 $("#error").html(" ${SPRING_SECURITY_LAST_EXCEPTION.message}");
				}

			 });
		
		</script>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F080836300300be57b7f34f4b3e97d911' type='text/javascript'%3E%3C/script%3E"));
</script>
</body>
</html>