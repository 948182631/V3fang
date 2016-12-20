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
	
	<body>
		<!-- contact-form -->
		<div class="message warning">
			<div class="inset">
				<div class="login-head">
					<h1>
						欢迎使用V3芳网路平台
					</h1>
				</div>
				<form name="f" action="j_spring_security_check" method="POST" >
					<li style="font-size: 16px;font-family:'Droid Sans' ">
						用户名：
						<input type="text" class="text" name='j_username'  value="admin">
						<a href="#" class=" icon user"></a>
					</li>
					<div class="clear">
					</div>
				<li style="font-size: 16px;font-family:'Droid Sans' ">
					密&nbsp;码：
					<a href="#" class="icon lock"></a>
						<input type="password"   name='j_password' value="" ">
						
					</li>
					<div class="clear">
					</div>
					<div class="submit">
						<input type="submit" id="nickForm"  value="登s录">
						<h4>
							<a ><div id="error" style="font-size: 20px;color: #FF0000;font-family:'Droid Sans' "></div></a>
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
