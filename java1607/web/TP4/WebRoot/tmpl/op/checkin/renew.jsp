<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>客户续住</title>
</head>

<body>
	<%@ include file="../../nav.jsp"%>

	<div class="col-sm-12 col-lg-10 sidebar">
		<%@ include file="checkin-nav.jsp"%>

		<div class="panel panel-primary">
			<div class="panel-heading">客户续住</div>
			<div class="panel-body">
				<%@ include file="renew_checkins.jsp"%>
				<%@ include file="renew_checkin.jsp"%>
			</div>
		</div>
	</div>
</body>
</html>
