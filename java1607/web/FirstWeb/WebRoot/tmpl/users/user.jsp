<%@ page language="java" import="java.util.*, jtwu.model.*, jtwu.controller.servlet.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

User user = (User) request.getAttribute("user");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'succ.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<h2>欢迎<%= user.getName() %></h2>
  		<p>你是第<%= application.getAttribute("count").toString() %> 访问者。</p>
    	<a href="<%= path + UsersServlet.SERVLET_URL %>">Users</a>
    	<a href="<%= path + LogoutServlet.SERVLET_URL %>">登出</a>
  </body>
</html>
