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
	<%@ include file="/tmpl/include.jsp" %>
  </head>
 
  <body>
  <%@include file="../../nav.jsp"%>
	<div class="col-sm-12 col-lg-10 sidebar">
	<%@include file="../admin-nav.jsp"%>
	<div class="panel">
	   <div class="panel-body">
	   <div class="btn-toolbar">
        <a class="btn btn-primary" href="<%= path + CusTypeServlet.SERVLET_URL + "/new" %>"><i class="glyphicon glyphicon-plus"></i> 添加</a>
      </div>
   <p></p>
   <table class="table">
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
	
  </div></div>
  </body>
</html>
