<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'new.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="te xt/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="/TP4/admin/room_type" method="post" >
     房间类型编号:  <input type="test" id = "room_no" name = "room_type_no"><br><br>
    房间类型: <input type="text" name="room_type_desc"><br><br>
    床位数:   <input type="text" id = "room_beds" name = "beds"><br><br>
    单价:     <input type="text" id = "room_beds" name = "price"><br><br>
  是否可开钟点房:     <input type="radio" name="isHourRoom" value="true"  /> 是
                 <input type="radio" name="isHourRoom" value="false" /> 否<br><br>
      钟点房价格: <input type="text" id = "room_beds" name = "hourRoomPrice"><br><br>
   备注: <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<textarea rows="5px" cols="50px" name="comment"></textarea><br>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <input type="submit" value="添加" style="height: 25px;width: 70px;text-align: center;">
    </form>
  </body>
</html>
