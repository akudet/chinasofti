<%@ page language="java" import="java.util.*,tp4.servlet.admin.*" pageEncoding="UTF-8"%>
<%--@作者：项双江 --%>
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
<%@include file="../../include.jsp" %>
  </head>
  
  <body>
  <%@include file="../../nav.jsp"%>
	<div class="col-sm-12 col-lg-10 sidebar">
	<%@include file="../admin-nav.jsp"%>
	<div class="panel">
			<div class="panel-body">
  	${requestScope.msg }
  	<div class="btn-toolbar">
        <a class="btn btn-primary" href="<%= path + RoomServlet.SERVLET_URL%>/new"><i class="glyphicon glyphicon-plus"></i> 添加</a>
      </div>
   <p></p>
  	<table class="table">
  		<tr>
  		<th>房间号</th><th>房间类型</th><th>楼层</th>
  		<th>电话</th><th>状态</th><th>备注</th><th>操作</th>
  		</tr>
  		<c:forEach items="${requestScope.rooms }" var="rooms">
  		<tr>
  		<td>${rooms.roomId }</td>
  		<td>${rooms.roomType.roomTypeDesc }</td>
  		<td>${rooms.floor }</td>
  		<td>${rooms.phone }</td>
  		<td>${rooms.statusDesc }</td>
  		<td>${rooms.comment }</td>
  		<td><a href="<%= path + RoomServlet.SERVLET_URL%>/edit?roomId=${rooms.roomId}"><span class="glyphicon glyphicon-edit"></span></a> 
  		 &nbsp;&nbsp; <a href="${deleteUrl}${rooms.roomId}"><span class="glyphicon glyphicon-trash"></span></a></td>
  		</tr>
  		</c:forEach>
  	</table>
  	
  </div></div></div>
  </body>
</html>
