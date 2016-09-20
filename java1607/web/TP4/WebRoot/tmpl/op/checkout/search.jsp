<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="nav nav-tabs">
	<li><a href="#byRoom" data-toggle="tab">结账单查询</a>
	</li>
	<li><a href="#byCus" data-toggle="tab">客户信息查询</a>
	</li>
</ul>

<div class="tab-content">
	<div class="tab-pane" id="byRoom">

		<form action="${servletUrl}" action="GET">
			<div class="form-group">
				<input type="hidden" name="byRoom">
			</div>

			<div class="form-group">
				<label>开始日期</label> <input class="form-control" type="date"
					name="start">
			</div>

			<div class="form-group">
				<label>结束日期</label> <input class="form-control" type="date"
					name="end">
			</div>

			<div class="form-group">
				<label>收费类型</label> <select class="form-control" name="chargeType">
					<option value="-1">全部</option>
					<c:forEach items="${chargeTypes}" var="chargeType">
						<option value="${chargeType.chargeTypeNo}">${chargeType.chargeTypeDesc}</option>
					</c:forEach>
				</select>
			</div>

			<div class="form-group">
				<c:forEach items="${roomTypes}" var="roomType">
					<label class="checkbox-inline"> <input type="checkbox"
						name="roomTypeNos" value="${roomType.roomTypeNo}">
						${roomType.roomTypeDesc} </label>
				</c:forEach>
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-default">查询</button>
			</div>
		</form>
	</div>

	<div class="tab-pane" id="byCus">
		<form id="byCus" action="${servletUrl}" action="GET">
			<div class="form-group">
				<input type="hidden" name="byCus">
			</div>

			<div class="form-group">
				<label>用户姓名</label> <input class="form-control" type="text"
					name="name">
			</div>

			<div class="form-group">
				<label>房间号</label> <input class="form-control" type="text"
					name="roomId">
			</div>

			<div class="form-group">
				<label>当前状态</label> <select class="form-control" name="status">
					<option value="0">全部</option>
					<option value="1">消费中</option>
					<option value="2">已结算</option>
				</select>
			</div>

			<div class="form-group">
				<label>用户类型</label> <select class="form-control" name="cusTypeNo">
					<c:forEach items="${cusTypes}" var="cusType">
						<option value="${cusType.cusTypeNo}">${cusType.cusTypeDesc}</option>
					</c:forEach>
				</select>
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-default">查询</button>
			</div>
		</form>
	</div>
</div>
