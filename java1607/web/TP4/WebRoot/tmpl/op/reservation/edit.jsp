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
    <%@ include file="/tmpl/include.jsp" %>
  </head>
  
  <body>
  	 <%@include file="../../nav.jsp"%>
  	 <div class="col-sm-12 col-lg-10 sidebar">
		<div class="panel panel-primary">
		  <div class="panel-heading">预订修改</div>
		  <div class="panel-body">
       <form action="/TP4/op/reservation/" method="POST">
       	<input  type="hidden" name="PUT">
       	
       	<label class="control-label" for="inputSuccess1">ID:</label>
    	   <input class="form-control" type="text" name="reservationId" value="${reservation.reservationId}" onblur="regavalidate()"><br>
    	<label class="control-label" for="inputSuccess1">姓名:</label>
    	   <input class="form-control" type="text" name="name"  value="${reservation.name}"onblur="regavalidate()"><br>
    	<label class="control-label" for="inputSuccess1">电话:</label>
    	   <input class="form-control" type="text" name="phone" value="${reservation.phone}" ><br>
		<label class="control-label" for="inputSuccess1">预定房间类型：</label>
		
		  <select class="form-control" name="roomTypeNo">
    		<c:forEach items="${roomTypes}" var="roomType">
    			<option value="${roomType.roomTypeNo}">${roomType.roomTypeDesc}</option>
    		</c:forEach>
    	  </select><br>
		<label class="control-label" for="inputSuccess1">到达时间:</label>
		  <input class="form-control" type="text" name="arriveTime" value="${reservation.arriveTime}"><br>
    	<label class="control-label" for="inputSuccess1">延长时间:</label>
    	  <input class="form-control" type="text" name="reserveTime" value="${reservation.reserveTime}"><br>
    	<label class="control-label" for="inputSuccess1">预订时间:</label>
    	  <input class="form-control" type="text" name="reservationTime" value="${reservation.reservationTime}"><br>
    	<label class="control-label" for="inputSuccess1">备&nbsp;&nbsp;注:</label>
    	  <textarea class="form-control" type="text" name="comment" value="${reservation.comment}"></textarea><br>
    	<input class="form-control" type="submit" value="修改"><br>
 
		
      </form>
     </div>
    </div>
    </div>
  </body>
</html>
