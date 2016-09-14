<%@ page language="java" import="java.util.*,tp4.model.vo.*,tp4.servlet.admin.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  </head>
  
  <body>
   <table width="700" height="50" border="1" align="center">
   <tr>
   <th>ID</th> 
   <th>账号</th>
   <th>密码</th> 
   <th>特权</th> 
   <th>操做</th>
   </tr>
   
   <c:forEach items="${requestScope.users }" var="user">
   	<tr>
		<td>${user.userId}</td>
		<td>${user.userName }</td>
		<td>${user.userPass }</td>
		<td>${user.privilege }</td>
   		<td><a href="<%= path + UserServlet.SERVLET_URL%>/edit?userId=${user.userId}">修改</a> <a>删除</a>
   </td>
   </c:forEach>
   
   <a href="<%= path + UserServlet.SERVLET_URL%>/new">添加</a></br>
   
  
  </body>
</html>
