<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>添加客户折扣信息</title>
    
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
    <form action="${pageContext.request.contextPath }/TP4/admin/cus_type/new" method="post">
    <input type="hidden" name="POST">
              客户类型编号：<input type="text"name="cusTypeNo"><br> 
              客户类型：<input type="text" name="cusTypeDesc"><br>
              折扣类型：<input type="text" name="discount"><br>
    </form>
  </body>
</html>
