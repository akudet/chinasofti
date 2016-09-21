<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="${checkinUrl}/new" method="get">
	<input type="hidden" name="findRooms">
	
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

