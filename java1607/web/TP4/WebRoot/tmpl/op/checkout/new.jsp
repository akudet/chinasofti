<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- @author 巫金桐 --%>

<!DOCTYPE HTML>
<html>
<head>
<title>客户结账</title>
</head>
<body>
	<%@ include file="../../nav.jsp"%>
	<div class="col-sm-12 col-lg-10 sidebar">

		<div class="panel panel-primary">
			<div class="panel-heading">客户结账</div>
			<div class="panel-body">

				<%@ include file="search_by_room.jsp"%>
				<%@ include file="checkins.jsp"%>
				<%@ include file="checkin.jsp"%>

			</div>
		</div>
	</div>
</body>
</html>
