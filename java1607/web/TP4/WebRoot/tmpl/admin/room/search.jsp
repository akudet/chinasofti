<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="${servletUrl}" method="get">
	<div class="form-group"><br>
	<label style="font-size: larger;">房间类型查询</label><br>
	<select name="roomTypeNo" class="form-control">
  		<c:forEach items="${roomTypes}" var="roomType">
  			<option
  				<c:if test="${roomType.roomTypeNo == param.roomTypeNo}">selected</c:if>
  				value="${roomType.roomTypeNo }">${roomType.roomTypeDesc }</option>
  		</c:forEach>
	</select>
	</div>
	<input type="submit" value="查询" style="height:30px;width:100px;text-align:tenter;"/>
</form>

