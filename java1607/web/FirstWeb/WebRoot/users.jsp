<%@ page language="java" import="java.util.*,jtwu.servlet.User" pageEncoding="UTF-8"%>
<%
Collection<User> users = (Collection<User>) request.getAttribute("users"); 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'users.jsp' starting page</title>
    
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
  <table>
  	<tr>
  		<th>用户名</th>
  		<th>密码</th>
  	</tr>
    <% for (User user : users) { %>
    <tr>
    	<td><%= user.getName() %></td>
    	<td><%= user.getPass() %></td>
    </tr>
    <% } %>
  </table>

  </body>
</html>
