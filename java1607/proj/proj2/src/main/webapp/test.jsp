<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@ include file="views/include.jsp" %>
</head>
<body>

<form action="prod/upload" method="post" enctype="multipart/form-data">
	<input type="file" name="file">
	<input type="submit">
</form>

</body>
</html>