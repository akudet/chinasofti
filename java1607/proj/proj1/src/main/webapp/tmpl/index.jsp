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

<link href="/proj1/css/styles.css" type="text/css" rel="stylesheet">

<%@ include file="/tmpl/include.jsp"%>
</head>

<body>
	<%@ include file="nav.jsp"%>

	<div class="col-sm-9 col-lg-10 main">
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
							<div class="large">${totalCount}</div>
							<div class="text-muted">房间数</div>
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
							<div class="text-muted">会员数</div>
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

		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">登入登出统计</div>
					<div class="panel-body">
						<div class="canvas-wrapper">
							<canvas class="main-chart" id="line-chart" height="200"
								width="600"></canvas>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/.row-->


		<div class="row">
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4>空闲</h4>
						<div class="easypiechart" id="easypiechart-blue" data-percent="${freeCount / totalCount * 100 }">
							<span class="percent">${freeCount}</span>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4>占用</h4>
						<div class="easypiechart" id="easypiechart-orange"
							data-percent="${inuseCount / totalCount * 100 }">
							<span class="percent">${inuseCount}</span>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4>保留</h4>
						<div class="easypiechart" id="easypiechart-teal" data-percent="${reservedCount / totalCount * 100 }">
							<span class="percent">${reservedCount}</span>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4>停用</h4>
						<div class="easypiechart" id="easypiechart-red" data-percent="${blockedCount / totalCount * 100 }%">
							<span class="percent">${blockedCount}</span>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/.row-->

		<script>
		var lineChartData = {
			labels : ${labels.toString()},
			datasets : [
				{
					label: "My First dataset",
					fillColor : "rgba(220,220,220,0.2)",
					strokeColor : "rgba(220,220,220,1)",
					pointColor : "rgba(220,220,220,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(220,220,220,1)",
					data : ${checkoutStats.toString()}
				},
				{
					label: "My Second dataset",
					fillColor : "rgba(48, 164, 255, 0.2)",
					strokeColor : "rgba(48, 164, 255, 1)",
					pointColor : "rgba(48, 164, 255, 1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(48, 164, 255, 1)",
					data : ${checkinStats.toString()}
				}
			]

		}
		</script>

		<script src="js/chart.min.js"></script>
		<script src="js/chart-data.js"></script>
		<script src="js/easypiechart.js"></script>
		<script src="js/easypiechart-data.js"></script>
		<!--/.row-->
	</div>
</body>
</html>
