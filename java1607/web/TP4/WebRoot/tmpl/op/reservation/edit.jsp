<%@ page language="java" import="java.util.*,tp4.model.vo.*" pageEncoding="UTF-8"%>
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
  		<%Reservation rt = (Reservation)request.getAttribute("user"); %>
       <form action="/TP4/op/reservation/" method="post"  align="center" >
       	<input type="hidden" name="PUT">
    	I&nbsp;&nbsp;D:<input type="text" name="reservationId" value="${rt.reservationId}" onblur="regavalidate()"><br>
    	姓&nbsp;&nbsp;名:<input type="text" name="name"  value="${rt.name}"onblur="regavalidate()"><br>
    	电&nbsp;&nbsp;话:<input type="text" name="phone" value="${rt.phone}" ><br>
		到达时间:<input type="text" name="arriveTime" value="${rt.arriveTime}"><br>
    	延长时间:<input type="text" name="reserveTime" value="${rt.reserveTime}"><br>
    	预订时间:<input type="text" name="reservationTime" value="${rt.reservationTime}"><br>
    	备&nbsp;&nbsp;注:<input type="text" name="comment" value="${rt.comment}"><br>
    	<input type="submit" value="修改"><br>
 
		
    </form>
  </body>
</html>
