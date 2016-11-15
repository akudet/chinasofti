<%@ page language="java" import="java.util.*,tp1.servlet.*"
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

<title>操作员登录</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<%@ include file="include.jsp"%>

</head>

<body class="bg-info">
	<div class="col-lg-4">
		${requestScope.msg}
		<form action="${servletUrl}" method="post" role="form">
			<div class="form-group">
				<h3 class=" lead">请登录</h3>
			</div>
			<div style="margin:0;padding:0;height:2px;background-color:#CCC"></div>
			<div class="form-group">
				<label for="username">用户名:</label> <input class=" form-control"
					type="text" name="username" id="username" placeholder="username">
			</div>
			<div class="form-group">
				<label for="userpass">密&nbsp;码:</label> <input class="form-control"
					type="password" name="userpass" id="userpass"
					placeholder="userpass">
			</div>
			<div class="form-group">
				<button class="btn btn-primary" type="submit">登录</button>
				<button class="btn btn-primary" type="reset">重置</button>
			</div>
		</form>
	</div>
</body>
</html>
