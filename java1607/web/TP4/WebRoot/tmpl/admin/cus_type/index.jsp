<%@ page language="java" import="java.util.*,tp4.servlet.admin.*" pageEncoding="UTF-8"%>

<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>查找所有顾客折扣类型</title>
    
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
   <table>
		<tr>
			<th>客户类型编号</th>
			<th>客户类型</th>
			<th>打折比例</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${cusTypes}" var="cusType">
			<tr>
				<td>${cusType.cusTypeNo}</td>
				<td>${cusType.cusTypeDesc}</td>
				<td>${cusType.discount}</td>
				<td>
					<a href="<%= path + CusTypeServlet.SERVLET_URL + "/edit?cusTypeNo=" %>${cusType.cusTypeNo}">修改</a>
					<a href="<%= path + CusTypeServlet.SERVLET_URL + "?DELETE=&&cusTypeNo=" %>${cusType.cusTypeNo}">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="<%= path + CusTypeServlet.SERVLET_URL + "/new" %>">添加</a>
  </body>
</html>
