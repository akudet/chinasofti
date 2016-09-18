<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

${rooms }
<html>
	<body>
		<table>
			<tr>
				<th>房间号</th><th>房间类型</th><th>房间状态</th><th>操作</th>
			</tr>
			<c:forEach items="${rooms }" var="room">
				<tr>
					<td>${room.roomId }</td>
					<td>${room.roomType.roomTypeDesc }</td>
					<td>${room.status }</td>
					<td><a href="${newUrl}${room.roomId}">开房</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>