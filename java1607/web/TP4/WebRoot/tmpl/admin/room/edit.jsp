<%@ page language="java" import="java.util.*,tp4.model.vo.*" pageEncoding="UTF-8"%>
<%--@作者：项双江 --%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  <%@ include file="/tmpl/include.jsp" %>
  </head>
  
  <body>
    <form action="/TP4/admin/room/" method="POST">
    <input type="hidden" name="PUT">
      <label for="exampleInputEmail1">房间号：</label> 
    	&nbsp;<input class="form-control" type="text" name="roomId" readonly="readonly" value="${room.roomId }"/><br>
      <label for="exampleInputEmail1">房间类型：</label> 
    	<select class="form-control" name="roomTypeNo">
    	<c:forEach items="${roomTypes}" var="roomType">
    		<option <c:if test="${room.roomType.roomTypeNo==roomType.roomTypeNo}">selected</c:if> value="${roomType.roomTypeNo}">${roomType.roomTypeDesc}</option>
    	</c:forEach>
    	</select><br>
      <label for="exampleInputEmail1">房间楼层：</label> 
    	<input class="form-control"type="text" name="floor" value="${room.floor }"/><br>
      <label for="exampleInputEmail1">房间电话：</label> 
    	<input class="form-control"type="text" name="phone" value="${room.phone }"/><br>
      <label for="exampleInputEmail1">房间状态：</label> 
    	<input type="radio" name="status" value="${room.status }" checked="checked"/><label for="exampleInputEmail1">可用</label>
        <input type="radio" name="status" value="${room.status }"/><label for="exampleInputEmail1">停用</label><br>
      <label for="exampleInputEmail1">备&nbsp;&nbsp;注：</label> 
    	<textarea class="form-control"type="text" name="comment" value="${room.comment }"></textarea><br>
    	<input type="submit" value="修改"style="height: 30px;width: 100px;text-align: center;"/>
    </form>
  </body>
</html>
