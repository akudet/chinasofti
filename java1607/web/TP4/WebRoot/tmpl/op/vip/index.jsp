<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="tp4.servlet.op.*"%>

<%
	String path = request.getContextPath();
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>

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
	 <div class="panel-heading">会员信息</div>
	 <div class="panel-body">
	 
<div class="btn-toolbar">
    <a class="btn btn-primary" href="<%= path + VipServlet.SERVLET_URL%>/new"><i class="glyphicon glyphicon-plus"></i> 添加</a>
</div>
<p></p>
<form action="${servletUrl}" action="GET">
	<input type="text" name="vipNo">
	    <button class="btn btn-primary" type="submit"><i class="glyphicon glyphicon-search"></i>按vip编号查询</button>
	</form>
<form action="${servletUrl}" action="GET">
	<input type="text" name="name">
	    <button class="btn btn-primary" type="submit"><i class="glyphicon glyphicon-search"></i>按vip姓名查询</button>
	</form>
	  <table class="table-striped table-bordered table">
		<tr class="active">
			<th>会员编号</th>
			<th>会员姓名</th>
			<th>性别</th>
			<th>身份证号</th>
			<th>联系电话</th>
			<th>详细地址</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${vips}" var="vip">
			<tr>
				<td>${vip.vipNo}</td>
				<td>${vip.name}</td>
				<td>${vip.sex}</td>
				<td>${vip.certNo}</td>
				<td>${vip.phone}</td>
				<td>${vip.address}</td>
				<td class="info">
					<a href="<%= path + VipServlet.SERVLET_URL + "/edit?vipNo=" %>${vip.vipNo}"><span class="glyphicon glyphicon-edit"></span></a>
					&nbsp;&nbsp;<a href="<%= path + VipServlet.SERVLET_URL + "?DELETE=&&vipNo=" %>${vip.vipNo}"><span class="glyphicon glyphicon-trash"></span></a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	</div>
	</div>
	</div>
</body>
</html>
