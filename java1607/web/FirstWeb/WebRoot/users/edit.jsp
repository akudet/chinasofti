<%@ page language="java" import="java.util.*, jtwu.model.*, jtwu.controller.service.*" pageEncoding="UTF-8"%>
<%
	UsersService userService = new UsersService();
int id = Integer.parseInt(request.getParameter("id"));
User user = userService.findUserById(id);

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
    	<form action="users" method="post">
    		<!-- simulate a put request -->
    		<input type="hidden" name="put">
    		
    		<input type="hidden" name="id" value="<%= user.getId() %>">
    	    <input type="text" name="username" value="<%= user.getName() %>">
    		<input type="password" name="userpass" value="<%= user.getPass() %>">
    		<select name="status">
    			<option selected value="<%= User.AUTH_SUCC %>"><%= User.getStatusDescription(User.AUTH_SUCC) %></option>
    			<option value="<%= User.ERR_AUTH_REJECT %>"><%= User.getStatusDescription(User.ERR_AUTH_REJECT) %></option>
    			<option value="<%= User.ERR_PENDING_AUTH %>"><%= User.getStatusDescription(User.ERR_PENDING_AUTH) %></option>
    		</select>
    		<input type="submit" value="修改">
    	</form>
    <% } %>
  </body>
</html>
