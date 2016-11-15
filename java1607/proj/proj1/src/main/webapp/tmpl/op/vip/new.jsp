<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="team4.proj1.servlet.op.*"%>
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
<div class="col-sm-12 col-lg-10 sidebar">
	<div class="panel panel-primary">
	 <div class="panel-heading">会员添加</div>
	 <div class="panel-body">
	<form action="<%=path + VipServlet.SERVLET_URL%>" method="POST">
		<input type="hidden" name="POST">
        <div class="form-group">
        <label  for="vipNo">会员编号：</label>
		<input class="form-control" type="number" name="vipNo" id="vipNo"> 
        </div>
		
        <div class="form-group">
        <label for="name">会员姓名：</label>
		<input class="form-control" type="text" name="name" id="name"> 
        </div>
		
        <div class="form-group">
        <label for="sex">会员性别：</label>
		<select class="form-control" name="sex" id="sex">
		<option selected="selected">男</option>
		<option>女</option>
		</select>
        </div> 
		
        <div class="form-group">
        <label for="sex">证件编号：</label>
		<input class="form-control" type="text" name="certNo" id="certNo"> 
        </div>
		 
        <div class="form-group">
        <label  for="phone">联系电话：</label>
		<input class="form-control" type="text" name="phone" id="phone"> 
        </div>
		
        <div class="form-group">
        <label  for="address">详细地址：</label>
		<input class="form-control" type="text" name="address" id="address"> 
        </div>
		
        <div class="form-group">
        <label  for="comment">备注：</label>
		<textarea rows="3" class="form-control" name="comment" id="comment"></textarea> 
        </div> 
		
       
       <div class="form-group">
		<button class="btn btn-primary" type="submit">提交</button>
       </div>
    </form>
    </div>
    </div>
    </div>
</body>
</html>
