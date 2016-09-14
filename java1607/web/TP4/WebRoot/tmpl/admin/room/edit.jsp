<%@ page language="java" import="java.util.*,tp4.model.vo.*" pageEncoding="UTF-8"%>
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
    
    <title>My JSP 'edit.jsp' starting page</title>
    
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
    <form action="/TP4/admin/room/" method="POST">
    <input type="hidden" name="PUT">
    	房间号：&nbsp;<input type="text" name="roomId" readonly="readonly" value="${room.roomId }"/><br>
    	房间类型：<select name="roomTypeNo">
    			<c:if test="${room.roomType.roomTypeNo==0 }">
    			<option value="0" selected="selected">标准单人间</option>
    			<option value="1">标准双人间</option>
    			<option value="2">豪华单人间</option>
    			<option value="3">豪华双人间</option>
    			<option value="4">商务套房</option>
    			<option value="5">总统套房</option>
    			</c:if>
    			<c:if test="${room.roomType.roomTypeNo==1 }">
    			<option value="0">标准单人间</option>
    			<option value="1" selected="selected">标准双人间</option>
    			<option value="2">豪华单人间</option>
    			<option value="3">豪华双人间</option>
    			<option value="4">商务套房</option>
    			<option value="5">总统套房</option>
    			</c:if>
    			<c:if test="${room.roomType.roomTypeNo==2 }">
    			<option value="0">标准单人间</option>
    			<option value="1">标准双人间</option>
    			<option value="2" selected="selected">豪华单人间</option>
    			<option value="3">豪华双人间</option>
    			<option value="4">商务套房</option>
    			<option value="5">总统套房</option>
    			</c:if>
    			<c:if test="${room.roomType.roomTypeNo==3 }">
    			<option value="0">标准单人间</option>
    			<option value="1">标准双人间</option>
    			<option value="2">豪华单人间</option>
    			<option value="3" selected="selected">豪华双人间</option>
    			<option value="4">商务套房</option>
    			<option value="5">总统套房</option>
    			</c:if>
    			<c:if test="${room.roomType.roomTypeNo==4 }">
    			<option value="0">标准单人间</option>
    			<option value="1">标准双人间</option>
    			<option value="2">豪华单人间</option>
    			<option value="3">豪华双人间</option>
    			<option value="4" selected="selected">商务套房</option>
    			<option value="5">总统套房</option>
    			</c:if>
    			<c:if test="${room.roomType.roomTypeNo==5 }">
    			<option value="0">标准单人间</option>
    			<option value="1">标准双人间</option>
    			<option value="2">豪华单人间</option>
    			<option value="3">豪华双人间</option>
    			<option value="4">商务套房</option>
    			<option value="5" selected="selected">总统套房</option>
    			</c:if>
    			
    			</select><br>
    	房间楼层：<input type="text" name="floor" value="${room.floor }"/><br>
    	房间电话：<input type="text" name="phone" value="${room.phone }"/><br>
    	房间状态：<input type="radio" name="status" value="${room.status }" checked="checked"/>可用
    		<input type="radio" name="status" value="${room.status }"/>停用<br>
    	备&nbsp;&nbsp;注：<input type="text" name="comment" value="${room.comment }"/><br>
    	<input type="submit" value="修改"/>
    </form>
  </body>
</html>
