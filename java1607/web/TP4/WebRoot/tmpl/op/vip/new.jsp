<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="tp4.servlet.op.*"%>
<%
	String path = request.getContextPath();
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'edit.jsp' starting page</title>

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
	<form action="<%=path + VipServlet.SERVLET_URL%>" method="POST">
		<input type="hidden" name="POST"> 会员编号：<input type="number"
			name="vipNo"><br> 会员姓名：<input type="text" name="name"><br>
		会员性别：<input type="text" name="sex"><br> 证件编号：<input
			type="text" name="certNo"><br> 联系电话:<input type="text"
			name="phone"><br> 详细地址：<input type="text" name="address"><br>
		备注：<input type="text" name="comment"><br> <input
			type="submit" value="添加">
	</form>
</body>
</html>
