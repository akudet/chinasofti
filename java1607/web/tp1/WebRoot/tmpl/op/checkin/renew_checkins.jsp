<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${checkins != null}">
<table class="table">
	<tr>
		<th>入住单号</th>
		<th>房间号</th>
		<th>房间类型</th>
		<th>计费方式</th>
		<th>客户姓名</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${checkins}" var="checkin">
		<tr>
			<td>${checkin.checkinId}</td>
			<td>${checkin.room.roomId }</td>
			<td>${checkin.room.roomType.roomTypeDesc }</td>
			<td>${checkin.checkinTypeDesc }</td>
			<td>${checkin.cusInfo.name }</td>
			<td><a href="${renewUrl}${checkin.checkinId}">续住</a></td>
		</tr>
	</c:forEach>
</table>
</c:if>
