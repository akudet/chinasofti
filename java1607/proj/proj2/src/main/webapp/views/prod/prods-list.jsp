<!-- listview of products -->
<!-- @param ${products} -->

<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="prods-list">
	<c:forEach items="${products}" var="prod">
		<div class="prods-list-item">
			<div class="prods-list-item-details">
				<table>
					<tr>
						<td>产品名称</td>
						<td>${prod.name}</td>
					</tr>
					<tr>
						<td>销量</td>
						<td>${prod.sells}</td>
					</tr>
					<tr>
						<td>上架日期</td>
						<td><fmt:formatDate value="${prod.onSaleTime}" pattern="yyyy年MM月dd日"/></td>
					</tr>
				</table>
			</div>
		</div>
	</c:forEach>
</div>
