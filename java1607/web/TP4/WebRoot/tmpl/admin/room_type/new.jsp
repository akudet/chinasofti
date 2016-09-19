+<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<link rel="stylesheet" type="te xt/css" href="styles.css">
	-->
<%@include file="../../include.jsp" %>
  </head>
  
 <body>
 <%@include file="../../nav.jsp"%>
	<div class="col-sm-12 col-lg-10 sidebar">
	<%@include file="../admin-nav.jsp"%>
	<div class="panel">
	<div class="panel-heading">添加用户</div>
			<div class="panel-body">
	
  <form action="/TP4/admin/room_type" method="post" >
    <label class="control-label" for="inputSuccess1"> 房间类型编号: </label>
     <input class="form-control" type="text" id = "room_no" name = "room_type_no"style="font-size:large;"><br>
    <label class="control-label" for="inputSuccess1">  房间类型:</label>
      <input class="form-control" type="text"  name="room_type_desc"style="font-size:large;"><br>
    <label class="control-label" for="inputSuccess1"> 床位数: </label>
     <input class="form-control" type="text" id = "room_beds" name = "beds"style="font-size:large;"><br>
  
    <label class="control-label" for="inputSuccess1">单价: </label> 
     <input class="form-control" type="text"  id = "room_beds" name = "price"style="font-size:large;"><br>
    <label class="control-label" for="inputSuccess1">是否可开钟点房:</label> 
     <input type="radio" name="isHourRoom" value="true" style="height: 10px;width: 10px;" /> 
       <label class="control-label" for="inputSuccess1">是</label> 
     <input type="radio" name="isHourRoom" value="false" /> 
     <label class="control-label" for="inputSuccess1">否</label> <br>
    <label class="control-label" for="inputSuccess1">钟点房价格: </label> 
     <input class="form-control" type="text" id = "room_beds" name = "hourRoomPrice"style="font-size:large;"><br>
    <label class="control-label" for="inputSuccess1">   备注:</label> 
      <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<textarea class="form-control" rows="7px" cols="100px" name="comment" style="font-size:large;"></textarea><br>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <input type="submit" value="添加" style="height: 30px;width: 100px;text-align: center;">
    </form>
    </div></div></div>
    
  </body>
</html>
