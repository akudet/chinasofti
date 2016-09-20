<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${checkouts != null}">
<c:if test="${totalAmount != null}">
	实收金额之和：${totalAmount}
</c:if>
<c:if test="${cusCount != null}">
	客户人数之和：${cusCount}
</c:if>
<table class="table">
	<tr>
		<th>结账单号</th>
		<th>房间类型</th>
		<th>房间号</th>
		<th>计费方式</th>
		<th>客户名称</th>
		<th>实收金额</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${checkouts}" var="checkout">
		<tr>
			<td>${checkout.checkoutId}</td>
			<td>${checkout.roomTypeDesc}</td>
			<td>${checkout.roomId}</td>
			<td>${checkout.checkinType}</td>
			<td>${checkout.name}</td>
			<td>${checkout.checkoutAmount}</td>
			<td>
				<a href="${deleteUrl}${checkout.checkoutId}">删除</a>
			</td>
		</tr>
	</c:forEach>
</table>
</c:if>