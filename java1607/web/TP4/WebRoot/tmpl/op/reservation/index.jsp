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
  <%@include file="../../nav.jsp"%>
   <div class="col-sm-12 col-lg-10 sidebar">
	 <div class="panel panel-primary">
	   <div class="panel-heading">预订信息</div>
	  <div class="panel-body">
	
   <div class="btn-toolbar">
      <a class="btn btn-primary" href="<%= path + ReservationServlet.SERVLET_URL%>/new"><i class="glyphicon glyphicon-plus"></i> 添加</a>
   </div>
   <p></p>
      <table class="table">
       <tr>
         <th>ID</th> 
         <th>名字</th>
         <th>电话</th> 
         <th>到达时间</th> 
         <th>延长时间</th>
         <th>预订时间</th>
         <th>备注</th>
         <th>操作</th>
         
       </tr>
   
      <c:forEach items="${requestScope.users}" var="user">
   	   <tr>
		 <td>${user.reservationId}</td>
		 <td>${user.name}</td>
		 <td>${user.phone}</td>
		 <td>${user.arriveTime}</td>
		 <td>${user.reserveTime}</td>
	 	 <td>${user.reservationTime}</td>
		 <td>${user.comment}</td>
		 <td>
			<a href="<%= path + ReservationServlet.SERVLET_URL%>/edit?reservationId=${user.reservationId}"><span class="glyphicon glyphicon-edit"></span></a>
			&nbsp;&nbsp; <a><span class="glyphicon glyphicon-trash"></span></a>
   		 </td>
   
      </c:forEach>
     </table>
   
     
      </div>
     </div>
    </div>
  </body>
</html>
