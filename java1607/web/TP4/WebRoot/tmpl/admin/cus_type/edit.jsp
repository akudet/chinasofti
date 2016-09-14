<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>通过客户类型修改客户信息</title>
    
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
    <form action="${pageContext.request.contextPath }/TP4/admin/cus_type/edit" method="post" id=<%="cusTypeNo" %>>
    <input type="hidden" name="PUT">
		客户类型编号：<input type="number" name="cusTypeNo" value="${CusType.cusTypeNo}" disable><br>
		客户类型：<input type="text" name="name" value="${CusType.cusTypeDesc }"><br>
		折扣类型：<input type="text" name="sex" value="${CusType.discount}"><br>
		<input type="submit" value="修改">
	</form>
    
    </form>
  </body>
</html>
