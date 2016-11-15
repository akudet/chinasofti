<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
<title>房间类型管理</title>
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
							class="glyphicon glyphicon-plus"></span>&nbsp;添加
						</a>
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
