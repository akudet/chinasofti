<%@ page language="java" import="java.util.*,team4.proj1.model.vo.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<%@include file="../../include.jsp"%>
<title>修改操作员</title>

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
			<div class="panel-heading">修改用户</div>
			<div class="panel-body">
				<form method="POST" action="${userUrl}">
					<input type="hidden" name="PUT">
					<div class="form-group">
						<label>ID</label> <input class="form-control" type="text"
							name="userId" value="${user.userId } " />
					</div>

					<div class="form-group">
						<label>名字</label> <input class="form-control" type="text"
							name="userName" value="${user.userName }" />
					</div>

					<div class="form-group">
						<label>密码</label> <input class="form-control" type="text"
							name="userPass" value="${user.userPass } " />
					</div>

					<div class="form-group">
						<label>特权</label> <input class="form-control" type="text"
							name="privilege" value="${user.privilege }" />
					</div>

					<button class="btn btn-primary" type="submit">修改</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
