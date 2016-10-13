<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<a href="user/new.action">添加</a>
	<table border="1px solid black">
		<thead>
			<tr>
				<td>姓名</td>
				<td>年龄</td>
				<td>自我介绍</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr <c:if test="${user.id == param.id }">style="background-color:red"</c:if>>
					<td>${user.name}</td>
					<td>${user.age}</td>
					<td>${user.message.text}</td>
					<td><a href="user/get.action?id=${user.id}">详细</a> <a
						href="user/edit.action?id=${user.id }">修改</a> <a
						href="user/delete.action?id=${user.id}">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>


	</table>
</body>
</html>
