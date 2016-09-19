<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<%@ include file="/tmpl/include.jsp" %>
  </head>
  
  <body>
  <%@include file="../../nav.jsp"%>
    <form action="/TP4/op/checkin/" method="POST">
    <input type="hidden" name="PUT">
    	<div class="form-group">
    		<label for="exampleInputEmail1">预定单号:</label>
    		<input type="text" class="form-control" style="font-size:large; " readonly="readonly" name="checkinId" value="${checkin.checkinId}"/><br>
    	</div>
    	<div class="form-group">
    	    <label for="exampleInputEmail1">房间类型:</label>
    		<input type="text" class="form-control" style="font-size:large; " readonly="readonly" name="roomTypeDesc" value="${checkin.roomTypeDesc }" /><br>	
    	</div>
		<div class="form-group">
    		<label for="exampleInputEmail1">房间号:</label>
			<input type="text" class="form-control" style="font-size:large; " readonly="readonly" name="roomId" value="${checkin.roomId }" /><br>		
    	</div>
		<div class="form-group">
			<label for="exampleInputEmail1">客户类型:</label>
			<input type="text" class="form-control" style="font-size:large; " readonly="readonly" name="cusTypeNo" value="${checkin.cusTypeDesc }"/><br>		
    	</div>
		<div class="form-group">
			<label for="exampleInputEmail1">客户名称:</label>
			<input type="text" class="form-control" style="font-size:large; " readonly="readonly" name="name" value="${checkin.name }"/><br>	
    	</div>
		<div class="form-group">
			<label for="exampleInputEmail1">性别:</label>
			<input type="text" class="form-control" style="font-size:large; " readonly="readonly" name="sex" value="${checkin.sex }"/><br>	
    	</div>
		<div class="form-group">
			<label for="exampleInputEmail1">证件类型:</label>
			<input type="text" class="form-control" style="font-size:large; " readonly="readonly" name="certType" value="${checkin.certType }"/><br>	
    	</div>
		<div class="form-group">
			<label for="exampleInputEmail1">证件编号:</label>
			<input type="text" class="form-control" style="font-size:large; " name="certNumber" value="${checkin.certNumber }"/><br>	
    	</div>
		<div class="form-group">
			<label for="exampleInputEmail1">地址信息:</label>
			<input type="text" class="form-control" style="font-size:large; " name="address" value="${checkin.address }"/><br>	
    	</div>
		<div class="form-group">
			<label for="exampleInputEmail1">备注:</label>
			<input type="text" class="form-control" style="font-size:large; " name="comment" value="${checkin.comment }"/><br>		
    	</div>
		<div class="form-group">
			<label for="exampleInputEmail1">计费方式:</label>
			<input type="text" class="form-control" style="font-size:large; " readonly="readonly" name="checkinType" value="${checkin.checkinType }"/><br>
		
    	</div>
		<div class="form-group">
			<label for="exampleInputEmail1">预住天数:</label>
			<input type="text" class="form-control" style="font-size:large; " readonly="readonly" name="numOfDays" value="${checkin.numOfDays }"/><br>		
    	</div>
		<div class="form-group">
			<label for="exampleInputEmail1">押金:</label>
			<input type="text" class="form-control" style="font-size:large; " readonly="readonly" name="deposit" value="${checkin.deposit }"/><br>		
    	</div>
		<input type="submit" value="修改" style="height: 30px;width:100px;text-align: center; "/>
    </form>
  </body>
</html>
