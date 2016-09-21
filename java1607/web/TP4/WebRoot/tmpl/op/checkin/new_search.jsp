<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="${searchUrl}" method="get">
	<input type="hidden" name="byRoom">
	<div class="form-group">
		<label>房间类型</label> <select name="roomTypeNo" class="form-control">
			<c:forEach items="${roomTypes}" var="roomType">
				<option
					<c:if test="${roomType.roomTypeNo == param.roomTypeNo}">selected</c:if>
					<c:if test="${roomType.roomTypeNo == room.roomTypeNo}">selected</c:if>
					value="${roomType.roomTypeNo }">${roomType.roomTypeDesc }</option>
			</c:forEach>
		</select>
	</div>

	<div class="form-group">
		<button class="btn btn-primary" type="submit">提交</button>
	</div>
</form>
<c:if test="${rooms != null}">
	<table class="table">
		<tr>
			<th>房间号</th>
			<th>房间类型</th>
			<th>房间区域</th>
			<th>房间价格</th>
			<th>能否开钟点房</th>
			<th>钟点房价格</th>
			<th>房间状态</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${rooms }" var="room">
			<tr>
				<td>${room.roomId }</td>
				<td>${room.roomType.roomTypeDesc }</td>
				<td>${room.floor }</td>
				<td>${room.price }</td>
				<c:if test="${!room.isHourRoom()}">
					<td>否</td>
					<td></td>
				</c:if>
				<c:if test="${room.isHourRoom()}">
					<td>是</td>
					<td>${room.hourRoomPrice}</td>
				</c:if>
				<td>${room.statusDesc }</td>
				<td><a href="${newUrl}${room.roomId}">开房</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
