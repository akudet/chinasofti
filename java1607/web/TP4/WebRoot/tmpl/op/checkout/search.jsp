<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="${servletUrl}" action="GET">
	<input type="hidden" name="byRoom">
	<input type="date" name="start">
    	<input type="date" name="end">
    	<select name="chargeType">
    		<option value="-1">全部</option>
    	    <c:forEach items="${chargeTypes}" var="chargeType">
    			<option value="${chargeType.chargeTypeNo}">${chargeType.chargeTypeDesc}</option>
    		</c:forEach>
    	</select>
    	<c:forEach items="${roomTypes}" var="roomType">
    		<input type="checkbox" name="roomTypeNos" value="${roomType.roomTypeNo}">${roomType.roomTypeDesc}
    	</c:forEach>
    	<input type="submit" value="查询">
    </form>
    <form action="${servletUrl}" action="GET">
    	<input type="hidden" name="byCus">
    	<input type="text" name="name">
    	<input type="text" name="roomId">
    	<select name="cusTypeNo">
    		<c:forEach items="${cusTypes}" var="cusType">
    			<option value="${cusType.cusTypeNo}">${cusType.cusTypeDesc}</option>
    		</c:forEach>
    	</select>
    	<input type="submit" value="查询">
    </form>
