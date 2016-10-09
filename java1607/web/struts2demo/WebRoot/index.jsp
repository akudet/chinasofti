<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
  	${msg }
    <form action="user/login.action" method="get">
    	NAME:<input type="text" name="username">
    	<input type="submit" value="提交">
    </form>
    
    <ul>
    <c:forEach items="${users}" var="user">
    	<li>${user.value}
    	 <a href="/struts2demo/edit.jsp?id=${user.value.id }">修改</a>
    	 <a href="user/delete.action?id=${user.value.id}">删除</a></li>
    </c:forEach>
    </ul>
  </body>
</html>
