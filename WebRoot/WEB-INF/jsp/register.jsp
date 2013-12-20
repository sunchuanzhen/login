<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'register.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
	label{ width:40px; text-align: left ;}
	</style>

  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/servlet/RegisterServlet" method="post">
    	<h3>请输入您的注册信息</h3>
    	<label>姓名：</label><input type="text" name="username" /><b style="color:red">${error.username }</b><br/>
    	<label>密码：</label><input type="password" name="password" /><b style="color:red">${error.password }</b><br/>
    	<label>确认密码：</label><input type="password" name="password2" /><b style="color:red">${error.password2 }</b><br/>
    	<label>email：</label><input type="text" name="email" /><b style="color:red">${error.email }</b><br/>
    	<label>生日：</label><input type="text" name="birthday" /><b style="color:red">${error.birthday }</b><br/>  
    	<label>昵称：</label><input type="text" name="nickname" /><b style="color:red">${error.nickname }</b><br/>  
    	<input type="submit" name="submit" value="提交"/>
    </form>
  </body>
</html>
