<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--@作者：项双江 --%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'new.jsp' starting page</title>
    
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
    <input type="hidden" name="POST">
    	房间号&nbsp;：<input type="text" name="roomId"/><br>
    	房间类型：<select name="roomTypeNo">
    			<option value="0" selected="selected">标准单人间</option>
    			<option value="1">标准双人间</option>
    			<option value="2">豪华单人间</option>
    			<option value="3">豪华双人间</option>
    			<option value="4">商务套房</option>
    			<option value="5">总统套房</option>
    			</select><br>
    	房间楼层：<input type="text" name="floor"/><br>
    	房间电话：<input type="text" name="phone"/><br>
    	房间状态：<input type="radio" name="status" value="0" checked="checked"/>可用
    	<input type="radio" name="status" value="1"/>停用<br>
    	备&nbsp;&nbsp;注：<br>&nbsp;&nbsp;&nbsp;&nbsp; 
    	<textarea rows="5px;" cols="30px;" name="comment"></textarea><br>
    	<input type="submit" value="添加"/>
    </form>
  </body>
</html>
