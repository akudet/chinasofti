<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@ include file="include.jsp" %>
</head>
<body>

<div ng-app="">
 	<p>你好 <input type="text" ng-model="name"></p>
 	<h1>Hello {{name}}</h1>
</div>

</body>
</html>