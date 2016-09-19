<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="${searchUrl}" method="get">
	<input type="hidden" name="byRoom">
	<div class="form-group">
	<select name="roomTypeNo" class="form-control">
  		<c:forEach items="${roomTypes}" var="roomType">
  			<option value="${roomType.roomTypeNo }">${roomType.roomTypeDesc }</option>
  		</c:forEach>
	</select>
	</div>
	<input type="submit" value="提交" style="height:30px;width:100px;text-align:tenter;"/>
</form>
<%@ include file="rooms.jsp" %>
