<%@ page language="java" import="java.util.*,tp4.servlet.admin.*"
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
<title>查找所有顾客折扣类型</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<%@ include file="/tmpl/include.jsp"%>
</head>

<body>

	<%@include file="../../nav.jsp"%>

	<div class="col-sm-12 col-lg-10 sidebar">

		<%@include file="../admin-nav.jsp"%>

		<div class="panel">
			<div class="panel-heading">
				<div class="col-md-2 text-left">
					<div class="form-group">
						<a class="btn btn-primary" href="${cusTypeUrl}/new"> <span
							class="glyphicon glyphicon-plus"></span>&nbsp;添加 </a>
					</div>
				</div>
			</div>

			<div class="panel-body">
				<%@ include file="cus_types.jsp"%>
			</div>
		</div>
	</div>
</body>
</html>
