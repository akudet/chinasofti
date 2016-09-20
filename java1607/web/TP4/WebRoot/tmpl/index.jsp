<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>酒店管理系统主页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="/TP4/css/styles.css" type="text/css" rel="stylesheet">

<%@ include file="/tmpl/include.jsp"%>
</head>

<body>
	<%@ include file="nav.jsp"%>

	<div class="col-sm-12 col-lg-10 sidebar">
	<div class="row">
		<div class="col-xs-12 col-md-6 col-lg-3">
			<div class="panel panel-blue panel-widget ">
				<div class="row no-padding">
					<div class="col-sm-3 col-lg-5 widget-left">
						<em class="glyphicon glyphicon-briefcase glyphicon-l"></em>
					</div>
					<div class="col-sm-9 col-lg-7 widget-right">
						<div class="large">${checkinCount}</div>
						<div class="text-muted">入住用户</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xs-12 col-md-6 col-lg-3">
			<div class="panel panel-orange panel-widget">
				<div class="row no-padding">
					<div class="col-sm-3 col-lg-5 widget-left">
						<em class="glyphicon glyphicon-home glyphicon-l"></em>
					</div>
					<div class="col-sm-9 col-lg-7 widget-right">
						<div class="large">${freeRoomCount}</div>
						<div class="text-muted">空闲房间</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xs-12 col-md-6 col-lg-3">
			<div class="panel panel-teal panel-widget">
				<div class="row no-padding">
					<div class="col-sm-3 col-lg-5 widget-left">
						<em class="glyphicon glyphicon-user glyphicon-l"></em>
					</div>
					<div class="col-sm-9 col-lg-7 widget-right">
						<div class="large">${vipCount}</div>
						<div class="text-muted">会员总数</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xs-12 col-md-6 col-lg-3">
			<div class="panel panel-red panel-widget">
				<div class="row no-padding">
					<div class="col-sm-3 col-lg-5 widget-left">
						<em class="glyphicon glyphicon-stats glyphicon-l"></em>
					</div>
					<div class="col-sm-9 col-lg-7 widget-right">
						<div class="large">${checkCount}</div>
						<div class="text-muted">总入住数</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/.row-->
	</div>
	<a href="${opUrl}">操作员页面</a>
	<a href="${adminUrl}">系统管理</a>
</body>
</html>
