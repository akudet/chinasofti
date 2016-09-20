<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${checkins != null}">
	<table class="table">
		<tr>
			<th>入住单号</th>
			<th>房间类型</th>
			<th>房间号</th>
			<th>计费方式</th>
			<th>客户名称</th>
			<th>押金</th>
		</tr>
		<c:forEach items="${checkins}" var="checkin">
			<tr>
				<td>${checkin.checkinId}</td>
				<td>${checkin.roomTypeDesc}</td>
				<td>${checkin.roomId}</td>
				<td>${checkin.checkinType}</td>
				<td>${checkin.name}</td>
				<td>${checkin.deposit}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6">未结算客户人数之和：${checkins.size()}</td>
		</tr>
	</table>
</c:if>