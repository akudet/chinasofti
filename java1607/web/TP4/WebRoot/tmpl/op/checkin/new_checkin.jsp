<%@ page language="java" import="java.util.*, tp4.model.vo.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${room != null}">
	<form action="${checkinUrl}" method="POST">
		<input type="hidden" name="POST" />

		<div class="form-group">
			<label>房间号:</label> <input type="text" class="form-control"
				name="roomId" value="${room.roomId }" /><br>
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
				name="name" /><br>
		</div>

		<div class="form-group">
			<label>会员编号:</label> <input type="number" class="form-control"
				name="vipNo" /><br>
		</div>

		<div class="form-group">
			<label>性别:</label> <input type="text" class="form-control" name="sex" /><br>
		</div>

		<div class="form-group">
			<label>证件类型:</label> <input type="text" class="form-control"
				name="certType" /><br>
		</div>

		<div class="form-group">
			<label>证件编号:</label> <input type="text" class="form-control"
				name="certNumber" /><br>
		</div>

		<div class="form-group">
			<label>地址信息:</label> <input type="text" class="form-control"
				name="address" /><br>
		</div>

		<div class="form-group">
			<label>备注:</label> <input type="text" class="form-control"
				name="comment" /><br>
		</div>

		<div class="form-group">
			<label>计费方式:</label> <input type="radio" name="checkinType" value="<%= RoomType.NORMAL_ROOM %>"
				checked="checked" />标准 <input type="radio" name="checkinType"
				value="<%= RoomType.HOUR_ROOM %>" />钟点<br>
		</div>

		<div class="form-group">
			<label>预住天数:</label> <input type="number" class="form-control"
				name="numOfDays" /><br>
		</div>

		<div class="form-group">
			<label>押金:</label> <input type="number" class="form-control"
				name="deposit" /><br>
		</div>

		<div class="form-group">
			<button class="btn btn-primary" type="submit">提交</button>
		</div>
	</form>
</c:if>