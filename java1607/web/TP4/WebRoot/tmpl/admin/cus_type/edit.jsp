<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>通过客户类型修改客户信息</title>
    
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
	
    <form action="/TP4/admin/cus_type/" method="post">
    <input type="hidden" name="PUT">
		<label for="exampleInputEmail1">客户类型编号:</label>
		<input style="font-size:large;" class="form-control" type="number" id="cus_type_no" name="cusTypeNo" value="${cusType.cusTypeNo}" readonly><br>
		<label for="exampleInputEmail1">客户类型:</label>
		<input style="font-size:large;" class="form-control" type="text" id="cus_type_desc" name="cusTypeDesc" value="${cusType.cusTypeDesc }"><br>
		<label for="exampleInputEmail1">折扣类型:</label>
		<input style="font-size:large;" class="form-control" type="number" id="discount" name="discount" value="${cusType.discount}"><br>
		<input type="submit" value="修改" style="height: 30px;width: 100px;text-align: center;">
	</form>
    </div></div>
  </body>
</html>
