<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${rooms != null}">
	<table class="table">
		<tr>
			<th>房间号</th>
			<th>房间类型</th>
			<th>房间区域</th>
			<th>房间电话</th>
			<th>房间状态</th>
			<th>房间备注</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${rooms }" var="room">
			<tr>
				<td>${room.roomId }</td>
				<td>${room.roomType.roomTypeDesc }</td>
				<td>${room.floor }</td>
				<td>${room.phone }</td>
				<td>${room.statusDesc }</td>
				<td>${room.comment }</td>
				<td><a href="${editUrl}${room.roomId}"><span
						class="glyphicon glyphicon-edit"></span> </a> &nbsp;&nbsp; <a
					href="${deleteUrl}${room.roomId}"
					onClick="return confirm('确定删除?');"><span
						class="glyphicon glyphicon-trash"></span> </a>
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
