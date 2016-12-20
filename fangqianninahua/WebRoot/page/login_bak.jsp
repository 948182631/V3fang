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

		<title>My JSP 'login.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=basePath%>css/style.css" rel="stylesheet"
			type="text/css" media="all" />
	</head>
	<body>
		<!-- contact-form -->
		<div class="message warning">
			<div class="inset">
				<div class="login-head">
					<h1>
						欢迎使用网路平台
					</h1>
				</div>
				<form name="f" action="j_spring_security_check" method="POST" >
					<li>
						用户名：
						<input type="text" class="text" name='j_username'  value="admin"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Username';}">
						<a href="#" class=" icon user"></a>
					</li>
					<div class="clear">
					</div>
					<li>
						密&nbsp;码：
					<a href="#" class="icon lock"></a>
						<input type="password"   name='j_password' value="admin" onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Password';}">
						
					</li>
					<div class="clear">
					</div>
					<div class="submit">
						<input type="submit"  value="登录">
						<h4>
							<a href="#">忘记密码？</a>
						</h4>
						<div class="clear">
						</div>
					</div>

				</form>
			</div>
		</div>
		<div class="clear">
		</div>
		<!--- footer --->
		<div class="footer">
			<p>
				Copyright &copy; 2015.
			</p>
		</div>
	</body>
</html>
