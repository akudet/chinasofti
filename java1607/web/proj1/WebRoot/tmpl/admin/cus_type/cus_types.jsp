<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="table">
	<tr>
		<th>客户类型编号</th>
		<th>客户类型</th>
		<th>打折比例</th>
		<th>操 作</th>
	</tr>
	<c:forEach items="${cusTypes}" var="cusType">
		<tr>
			<td>${cusType.cusTypeNo}</td>
			<td>${cusType.cusTypeDesc}</td>
			<td>${cusType.discount}</td>
			<td><a href="${cusTypeUrl}/edit?cusTypeNo=${cusType.cusTypeNo}"><span
					class="glyphicon glyphicon-edit"></span> </a> &nbsp;&nbsp; <a
				href="${cusTypeUrl}?DELETE=&&cusTypeNo=${cusType.cusTypeNo}"
				onClick="return confirm('确定删除?');"><span
					class="glyphicon glyphicon-trash"></span> </a></td>
		</tr>
	</c:forEach>
</table>