<%@ page language="java" import="java.util.*,team4.proj1.control.servlet.admin.*"
	pageEncoding="UTF-8"%>
<%--@作者：项双江 --%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>房间信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<%@include file="../../include.jsp"%>
</head>

<body>

	<%@include file="../../nav.jsp"%>

	<div class="col-sm-12 col-lg-10 sidebar">

		<%@include file="../admin-nav.jsp"%>

		<div class="panel">
			<div class="panel-heading">
				<%@ include file="search.jsp"%>
			</div>

			<div class="panel-body">
				<%@ include file="rooms.jsp"%>

				<c:if test="${param.pageNo != null }">
					<c:if test="${param.pageNo==1}">
						<a>首页</a>
						<a>上一页</a>
					</c:if>
					<c:if test="${param.pageNo !=1}">
						<a href="${roomUrl}?pageNo=1">首页</a>
						<a href="${roomUrl}?pageNo=${param.pageNo-1}">上一页</a>
					</c:if>
					<%
						Object o = request.getAttribute("totalPage");
					%>
					<%
						Integer i = 0;
					%>
					<%
						for (int j = 0; j < i; j++) {
					%>
					<a href="${roomUrl}?pageNo=<%=j+1%>"><%=j + 1%></a>
					<%
						}
					%>
					<c:if test="${param.pageNo == requestScope.totalPage }">
						<a>下一页</a>
						<a>尾页</a>
					</c:if>
					<c:if test="${param.pageNo != requestScope.totalPage }">
						<a href="${roomUrl}?pageNo=${param.pageNo+1}">下一页</a>
						<a href="${roomUrl}?pageNo=${requestScope.totalPage }">尾页</a>
					</c:if>
					<p>当前第${param.pageNo}页 总共${requestScope.totalPage}页</p>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>
