<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${users != null}">
	<table class="table">
		<tr>
			<th>ID</th>
			<th>账号</th>
			<th>密码</th>
			<th>特权</th>
			<th>操做</th>

		</tr>

		<c:forEach items="${requestScope.users }" var="user">
			<tr>
				<td>${user.userId}</td>
				<td>${user.userName }</td>
				<td>${user.userPass }</td>
				<td>${user.privilege }</td>
				<td><a href="${servletUrl}/edit?userId=${user.userId}"><span
						class="glyphicon glyphicon-edit"></span></a> 
						&nbsp;&nbsp;<a href="${deleteUrl}${user.userId}">
					<span class="glyphicon glyphicon-trash"></span></a></td>
			</tr>
		</c:forEach>
	</table>

</c:if>