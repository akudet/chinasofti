<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@ include file="../include.jsp"%>
</head>
<body>

	<div>
		<ul>
			<li><a href="latest">最新上架</a></li>
			<li><a href="popular">最热产品</a></li>
			<li><a href="discount">打折销售</a></li>
		</ul>
	</div>
	<%@ include file="prods-list.jsp"%>

</body>
</html>