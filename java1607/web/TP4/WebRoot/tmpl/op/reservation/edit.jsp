<%@ page language="java" import="java.util.*,tp4.model.vo.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    
    <title>My JSP 'edit.jsp' stareservationing page</title>
    
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
       <form action="/TP4/op/reservation/" method="POST">
       	<input type="hidden" name="PUT">
    	ID:<input type="text" name="reservationId" value="${reservation.reservationId}" onblur="regavalidate()"><br>
    	姓名:<input type="text" name="name"  value="${reservation.name}"onblur="regavalidate()"><br>
    	电话:<input type="text" name="phone" value="${reservation.phone}" ><br>
		
		预定房间类型：
		<select name="roomTypeNo">
    		<c:forEach items="${roomTypes}" var="roomType">
    			<option value="${roomType.roomTypeNo}">${roomType.roomTypeDesc}</option>
    		</c:forEach>
    	</select><br>
		到达时间:<input type="text" name="arriveTime" value="${reservation.arriveTime}"><br>
    	延长时间:<input type="text" name="reserveTime" value="${reservation.reserveTime}"><br>
    	预订时间:<input type="text" name="reservationTime" value="${reservation.reservationTime}"><br>
    	备&nbsp;&nbsp;注:<input type="text" name="comment" value="${reservation.comment}"><br>
    	<input type="submit" value="修改"><br>
 
		
    </form>
  </body>
</html>
