<%@ page language="java" import="java.util.*, jtwu.model.*, jtwu.controller.service.*, jtwu.controller.servlet.*" pageEncoding="UTF-8"%>
<%

User user = (User) request.getAttribute("user");

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
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
  	<!-- show a page allow user to modifiy a particular user -->
    <% if (user != null) { %>
    	<%= user.getName() %>
    	<form action="<%= path + UsersServlet.SERVLET_URL %>" method="post">
    		<!-- simulate a put request -->
    		<input type="hidden" name="put">
    		
    		<input type="hidden" name="id" value="<%= user.getId() %>">
    	    <input type="text" name="username" value="<%= user.getName() %>">
    		<input type="password" name="userpass" value="<%= user.getPass() %>">
    		<select name="status">
    			<option selected value="<%= User.AUTH_SUCC %>"><%= User.getStatusDescription(User.AUTH_SUCC) %></option>
    			<option value="<%= User.AUTH_REJECT %>"><%= User.getStatusDescription(User.AUTH_REJECT) %></option>
    			<option value="<%= User.AUTH_PENDING %>"><%= User.getStatusDescription(User.AUTH_PENDING) %></option>
    		</select>
    		<input type="submit" value="修改">
    	</form>
    <% } %>
  </body>
</html>
