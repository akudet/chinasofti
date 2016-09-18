<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
  <%@include file="../../nav.jsp"%>
    <form action="/TP4/op/checkin/" method="POST">
    <input type="hidden" name="PUT">
    	预定单号:<input type="text" readonly="readonly" name="checkinId" value="${checkin.checkinId}"/><br>
    	房间类型:<input type="text" readonly="readonly" name="roomTypeDesc" value="${checkin.roomTypeDesc }" /><br>
		房间号:<input type="text" readonly="readonly" name="roomId" value="${checkin.roomId }" /><br>
		客户类型:<input type="text" readonly="readonly" name="cusTypeNo" value="${checkin.cusTypeDesc }"/><br>
		客户名称:<input type="text" readonly="readonly" name="name" value="${checkin.name }"/><br>
		性别:<input type="text" readonly="readonly" name="sex" value="${checkin.sex }"/><br>
		证件类型:<input type="text" readonly="readonly" name="certType" value="${checkin.certType }"/><br>
		证件编号:<input type="text" name="certNumber" value="${checkin.certNumber }"/><br>
		地址信息:<input type="text" name="address" value="${checkin.address }"/><br>
		备注:<input type="text" name="comment" value="${checkin.comment }"/><br>
		计费方式:<input type="text" readonly="readonly" name="checkinType" value="${checkin.checkinType }"/><br>
		预住天数:<input type="text" readonly="readonly" name="numOfDays" value="${checkin.numOfDays }"/><br>
		押金:<input type="text" readonly="readonly" name="deposit" value="${checkin.deposit }"/><br>
		<input type="submit" value="修改"/>
    </form>
  </body>
</html>
