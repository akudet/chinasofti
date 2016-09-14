<%@ page language="java" import="java.util.*,tp4.servlet.admin.*" pageEncoding="UTF-8"%>

<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
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
  <form action="${pageContext.request.contextPath }/TP4/admin/cus_type/index"   method="get">
   <table>
		<tr>
			<th>客户类型编号</th>
			<th>客户类型</th>
			<th>打折比例</th>
			
		</tr>
		<c:forEach items="${CusTypes}" var="CusType">
			<tr>
				<td>${CusType.cusTypeNo}</td>
				<td>${CusType.cusTypeDesc}</td>
				<td>${discount}</td>
				
				<td>
					<a href="<%= path + CusTypeServlet.SERVLET_URL + "/edit?cusTypeNo=" %>${CusType.cusTypeNo}">修改</a>
					<a href="<%= path + CusTypeServlet.SERVLET_URL + "?DELETE=&&cusTypeNo=" %>${CusType.cusTypeNo}">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="<%= path + CusTypeServlet.SERVLET_URL + "/new" %>">添加</a>
   
   </form>  
    
    
    
  </body>
</html>
