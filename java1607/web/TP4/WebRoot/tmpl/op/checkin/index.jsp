<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>

</head>

<body>
	<%@include file="../../nav.jsp"%>
	
	<div class="col-sm-12 col-lg-10 sidebar">
		<div class="panel panel-primary">
			<div class="panel-heading">会员信息</div>
			<div class="panel-body">
				<%@ include file="checkins.jsp"%>
			</div>
		</div>
	</div>
</body>
</html>
