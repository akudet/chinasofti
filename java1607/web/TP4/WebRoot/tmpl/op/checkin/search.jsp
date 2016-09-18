<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="${searchUrl}" method="get">
	<input type="hidden" name="byRoom">
	<select name="roomTypeNo">
  		<c:forEach items="${roomTypes}" var="roomType">
  			<option value="${roomType.roomTypeNo }">${roomType.roomTypeDesc }</option>
  		</c:forEach>
	</select>
	<input type="submit" value="提交"/>
</form>
<%@ include file="rooms.jsp" %>
