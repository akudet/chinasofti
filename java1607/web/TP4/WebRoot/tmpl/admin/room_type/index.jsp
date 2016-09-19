<%@ page language="java" import="java.util.*,tp4.model.vo.*,tp4.servlet.admin.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <%@include file="../../include.jsp" %>
  </head>
  
  <body>
   <table class="table">
        <tr>
            <td>房间类型编号 </td> 
            <td> 房间类型</td>  
            <td>床位数 </td> 
            <td>单价 </td> 
            <td>是否开钟点房 </td> 
            <td>钟点房价格 </td> 
            <td>备注 </td> 
              
        </tr>
        <c:forEach items="${requestScope.list}" var="list">
        <tr>
        
            <td>${list.roomTypeNo} </td> 
            <td>${list.roomTypeDesc}</td>  
            <td>${list.beds}</td> 
            <td>${list.price} </td> 
            
            <c:if test="${list.isHourRoom  == 0}">
				<td>否</td>
			</c:if>
			<c:if test="${list.isHourRoom  == 1}">
				<td>是</td>
			</c:if>
		    <td>${list.hourRoomPrice} </td>
            <td>${list.comment}</td> 
            
            <td>
               <a href="<%= path + RoomTypeServlet.SERVLET_URL%>?DELETE=&&roomTypeNo=${list.roomTypeNo}">删除</a>
            </td>  
            <td>
			   <a href="<%= path + RoomTypeServlet.SERVLET_URL%>/edit?roomTypeNo=${list.roomTypeNo}">修改</a>
		    </td>
        </tr>
        
        </c:forEach>
   
   </table>
    <a href="<%= path + RoomTypeServlet.SERVLET_URL%>/new" style="text-align: right;"><h4>添加</h4></a>
  </body>
</html>
