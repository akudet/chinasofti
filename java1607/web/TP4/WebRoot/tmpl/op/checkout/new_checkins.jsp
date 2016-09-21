<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${checkins != null}">
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
		<c:forEach items="${checkins }" var="checkin">
			<tr>
				<td>${checkin.checkinId}</td>
				<td>${checkin.roomTypeDesc}</td>
				<td>${checkin.roomId}</td>
				<td>${checkin.name}</td>
				<td>${checkin.price}</td>
				<td>${checkin.checkinTypeDesc}</td>
				<td>${checkin.checkinTime}</td>
				<td>${checkin.deposit}</td>
				<td><a href="${newUrl}${checkin.checkinId }">结帐</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>