<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<form action="/TP4/admin/room_type" method="POST">
		<input type="hidden" name="PUT"> 房间类型编号: <input type="text"
			id="room_type_no" name="room_type_no" value="${roomType.roomTypeNo}"><br>
		<br> 房间类型: <select name="room_type_desc"
			style="width: 120px ;height: 25px;text-align:left; font-size: 14;">
			<c:if test="${roomType.roomTypeNo==0 }">
				<option value="0" selected="selected">标准单人间</option>
				<option value="1">标准双人间</option>
				<option value="2">豪华单人间</option>
				<option value="3">豪华双人间</option>
				<option value="4">商务套房</option>
				<option value="5">总统套房</option>
			</c:if>
			<c:if test="${roomType.roomTypeNo==1 }">
				<option value="0">标准单人间</option>
				<option value="1" selected="selected">标准双人间</option>
				<option value="2">豪华单人间</option>
				<option value="3">豪华双人间</option>
				<option value="4">商务套房</option>
				<option value="5">总统套房</option>
			</c:if>
			<c:if test="${roomType.roomTypeNo==2 }">
				<option value="0">标准单人间</option>
				<option value="1">标准双人间</option>
				<option value="2" selected="selected">豪华单人间</option>
				<option value="3">豪华双人间</option>
				<option value="4">商务套房</option>
				<option value="5">总统套房</option>
			</c:if>
			<c:if test="${roomType.roomTypeNo==3 }">
				<option value="0">标准单人间</option>
				<option value="1">标准双人间</option>
				<option value="2">豪华单人间</option>
				<option value="3" selected="selected">豪华双人间</option>
				<option value="4">商务套房</option>
				<option value="5">总统套房</option>
			</c:if>
			<c:if test="${roomType.roomTypeNo==4 }">
				<option value="0">标准单人间</option>
				<option value="1">标准双人间</option>
				<option value="2">豪华单人间</option>
				<option value="3">豪华双人间</option>
				<option value="4" selected="selected">商务套房</option>
				<option value="5">总统套房</option>
			</c:if>
			<c:if test="${roomType.roomTypeNo==5 }">
				<option value="0">标准单人间</option>
				<option value="1">标准双人间</option>
				<option value="2">豪华单人间</option>
				<option value="3">豪华双人间</option>
				<option value="4">商务套房</option>
				<option value="5" selected="selected">总统套房</option>
			</c:if>

		</select><br> 床位数: <input type="text" id="room_beds" name="beds"
			value="${roomType.beds}"><br>
		<br> 单价: <input type="text" id="room_beds" name="price"
			value="${roomType.price}"><br>
		<br>
		<c:if test="${roomType.isHourRoom==0}">
  是否可开钟点房:     <input type="radio" name="isHourRoom" value="true"checked /> 是
                 <input type="radio" name="isHourRoom" value="false" /> 否<br>
			<br>
		</c:if>
		<c:if test="${roomType.isHourRoom==1}">
		
			<input type="radio" name="isHourRoom" value="true" /> 是
            <input type="radio" name="isHourRoom" value="false" checked /> 否<br>
			<br>
		</c:if>
		钟点房价格: <input type="text" id="room_beds" name="hourRoomPrice"
			value="${roomType.hourRoomPrice}"><br>
		<br> 备注: <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<textarea rows="5px" cols="50px" name="comment"
			value="${roomType.comment}"></textarea>
		<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit"
			value="修改" style="height: 25px;width: 70px;text-align: center;">
	</form>
</body>
</html>
