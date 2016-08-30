<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  </head>
  
  <body>
    <% String err_msg = (String) request.getAttribute("err_msg"); %>
    <% if (err_msg != null) { %>
    	<%= err_msg %>
    <% } %>
    <script>
    	var validate = function() {
    		var form = document.forms[0];
    		var name = form.username.value;
    		var pass = form.password.value;
    		if (!name) {
    			alert("empty name");
    		}
    		if (!pass) {
    			alert("empty pass");
    		}
    		return false;
    	};
    </script>
    <form action="LoginServlet" method="post" onsubmit="validate();">
    	用户名：<input type="text" name="username">
    	密码：<input type="password" name="password">
    	<input type="submit" value="post">
    </form>
    <a href="UsersServlet">Users</a>
  </body>
</html>
