<%@ page language="java" import="tp4.model.vo.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${room != null}">
	<form action="${checkinUrl}" method="POST">
		<input type="hidden" name="POST" />

		<div class="form-group">
			<label>房间号:</label> <input type="text" class="form-control"
				name="roomId" value="${room.roomId }" />
		</div>

		<div class="form-group">
			<label>用户类型</label> <select class="form-control" name="cusTypeNo">
				<c:forEach items="${cusTypes}" var="cusType">
					<option value="${cusType.cusTypeNo}">${cusType.cusTypeDesc}</option>
				</c:forEach>
			</select>
		</div>

		<div class="form-group">
			<label>客户名称:</label> <input type="text" class="form-control"
				name="name" />
		</div>

		<div class="form-group">
			<label>会员编号:</label> <input type="number" class="form-control"
				name="vipNo" />
		</div>

		<div class="form-group">
			<label>性别:</label> <select name="sex" class="form-control">
				<option value="男">男</option>
				<option value="女">女</option>
			</select>
		</div>

		<div class="form-group">
			<label>证件类型:</label> <select name="certType" class="form-control">
				<option value="身份证">身份证</option>
				<option value="军官证">军官证</option>
				<option value="护照">护照</option>
				<option value="其他">其他</option>
			</select>
		</div>

		<div class="form-group">
			<label>证件编号:</label> <input type="text" class="form-control"
				name="certNumber" />
		</div>

		<div class="form-group">
			<label>地址信息:</label> <input type="text" class="form-control"
				name="address" />
		</div>

		<div class="form-group">
			<label>备注:</label>
			<textarea class="form-control" name="comment"></textarea>
		</div>

		<div class="form-group">
			<label>计费方式:</label> <input type="radio" name="checkinType"
				value="<%=RoomType.NORMAL_ROOM%>" checked />标准 <input
				<c:if test="${!room.roomType.isHourRoom()}">disabled</c:if>
				type="radio" name="checkinType" value="<%=RoomType.HOUR_ROOM%>" />钟点
		</div>

		<div class="form-group">
			<label>预住天数:</label> <input type="number" class="form-control"
				name="numOfDays" />
		</div>

		<div class="form-group">
			<label>押金:</label> <input type="number" class="form-control"
				name="deposit" />
		</div>

		<div class="form-group">
			<button class="btn btn-primary" type="submit">提交</button>
		</div>
	</form>
</c:if>