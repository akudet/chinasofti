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
    <%@ include file="/tmpl/include.jsp" %>
  </head>
  
  <body>
    <%@include file="../../nav.jsp"%>
    <div class="col-sm-12 col-lg-10 sidebar">
	 <div class="panel panel-primary">
	  <div class="panel-heading">预定添加</div>
      <div class="panel-body">
       <form action="/TP4/op/reservation/" method="POST">
   
        <label class="control-label" for="inputSuccess1">姓名:</label>
    	   <input class="form-control" type="text" name="name"  onblur="regavalidate()"><br>
    	<label class="control-label" for="inputSuccess1">电话:</label>
    	   <input class="form-control" type="text" name="phone"  ><br>
    	<label class="control-label" for="inputSuccess1">房间类型:</label>
    	  <select class="form-control" name="roomTypeNo">
    		<c:forEach items="${roomTypes}" var="roomType">
    			<option value="${roomType.roomTypeNo}">${roomType.roomTypeDesc}</option>
    		</c:forEach>
    	  </select><br>
    	<label class="control-label" for="inputSuccess1">到达时间:</label>
    	  <input class="form-control" type="date" name="arriveDate"><input class="control-label" type="time" name="arriveTime"><br>
    	<label class="control-label" for="inputSuccess1">保留时间:</label>
    	  <input class="form-control" type="date" name="reserveDate"><input class="control-label" type="time" name="reserveTime"><br>
    	<label class="control-label" for="inputSuccess1">备注:</label>
    	  <textarea class="form-control" type="text" name="comment"></textarea><br>
    	<input class="form-control" type="submit" value="添加"><br>
      </form>
     </div>
    </div>
   </div>
  </body>
</html>
