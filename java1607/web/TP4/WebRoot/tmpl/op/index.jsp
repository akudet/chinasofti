<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>操作员界面</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="/tmpl/header.jsp" %>
  </head>
  
  <body>
  	<a href="${checkinUrl}/new">开设房间</a>
  	<a href="${checkinUrl}">客户结帐</a>
  	<a href="${reservationUrl}">预定管理</a>
  	<a href="${checkoutUrl}">营业查询</a>
    <a href="${vipUrl}">会员管理</a>
    <a href="${adminUrl}">系统管理</a>
  </body>
</html>
