<%@ page language="java" import="java.util.*,tp4.model.vo.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
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
  	<%User user = (User)request.getAttribute("user"); %>
    	<div align="center">
    	<form method="post" action="/TP4/admin/user/">
    	<input type="hidden" name="PUT">
    		I&nbsp;&nbsp;D:<input type="text" name="userId" value="${user.userId } " /><br>
    		名&nbsp;字:<input type="text" name="userName"  value="${user.userName }" /><br>
    		密&nbsp;码:<input type="text" name="userPass"  value="${user.userPass } " /><br>
    		特&nbsp;权:<input type="text" name="privilege"  value="${user.privilege }" /><br>
    		
    		<input type="submit" value="修改"/><br>
    	</form>
    	</div>
  </body>
</html>
