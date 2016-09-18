<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <form action="/TP4/op/checkin/" method="POST">
    	<input type="hidden" name="POST"/>
		房间类型:<input type="text" name="roomTypeDesc" value="${room.roomType.roomTypeDesc }"/><br>
		房间号:<input type="text" name="roomId" value="${room.roomId }"/><br>
		客户类型:<input type="text" name="cusTypeNo"/><br>
		客户名称:<input type="text" name="name"/><br>
		会员编号:<input type="text" name="vipNo"/><br>
		性别:<input type="text" name="sex"/><br>
		证件类型:<input type="text" name="certType"/><br>
		证件编号:<input type="text" name="certNumber"/><br>
		地址信息:<input type="text" name="address"/><br>
		备注:<input type="text" name="comment"/><br>
		计费方式:<input type="text" name="checkinType"/><br>
		预住天数:<input type="text" name="numOfDays"/><br>
		押金:<input type="text" name="deposit"/><br>
		<input type="submit" value="提交"/>
    </form>
  </body>
</html>
