<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${checkout != null}">
	<table class="table">
		<tr>
			<th>结账单号</th>
			<th>客户名称</th>
			<th>实收金额</th>
			<th>结账时间</th>
			<th>备注</th>
		</tr>
		<tr>
			<td>${checkout.checkoutId}</td>
			<td>${checkout.name}</td>
			<td>${checkout.checkoutAmount}</td>
			<td>${checkout.checkoutTime}</td>
			<td>${checkout.comment}</td>
		</tr>
	</table>
</c:if>