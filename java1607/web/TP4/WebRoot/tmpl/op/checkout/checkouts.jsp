<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${checkouts != null}">
	<table class="table">
		<tr>
			<th>结账单号</th>
			<th>房间类型</th>
			<th>房间号</th>
			<th>计费方式</th>
			<th>客户名称</th>
			<th>实收金额</th>
		</tr>
		<c:forEach items="${checkouts}" var="checkout">
			<tr>
				<td>${checkout.checkoutId}</td>
				<td>${checkout.roomTypeDesc}</td>
				<td>${checkout.roomId}</td>
				<td>${checkout.checkinType}</td>
				<td>${checkout.name}</td>
				<td>${checkout.checkoutAmount}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6">已结算客户人数之和：${checkouts.size()}</td>
		</tr>
		<c:if test="${totalAmount != null}">
			<tr>
				<td colspan="6">实收金额之和：${totalAmount}</td>
			</tr>
		</c:if>
	</table>
</c:if>