<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="nav nav-tabs">
  <li class="active">
  	<a href="#byRoom" data-toggle="tab">结账单查询</a>
  </li>
  <li>
  	<a href="#byCus" data-toggle="tab">客户信息查询</a>
  </li>
</ul>
<div class="tab-content">
<div class="tab-pane active in" id="byRoom">

<form action="${servletUrl}" action="GET">
	<input type="hidden" name="byRoom">

	<div class="form-group">
		<label>开始日期</label>
		<input class="form-control" type="date" name="start">
	</div>
	<div class="form-group">
		<label>结束日期</label> 
		 <input class="form-control" type="date" name="end">
	</div>

	<div class="form-group">
		<label>收费类型</label>
		<select class="form-control" name="chargeType">
			<option value="-1">全部</option>
			<c:forEach items="${chargeTypes}" var="chargeType">
				<option value="${chargeType.chargeTypeNo}">${chargeType.chargeTypeDesc}</option>
			</c:forEach>
		</select>
	</div>
	
	<c:forEach items="${roomTypes}" var="roomType">
		<label class="checkbox-inline">
			<input type="checkbox" name="roomTypeNos" value="${roomType.roomTypeNo}">
			${roomType.roomTypeDesc}	
		</label>
    </c:forEach>

	<button type="submit" class="btn btn-default">查询</button>
	
</form>
</div>

<div class="tab-pane fade" id="byCus">
<form id="byCus" action="${servletUrl}" action="GET">
	<input type="hidden" name="byCus">
	<div class="form-group">
		<label>用户姓名</label>
		<input class="form-control" type="text" name="name">
	</div>

	<div class="form-group">
	 	<label>房间号</label>
	 	<input class="form-control" type="text" name="roomId">
	 </div>	
	 
	 <select class="form-control" name="cusTypeNo">
		<c:forEach items="${cusTypes}" var="cusType">
			<option value="${cusType.cusTypeNo}">${cusType.cusTypeDesc}</option>
		</c:forEach>
	</select>
	
	<button type="submit" class="btn btn-default">查询</button>
</form>
</div>
</div>
