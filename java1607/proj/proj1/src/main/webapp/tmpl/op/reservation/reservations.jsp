<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table">
	<tr>
		<th>客户名称</th>
		<th>联系电话</th>
		<th>预定房间类型</th>
		<th>预抵时间</th>
		<th>保留时间</th>
		<th>预定时间</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${reservations }" var="reservation">
		<tr>
			<td>${reservation.name }</td>
			<td>${reservation.phone }</td>
			<td>${reservation.room.roomType.roomTypeDesc }</td>
			<td>${reservation.arriveTime }</td>
			<td>${reservation.reserveTime }</td>
			<td>${reservation.reservationTime }</td>
			<td><a href="${editUrl}${reservation.reservationId }"><span
					class="glyphicon glyphicon-edit"></span></a> <a
				href="${deleteUrl}${reservation.reservationId}"><span
					class="glyphicon glyphicon-trash"></span></a></td>
		</tr>
	</c:forEach>
</table>