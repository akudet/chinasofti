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
	<%@include file="../admin-nav.jsp"%>
	<div class="panel">
	<div class="panel-heading">修改用户</div>
			<div class="panel-body">
    <form action="/TP4/admin/cus_type/" method="post">
    <input type="hidden" name="PUT">
		<div>
			<label for="cus_type_no">客户类型编号:</label>
			<input type="number" id="cus_type_no" name="cusTypeNo" value="${cusType.cusTypeNo}" readonly="readonly"/><br>
		</div>
		<div>
			<label for="cus_type_desc">客户类型:</label>
			<input type="text" id="cus_type_desc" name="cusTypeDesc" value="${cusType.cusTypeDesc }" readonly="readonly"/><br>
		</div>
		<div>
			<label for="discount">折扣类型:</label>
			<input type="number" id="discount" name="discount" value="${cusType.discount}"/><br>
		</div>
		<button type="submit">修改</button>
	</form>
    </div></div></div>
  </body>
</html>
