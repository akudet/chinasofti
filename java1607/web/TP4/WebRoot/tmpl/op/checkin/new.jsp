<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@ include file="/tmpl/include.jsp" %>
  </head>
  
  <body>
  	<%@include file="../../nav.jsp"%>
  	
  <div class="col-sm-12 col-lg-10 sidebar">
	<div class="panel panel-primary">
	 <div class="panel-heading">开设房间</div>
	 <div class="panel-body">
	 
  	<%@include file="search.jsp"%>
  	
  	<c:if test="${room != null}">
    <form action="/TP4/op/checkin/" method="POST">
    	<input type="hidden" name="POST"/>
    	
		<div class="form-group">
			<label for="exampalInputemail1">房间号:</label>
			<input type="text" class="form-control" style="font-size:large; " name="roomId" value="${room.roomId }"/><br>
		</div>
		<div class="form-group">
			<label for="exampalInputemail1">客户类型:</label>
			<select name="cusTypeNo" class="form-control">
				<option value="0" selected="selected">普通客户</option>
				<option value="1">会员</option>
				<option value="2">团体组织</option>
				<option value="3">内部人事</option>
				<option value="4">协议单位</option>
			</select><br>
		</div>
		<div class="form-group">
			<label for="exampalInputemail1">客户名称:</label>
			<input type="text" class="form-control" style="font-size:large; " name="name"/><br>
		</div>
		<div class="form-group">
			<label for="exampalInputemail1">会员编号:</label>
			<input type="text" class="form-control" style="font-size:large; " name="vipNo"/><br>
		</div>
		<div class="form-group">
			<label for="exampalInputemail1">性别:</label>
			<input type="text" class="form-control" style="font-size:large; " name="sex"/><br>
		</div>
		<div class="form-group">
			<label for="exampalInputemail1">证件类型:</label>
			<input type="text" class="form-control" style="font-size:large; " name="certType"/><br>
		</div>
		<div class="form-group">
			<label for="exampalInputemail1">证件编号:</label>
			<input type="text" class="form-control" style="font-size:large; " name="certNumber"/><br>
		</div>
		<div class="form-group">
			<label for="exampalInputemail1">地址信息:</label>
			<input type="text" class="form-control" style="font-size:large; " name="address"/><br>
		</div>
		<div class="form-group">
			<label for="exampalInputemail1">备注:</label>
			<input type="text" class="form-control" style="font-size:large; " name="comment"/><br>
		</div>
		<div class="form-group">
			<label for="exampalInputemail1">计费方式:</label>
			<input type="radio" name="checkinType" value="0" checked="checked"/>标准
			<input type="radio" name="checkinType" value="1"/>钟点<br>
		</div>
		<div class="form-group">
			<label for="exampalInputemail1">预住天数:</label>
			<input type="text" class="form-control" style="font-size:large; " name="numOfDays"/><br>
		</div>
		<div class="form-group">
			<label for="exampalInputemail1">押金:</label>
			<input type="text" class="form-control" style="font-size:large; " name="deposit"/><br>
		</div>
		<input type="submit" value="提交" style="height:30px;width:100px;text-algin:center;"/>
    </form>
    </c:if>
    </div>
    </div>
    </div>
  </body>
</html>
