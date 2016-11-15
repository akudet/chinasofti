<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${roomTypes != null}">
	<table class="table">
		<tr>
			<th>房间类型编号</th>
			<th>房间类型</th>
			<th>床位数</th>
			<th>单价</th>
			<th>是否开钟点房</th>
			<th>钟点房价格</th>
			<th>备注</th>
			<th>操作</th>

		</tr>
		<c:forEach items="${roomTypes}" var="roomType">
			<tr>

				<td>${roomType.roomTypeNo}</td>
				<td>${roomType.roomTypeDesc}</td>
				<td>${roomType.beds}</td>
				<td>${roomType.price}</td>

				<c:if test="${roomType.isHourRoom  == 1}">
					<td>否</td>
				</c:if>
				<c:if test="${roomType.isHourRoom  == 0}">
					<td>是</td>
				</c:if>
				<td>${roomType.hourRoomPrice}</td>
				<td>${roomType.comment}</td>

				<td><a
					href="${roomTypeUrl}/edit?roomTypeNo=${roomType.roomTypeNo}"><span
						class="glyphicon glyphicon-edit"></span> </a> &nbsp;&nbsp; <a
					href="${roomTypeUrl}?DELETE=&&roomTypeNo=${roomType.roomTypeNo}"><span
						class="glyphicon glyphicon-trash"></span> </a>
				</td>
			</tr>

		</c:forEach>

	</table>
</c:if>
