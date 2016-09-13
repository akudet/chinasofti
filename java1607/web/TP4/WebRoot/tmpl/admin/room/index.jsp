<%@ page language="java" import="java.util.*,tp4.servlet.admin.*" pageEncoding="UTF-8"%>
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

  </head>
  
  <body>
  	${requestScope.msg }
  	<table>
  		<tr>
  		<th>房间号</th><th>房间类型</th><th>楼层</th>
  		<th>电话</th><th>状态</th><th>备注</th><th>操作</th>
  		</tr>
  		<c:forEach items="${requestScope.list }" var="list">
  		<tr>
  		<td>${list.roomId }</td>
  		<td>${list.roomType.roomTypeDesc }</td>
  		<td>${list.floor }</td>
  		<td>${list.phone }</td>
  		<td>${list.status }</td>
  		<td>${list.comment }</td>
  		<td><a href="<%= path + RoomServlet.SERVLET_URL%>/edit?roomId=${list.roomId}" onclick="a()">修改</a> <a>删除</a></td>
  		</tr>
  		</c:forEach>
  	</table>
  	<a href="<%= path + RoomServlet.SERVLET_URL%>/new">添加房间</a>
  </body>
</html>
