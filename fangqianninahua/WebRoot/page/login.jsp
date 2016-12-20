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



		<link href="<%=basePath%>H/css/H-ui.min.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>H/css/H-ui.login.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>H/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
		





<title>V3后台登录</title>
</head>
<body>
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
        </div>
      </div>
    </form>
  </div> 
</div>
<div class="footer">Copyright V3芳</div>

<script>
</script>
</body>
</html>