<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <%@include file="../../nav.jsp"%>
    <form action="/TP4/op/reservation/" method="POST">
    	姓名:<input type="text" name="name"  onblur="regavalidate()"><br>
    	电话:<input type="text" name="phone"  ><br>
    	房间类型:
    	<select name="roomTypeNo">
    		<c:forEach items="${roomTypes}" var="roomType">
    			<option value="${roomType.roomTypeNo}">${roomType.roomTypeDesc}</option>
    		</c:forEach>
    	</select><br>
    	到达时间:<input type="date" name="arriveDate"><input type="time" name="arriveTime"><br>
    	保留时间:<input type="date" name="reserveDate"><input type="time" name="reserveTime"><br>
    	
    	备注:<input type="text" name="comment"><br>
    	<input type="submit" value="添加"><br>
    </form>
   
  </body>
</html>
