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

				<c:if test="${checkin != null}">
					<table class="table">
						<tr>
							<th>入住单号</th>
							<th>房间类型</th>
							<th>房间号</th>
							<th>客户名称</th>
							<th>单价</th>
							<th>计费方式</th>
							<th>入住时间</th>
							<th>押金</th>
						</tr>
						<tr>
							<td>${checkin.checkinId}</td>
							<td>${checkin.roomTypeDesc}</td>
							<td>${checkin.roomId}</td>
							<td>${checkin.name}</td>
							<td>${checkin.price}</td>
							<td>${checkin.checkinType}</td>
							<td>${checkin.checkinTime}</td>
							<td>${checkin.deposit}</td>
						</tr>
					</table>

					<form action="${servletUrl}" method="POST">
						<input type="hidden" name="checkinId" value="${checkin.checkinId}">
						<div class="form-group">
							<label>实收金额</label> <input class="form-control" type="number"
								name="amount">
						</div>

						<div class="form-group">
							<label>备注</label>
							<textarea class="form-control" name="comment"></textarea>
						</div>

						<div class="form-group">
							<button type="submit" class="btn btn-primary">结账</button>
						</div>
					</form>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>
