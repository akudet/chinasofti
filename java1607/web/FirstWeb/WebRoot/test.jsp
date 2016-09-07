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
						var xml = xmlhttp.responseXML;
						var exists = xml.getElementsByTagName("EXISTS")[0].innerHTML;
						//alert(xmlhttp.responseText);
						if (exists == "true") {
							document.getElementById("container").innerHTML = "user name already exists";
						} else {
							document.getElementById("container").innerHTML = "user name is ok to use";
						}
						
					}
				}
			};
			
			var name = $("#name").val();
			//alert(name);
			xmlhttp.open("GET", "users/exists?name=" + name, true);
			xmlhttp.send();

		};
		
		var sendAJAX = function() {
			//alert("sendjQueryAJAX()");
			var name = $("#name").val();
			$.post("users/exists", {"name":name}).done(function(res){
				var exists = res.getElementsByTagName("EXISTS")[0].innerHTML;
				//alert(res);
				if (exists == "true") {
					$("#container").html("user name already exists");
				} else {
					$("#container").html("user name is ok to use");
				}
			});
		};
		
	</script>
	
  </head>
  
  <body ng-app="testApp" ng-controller="TestController">
 <input id="name" type="text" ng-model="name">
    
    <p>{{name}}</p>
    <div id="container">click the button below</div>
    <button onclick="sendJSAJAX()">JSAJAX</button>
    <button onclick="sendAJAX()">jQueryAJAX</button>
  </body>
</html>
