<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="tp4.servlet.op.*"%>
<%
	String path = request.getContextPath();
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<base href="http://localhost:8080/TP4/">

<title>会员管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="/TP4/modules/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

<script src="/TP4/modules/jquery/jquery.min.js"></script>
<script src="/TP4/modules/bootstrap/js/bootstrap.min.js"></script>

</head>

<body>
<%@include file="../../nav.jsp"%>
	<form action="<%=path + VipServlet.SERVLET_URL%>" method="POST">
		<input type="hidden" name="POST" >	
        <div>
        <label  for="vipNo">会员编号：</label>
		<input class="form-control" type="number" name="vipNo" id="vipNo"><br> 
        </div>
		
        <div>
        <label for="name">会员姓名：</label>
		<input class="form-control" type="text" name="name" id="name"><br> 
        </div>
		
        <div>
        <label for="sex">会员性别：</label>
		<select class="form-control" type="text" name="sex" id="sex">
		<option selected="selected">男(men)</option>
		<option>女(women)</option>
		</select>
        </div> 
		
        <div>
        <label for="sex">证件编号：</label>
		<input class="form-control" type="text" name="certNo" id="certNo"><br> 
        </div>
		 
        <div>
        <label  for="phone">联系电话：</label>
		<input class="form-control" type="text" name="phone" id="phone"><br> 
        </div>
		
        <div>
        <label  for="address">详细地址：</label>
		<input class="form-control" type="text" name="address" id="address"><br> 
        </div>
		
        <div>
        <label  for="comment">备注：</label>
		<input class="form-control" type="text" name="comment" id="comment"><br> 
        </div> 
		
       
        <label  for="submit"></label>
		<input class="form-control" type="submit" name="submit" id="submit" value="提交"><br> 
       
    </form>
</body>
</html>
