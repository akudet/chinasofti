<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>新增操作员</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<script type="text/javascript">
	function reg() {
		var name = document.getElementById('name').value;
		var pass = document.getElementById('pass').value;

		if (name.length == 0) {
			alert("账号不能为空");
			return false;
		} else if (pass.length == 0) {
			alert("密码不能为空");
			return false;
		} else {
			form.submit();
		}
	}

	function changpass() {
		var pass1 = document.getElementById('pass').value;
		var pass2 = document.getElementById('pass1').value;

		if (pass1 === pass2) {
			document.getElementById('sp').innerHTML = "输入一致";
		} else {
			document.getElementById('sp').innerHTML = "输入不一致";
		}
	}
</script>

<body>
	<%@include file="../../nav.jsp"%>

	<div class="col-sm-12 col-lg-10 sidebar">
		<%@include file="../admin-nav.jsp"%>
		<div class="panel">
			<div class="panel-heading">添加用户</div>
			<div class="panel-body">
				<form action="${userUrl}" method="post" onsubmit="reg()">

					<div class="form-group">
						<label>姓名</label> <input type="text" name="username" id="name"
							onblur="regavalidate()" class="form-control"><span
							id="sp"></span>
					</div>

					<div class="form-group">
						<label>密码</label> <input type="password" name="userpass" id="pass"
							class="form-control"><span id="sp"></span>
					</div>

					<div class="form-group">
						<label>确认密码</label> <input type="password" name="userpass"
							id="pass1" onblur="changpass()" class="form-control">
					</div>

					<div class="form-group">
						<label>特权</label> <input type="text" name="privilege"
							class="form-control">
					</div>

					<div class="form-group">
						<button class="btn btn-primary" type="submit">添加</button>
					</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>
