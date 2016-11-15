<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${checkin != null}">
	<form action="${checkinUrl}" method="POST">
		<input type="hidden" name="PUT">
		<input type="hidden" name="edit">
		
		<div class="form-group">
			<label for="exampleInputEmail1">预定单号:</label> <input type="text"
				class="form-control" style="font-size:large; " readonly="readonly"
				name="checkinId" value="${checkin.checkinId}" />
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">房间类型:</label> <input type="text"
				class="form-control" style="font-size:large; " readonly="readonly"
				name="roomTypeDesc" value="${checkin.roomTypeDesc }" />
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">房间号:</label> <input type="text"
				class="form-control" style="font-size:large; " readonly="readonly"
				name="roomId" value="${checkin.roomId }" />
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">客户类型:</label> <input type="text"
				class="form-control" style="font-size:large; " readonly="readonly"
				name="cusTypeNo" value="${checkin.cusTypeDesc }" />
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">客户名称:</label> <input type="text"
				class="form-control" style="font-size:large; " readonly="readonly"
				name="name" value="${checkin.name }" />
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">性别:</label> <input type="text"
				class="form-control" style="font-size:large; " readonly="readonly"
				name="sex" value="${checkin.sex }" />
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">证件类型:</label> <input type="text"
				class="form-control" style="font-size:large; " readonly="readonly"
				name="certType" value="${checkin.certType }" />
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">证件编号:</label> <input type="text"
				class="form-control" style="font-size:large; " name="certNumber"
				value="${checkin.certNumber }" />
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">地址信息:</label> <input type="text"
				class="form-control" style="font-size:large; " name="address"
				value="${checkin.address }" />
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">备注:</label> <input type="text"
				class="form-control" style="font-size:large; " name="comment"
				value="${checkin.comment }" />
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">计费方式:</label> <input type="text"
				class="form-control" style="font-size:large; " readonly="readonly"
				name="checkinType" value="${checkin.checkinTypeDesc }" />

		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">预住天数:</label> <input type="text"
				class="form-control" style="font-size:large; " readonly="readonly"
				name="numOfDays" value="${checkin.numOfDays }" />
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">押金:</label> <input type="text"
				class="form-control" style="font-size:large; " readonly="readonly"
				name="deposit" value="${checkin.deposit }" />
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">续住天数:</label> <input type="text"
				value="${checkin.numOfDays }" disabled class="form-control"
				style="font-size:large; " name="reNumOfDays">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">续交押金:</label> <input type="text"
				disabled class="form-control" style="font-size:large; "
				name="reDeposit" value="${checkin.deposit }" />
		</div>
		<div class="form-group">
			<button class="btn btn-primary" type="submit">修改</button>
		</div>
	</form>
</c:if>
