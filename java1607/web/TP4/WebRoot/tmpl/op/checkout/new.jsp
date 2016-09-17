<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>客户结账</title>
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
		<input type="hidden" name="checkinId" value="${checkin.checkinId}">
		实收金额:<input type="number" name="amount">
		备注:<input type="text" name="comment">
		<input type="submit" value="结账">
	</form>
</body>
</html>
