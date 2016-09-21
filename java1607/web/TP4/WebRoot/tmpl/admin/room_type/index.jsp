<%@ page language="java"
	import="java.util.*,tp4.model.vo.*,tp4.servlet.admin.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<%@include file="../../include.jsp"%>
</head>

<body>
	<%@include file="../../nav.jsp"%>

	<div class="col-sm-12 col-lg-10 sidebar">

		<%@include file="../admin-nav.jsp"%>

		<div class="panel">
			<div class="panel-heading">
				<div class="col-md-2 text-left">
					<div class="form-group">
						<a class="btn btn-primary" href="${roomTypeUrl}/new"> <span
							class="glyphicon glyphicon-plus"></span>&nbsp;添加 </a>
					</div>
				</div>
			</div>

			<div class="panel-body">
				<%@ include file="room_types.jsp"%>
			</div>
		</div>
	</div>
</body>
</html>
