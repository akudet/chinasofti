<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <table>
    	<tr>
    		<th>入住单号</th><th>房间号</th><th>房间类型</th><th>客户类型</th>
    		<th>客户名称</th><th>性别</th><th>证件类型</th><th>证件编号</th>
    		<th>地址信息</th><th>备注</th><th>入住时间</th><th>计费方式</th>
    		<th>单价</th><th>预住天数</th><th>押金</th><th>操作</th>
    	</tr>
   
    	<c:forEach items="${requestScope.checkins }" var="checkin">
    		<tr>
    			<td>${checkin.checkinId }</td>
    			<td>${checkin.roomId }</td>
    			<td>${checkin.roomTypeDesc }</td>
    			<td>${checkin.cusTypeDesc }</td>
    			<td>${checkin.name }</td>
    			<td>${checkin.sex }</td>
    			<td>${checkin.certType }</td>
    			<td>${checkin.certNumber }</td>
    			<td>${checkin.address }</td>
    			<td>${checkin.comment }</td>
    			<td>${checkin.checkinTime }</td>
    			<td>${checkin.checkinType }</td>
    			<td>${checkin.price }</td>
    			<td>${checkin.numOfDays }</td>
    			<td>${checkin.deposit }</td>
    			<td><a>修改</a><a>结账</a></td>
    		</tr>
    	</c:forEach>
    </table>
  </body>
</html>
