<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@ include file="../include.jsp"%>
</head>
<body>

	<table>
		<thead>
			<th>产品编号</th>
			<th>产品名</th>
			<th>产品销量</th>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.sells}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>