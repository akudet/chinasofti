<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<base href="<%=basePath%>">

<title>操作员管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>

	<%@include file="../../nav.jsp"%>

	<div class="col-sm-12 col-lg-10 sidebar">

		<%@include file="../admin-nav.jsp"%>

		<div class="panel">
			<div class="panel-heading">
				<%@ include file="search.jsp"%>
			</div>

			<div class="panel-body">
				<%@ include file="users.jsp"%>
			</div>
		</div>
	</div>
</body>
</html>
