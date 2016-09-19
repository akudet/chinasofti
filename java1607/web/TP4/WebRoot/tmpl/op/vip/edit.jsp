<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="tp4.servlet.op.*"%>

<%
String path = request.getContextPath();
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title>${vip.name}</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="/TP4/modules/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

<script src="/TP4/modules/jquery/jquery.min.js"></script>
<script src="/TP4/modules/bootstrap/js/bootstrap.min.js"></script>
  </head>
  
  <body>
  <%@include file="../../nav.jsp"%>
  <div class="col-sm-12 col-lg-10 sidebar">
	<div class="panel panel-primary">
	 <div class="panel-heading">会员修改</div>
	 <div class="panel-body">
  	 <form action="<%=path + VipServlet.SERVLET_URL%>" method="POST">
		<input type="hidden" name="PUT">

		<div class="form-group">
        <label  for="vipNo">会员编号：</label>
		<input class="form-control" type="number" name="vipNo" id="vipNo" value="${vip.vipNo}" disable><br> 
        </div>
		
        <div class="form-group">
        <label for="name">会员姓名：</label>
		<input class="form-control" type="text" name="name" id="name" value="${vip.name }"><br> 
        </div>
		
        <div class="form-group">
        <label for="sex">会员性别：</label> 
		<select class="form-control" type="text" name="sex" id="sex">
		<c:if test="${vip.sex.equals('男(men)')}">
		<option selected="selected" value="男(men)">男(men)</option>
		<option value="女(women)">女(women)</option>
		</c:if>
		<c:if test="${vip.sex.equals('女(women)')}">
		<option value="男(men)">男(men)</option>
		<option selected="selected" value="女(women)">女(women)</option>
		</c:if>
		</select>
        </div> 
		
        <div class="form-group">
        <label for="sex">证件编号：</label>
		<input class="form-control" type="text" name="certNo" id="certNo" value="${vip.certNo}"><br> 
        </div>
		 
        <div class="form-group">
        <label  for="phone">联系电话：</label>
		<input class="form-control" type="text" name="phone" id="phone" value="${vip.phone}"><br> 
        </div>
		
        <div class="form-group">
        <label  for="address">详细地址：</label>
		<input class="form-control" type="text" name="address" id="address" value="${vip.address}"><br> 
        </div>
		
        <div class="form-group">
        <label  for="comment">备注：</label>
		<input class="form-control" type="text" name="comment" id="comment" value="${vip.comment}"><br> 
        </div> 
		
        <div class="form-group">
        <label  for="submit"></label>
		<input class="col-lg-3" type="submit" name="submit" id="submit" value="提交"><br> 
        </div>
	 </form>
	 </div>
	 </div>
	 </div>
  </body>
</html>
