<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>客户结账</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<p>入住信息</p>
	<table>
		<tr>
			<th>入住单号</th>
			<th>房间类型</th>
			<th>房间号</th>
			<th>客户名称</th>
			<th>单价</th>
			<th>计费方式</th>
			<th>入住时间</th>
			<th>押金</th>
		</tr>
		<tr>
			<td>${checkin.checkinId}</td>
			<td>${checkin.roomTypeDesc}</td>
			<td>${checkin.roomId}</td>
			<td>${checkin.name}</td>
			<td>${checkin.price}</td>
			<td>${checkin.checkinType}</td>
			<td>${checkin.checkinTime}</td>
			<td>${checkin.deposit}</td>
		</tr>
	</table>

	<form action="${servletUrl}" method="POST">
		<input type="number" name="amount">
		<input type="text" name="comment">
		<input type="submit" value="结账">
	</form>
</body>
</html>
