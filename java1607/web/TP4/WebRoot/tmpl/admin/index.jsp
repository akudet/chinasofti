<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统管理</title>
</head>
<body>
	<%@include file="../nav.jsp" %>
	<div class="col-sm-12 col-lg-10 sidebar">
	<div class="panel panel-primary">
	<a href="${roomTypeUrl}">房间类型管理</a>
	<a href="${roomUrl}">房间信息管理</a>
	<a href="${cusTypeUrl}">客户类型折扣</a>
	<a href="${userUrl}">操作员管理</a>
	</div></div>
</body>
</html>