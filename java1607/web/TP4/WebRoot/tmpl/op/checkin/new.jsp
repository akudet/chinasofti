<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>登记</title>
</head>

<body>
	<%@include file="../../nav.jsp"%>

	<div class="col-sm-12 col-lg-10 sidebar">
		<%@ include file="checkin-nav.jsp"%>

		<div class="panel panel-primary">
			<div class="panel-heading">登记</div>
			<div class="panel-body">

				<%@ include file="new_search.jsp"%>
				<%@ include file="new_checkin.jsp" %>
				
			</div>
		</div>
	</div>
</body>
</html>
