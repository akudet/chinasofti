<%@ page language="java" import="java.util.*,tp4.servlet.op.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ include file="/tmpl/include.jsp" %>
  </head>
  
  <body>
  	${requestScope.msg }
	<%@include file="../../nav.jsp"%>

	<div class="col-sm-12 col-lg-10 sidebar">
		<div class="panel panel-primary">
			<div class="panel-heading">预订信息查询</div>
			<div class="panel-body">
			<div class="btn-toolbar">
    			<a class="btn btn-primary" href="${newUrl }"><i class="glyphicon glyphicon-plus"></i> 预订</a>
			</div>
				<%@ include file="search.jsp"%>
				<%@ include file="reservations.jsp"%>
			</div>
		</div>
	</div>
  </body>
</html>
