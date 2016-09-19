<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'checkout.jsp' starting page</title>

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
		<div class="panel panel-primary">
			<div class="panel-heading">结账结果</div>
			<div class="panel-body">
				<%@ include file="checkout.jsp"%>
				找零:${change}
			</div>
		</div>
	</div>
</body>
</html>
