<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--@作者：项双江 --%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加房间信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
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
			
    <form action="/TP4/admin/room/" method="POST">
    <input type="hidden" name="POST">
        <label class="control-label" for="inputSuccess1"> 房间号:</label>
    	&nbsp;<input class="form-control"type="text" name="roomId"/><br>
    	 <label class="control-label" for="inputSuccess1"> 房间类型：</label>
    	<select class="form-control" name="roomTypeNo">
    		<c:forEach items="${roomTypes }" var="roomType">
    			<option value="${roomType.roomTypeNo }">${roomType.roomTypeDesc }</option>
    		</c:forEach>
    	</select><br>
    		<label class="control-label" for="inputSuccess1"> 房间楼层：</label>
    	<input class="form-control"type="text" name="floor"/><br>
    	    <label class="control-label" for="inputSuccess1"> 房间电话：</label>
    	<input class="form-control"type="text" name="phone"/><br>
    	    <label class="control-label" for="inputSuccess1"> 房间状态</label>
    	<input type="radio" name="status" value="0" checked="checked"/>可用
    	        <input type="radio" name="status" value="1"/>停用<br>
    	    <label class="control-label" for="inputSuccess1"> 备&nbsp;&nbsp;注：</label>
    	<br>&nbsp;&nbsp;&nbsp;&nbsp; 
    	<textarea class="form-control"rows="5px;" cols="30px;" name="comment"></textarea><br>
    	<input class="btn btn-default btn-lg" type="submit" style="text-align:center;"  value="添加"/>
    </form>
    </div></div></div>
  </body>
</html>
