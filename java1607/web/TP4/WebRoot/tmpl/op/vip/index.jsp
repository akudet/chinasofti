<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="tp4.servlet.op.*"%>

<%
	String path = request.getContextPath();
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>

<title>会员管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<table>
		<tr>
			<th>会员编号</th>
			<th>会员姓名</th>
			<th>性别</th>
			<th>身份证号</th>
			<th>联系电话</th>
			<th>详细地址</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${vips}" var="vip">
			<tr>
				<td>${vip.vipNo}</td>
				<td>${vip.name}</td>
				<td>${vip.sex}</td>
				<td>${vip.certNo}</td>
				<td>${vip.phone}</td>
				<td>${vip.address}</td>
				<td>
					<a href="<%= path + VipServlet.SERVLET_URL + "/edit?vipNo=" %>${vip.vipNo}">修改</a>
					<a href="<%= path + VipServlet.SERVLET_URL + "?DELETE=&&vipNo=" %>${vip.vipNo}">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="<%= path + VipServlet.SERVLET_URL + "/new" %>">添加</a>
</body>
</html>
