<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="tp4.servlet.op.*"%>

<%
String path = request.getContextPath();
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title>${vip.name}</title>
    
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
		<input type="hidden" name="PUT">
		会员编号：<input type="number" name="vipNo" value="${vip.vipNo}" disable><br>
		会员姓名：<input type="text" name="name" value="${vip.name }"><br>
		会员性别：<input type="text" name="sex" value="${vip.sex}"><br>
		证件编号：<input type="text" name="certNo" value="${vip.certNo}"><br>
		联系电话:<input type="text" name="phone" value="${vip.phone}"><br>
		详细地址：<input type="text" name="address" value="${vip.address}"><br>
		备注：<input type="text" name="comment" value="${vip.comment}"><br>
		<input type="submit" value="修改">
	</form>
  </body>
</html>
