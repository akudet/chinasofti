<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js"></script>
	<script src="test.js"></script>
	<script src="http://cdn.bootcss.com/jquery/3.1.0/jquery.js"></script>
	<script>
		var sendJSAJAX = function () {
			//alert("sendJSAJAX");
			var xmlhttp = new XMLHttpRequest();
			
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4) {
					if (xmlhttp.status == 200) {
						//alert("got it");
						document.getElementById("container").innerHTML = xmlhttp.responseText;
					}
				}
			};
			
			xmlhttp.open("GET", "index.jsp", true);
			xmlhttp.send();

		};
		
		var sendAJAX = function() {
			//alert("sendjQueryAJAX()");
			$.get("index.jsp").done(function(res){
				$("#container").html(res);
			});
		};
		
	</script>
	
  </head>
  
  <body ng-app="testApp" ng-controller="TestController">
 <input type="text" ng-model="name">
    
    <p>{{name}}</p>
    <div id="container">click the button below</div>
    <button onclick="sendJSAJAX()">JSAJAX</button>
    <button onclick="sendAJAX()">jQueryAJAX</button>
  </body>
</html>
