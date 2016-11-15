<%@ page language="java" import="java.util.*, jtwu.model.*, jtwu.controller.servlet.*" pageEncoding="UTF-8"%>
<%
Collection<User> users = (Collection<User>) request.getAttribute("users");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin.jsp' starting page</title>
    
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
  	<!-- generate a list of users with an edit link on it -->
  	<table>
  	  <tr>
  	    <th>用户名</th>
  	    <th>密码</th>
  	    <th>状态</th>
  	    <th>编辑</th>
  	  </tr>
  	  <%--
    <% for (User user : users) { %>
      <tr>
        <td><%= user.getName() %></td>
        <td><%= user.getPass() %></td>
        <td><%= user.getStatusDescription() %></td>
        <td>
        	<form action="<%= path + UsersServlet.SERVLET_URL %>" method="get">
        		<input type="hidden" name="edit">
  				<input type="hidden" name="id" value="<%= user.getId() %>">
  				<input type="submit" value="修改">
  			</form>
  			<form action="<%= path + UsersServlet.SERVLET_URL %>" method="post">
  				<input type="hidden" name="delete">
  				<input type="hidden" name="id" value="<%= user.getId() %>">
  				<input type="submit" value="删除">
  			</form>
  		</td>
      </tr>
    <% } %>
     --%>
    <c:forEach items="${users}" var="user">
    	<tr>
    		<td>${user.name}</td>
    		<td>${user.pass}</td>
    		<td>${user.statusDescription}</td>
			<td>
        	<form action="<%= path + UsersServlet.SERVLET_URL %>" method="get">
        		<input type="hidden" name="edit">
  				<input type="hidden" name="id" value="${user.id}">
  				<input type="submit" value="修改">
  			</form>
  			<form action="<%= path + UsersServlet.SERVLET_URL %>" method="post">
  				<input type="hidden" name="delete">
  				<input type="hidden" name="id" value="${user.id}">
  				<input type="submit" value="删除">
  			</form>
  		</td>
    	</tr>
    </c:forEach>
  	</table>
  </body>
</html>
