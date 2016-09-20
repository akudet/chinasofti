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
<%@ include file="/tmpl/include.jsp" %>
</head>
	<script>
	
		
		
		function setEnable() {
			$("#hourRoomPrice").attr("disabled",false);
		}
		function setDisabled(){
			$("#hourRoomPrice").attr("disabled",true);
		}
	</script>
<body>
	<%@include file="../../nav.jsp"%>
	<div class="col-sm-12 col-lg-10 sidebar">
	<%@include file="../admin-nav.jsp"%>
	<div class="panel">
	<div class="panel-heading">修改用户</div>
			<div class="panel-body">
	<form action="/TP4/admin/room_type" method="POST">
	
		<input type="hidden" name="PUT"> 
		 <label for="exampleInputEmail1">房间类型编号:</label>
		<input style="font-size:large;"class="form-control" type="text" id="room_type_no" name="room_type_no" value="${roomType.roomTypeNo}" disabled="disabled"><br>
		
		<label for="exampleInputEmail1">房间类型:</label> 
		<input style="font-size:large;" class="form-control"type="text" name="room_type_desc" value="${roomType.roomTypeDesc}"> 
		<br><label for="exampleInputEmail1">床位数:</label> 
		 <input style="font-size:large;" class="form-control"  type="text" id="room_beds" name="beds"value="${roomType.beds}">
		<br><label for="exampleInputEmail1"> 单价:</label>
		 <input style="font-size:large;" class="form-control"  type="text" id="room_beds" name="price"value="${roomType.price}">
		
		<c:if test="${roomType.isHourRoom==0}">
		<br><label for="exampleInputEmail1">是否可开钟点房:</label>
         <input  onclick="setEnable();" type="radio" name="isHourRoom" value="true"checked /> 
          <label for="exampleInputEmail1">是</label>
         <input onclick="setDisabled();" type="radio" name="isHourRoom" value="false"  />
         <label for="exampleInputEmail1" >否</label><br>
			
		</c:if>
		<c:if test="${roomType.isHourRoom==1}">
		 <label for="exampleInputEmail1">   是否可开钟点房:</label>
			<input  onclick="setEnable();" type="radio" name="isHourRoom" value="true" /> 
			 <label for="exampleInputEmail1">是</label>
            <input  onclick="setDisabled();" type="radio" name="isHourRoom" value="false"  checked /> 
             <label for="exampleInputEmail1">否</label><br>
		</c:if>
		<br><label for="exampleInputEmail1">钟点房价格:</label>
		 <input id="hourRoomPrice" style="font-size:large;" class="form-control"  type="text" name="hourRoomPrice"value="${roomType.hourRoomPrice}" ><br>
		<br> <label for="exampleInputEmail1">备注：</label> <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<textarea style="font-size:large;left: 20px" class="form-control"  rows="5" cols="50" name="comment" value="${roomType.comment}"></textarea>
		<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit"value="修改" style="height: 30px;width: 100px;text-align: center;">
	</form>
	
	</div></div></div>
</body>
</html>
