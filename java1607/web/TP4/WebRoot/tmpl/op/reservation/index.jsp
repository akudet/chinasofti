<%@ page language="java" import="java.util.*,tp4.servlet.op.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
   <th>名字</th>
   <th>电话</th> 
   <th>到达时间</th> 
   <th>延长时间</th>
   <th>预订时间</th>
   <th>备注</th>
   </tr>
   
   <c:forEach items="${requestScope.users}" var="user">
   	<tr>
		<td>${user.reservationId}</td>
		<td>${user.name}</td>
		<td>${user.phone}</td>
		<td>${user.arriveTime}</td>
		<td>${user.reserveTime}</td>
		<td>${user.reservationTime}</td>
		<td>${user.comment}</td>
		<td>
			<a href="<%= path + ReservationServlet.SERVLET_URL%>/edit?reservationId=${user.reservationId}">修改</a>
			<a>删除</a>
   		</td>
   
   </c:forEach>
   <a href="<%= path + ReservationServlet.SERVLET_URL%>/new">添加</a></br>
   
  </body>
</html>
