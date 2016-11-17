<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="team4.proj1.control.servlet.op.*"%>

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
<link href="/TP4/modules/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">

<script src="/TP4/modules/jquery/jquery.min.js"></script>
<script src="/TP4/modules/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<%@include file="../../nav.jsp"%>

	<div class="col-sm-12 col-lg-10 sidebar">
		<div class="panel panel-primary">
			<div class="panel-heading">用户管理</div>

			<div class="row">
				<div class="col-md-12"></div>
			</div>
			<%@ include file="search.jsp"%>
			<div class="row">
				<div class="col-md-12"></div>
			</div>

			<div class="panel-body">
				<%@ include file="vips.jsp"%>
			</div>
		</div>
	</div>
</body>
</html>
