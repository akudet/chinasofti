<%@ page language="java" import="java.util.*, tp4.model.vo.*,tp4.model.dao.*" pageEncoding="UTF-8"%>
<%
Vip vip = new VipDao().findById("1000");
CusInfo vipInfo = vip.getCusInformation();
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
	会员编号：<%= vip.getVipNumber() %>
	会员姓名：<%= vipInfo.getName() %>
	性别：<%= vipInfo.getSex() %>
	证件编号：<%= vipInfo.getCertNumber() %>
	联系电话：<%= vipInfo.getPhone() %>
	详细地址：<%= vipInfo.getAddresss() %>
	备注：<%= vipInfo.getComment() %>
  </body>
</html>
