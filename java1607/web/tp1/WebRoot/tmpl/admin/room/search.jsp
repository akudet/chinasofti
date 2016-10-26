<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form class="form-inline" action="${roomUrl}" method="get">
	<div class="col-md-2 text-left">
		<div class="form-group">
			<a class="btn btn-primary" href="${roomUrl}/new"><i
				class="glyphicon glyphicon-plus"></i> 添加</a>
		</div>
	</div>

	<div class="col-md-10 text-right">
		<div class="form-group">
			<label>房间类型：</label> <select name="roomTypeNo" class="form-control">
				<c:forEach items="${roomTypes}" var="roomType">
					<option
						<c:if test="${roomType.roomTypeNo == param.roomTypeNo}">selected</c:if>
						value="${roomType.roomTypeNo }">${roomType.roomTypeDesc }</option>
				</c:forEach>
			</select>
		</div>

		<div class="form-group">
			<button class="btn btn-primary" type="submit">查询</a></button>
		</div>
	</div>
</form>

