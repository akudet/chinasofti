<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <form action="${servletUrl}" action="GET">
    	<input type="hidden" name="byRoom">
    	<input type="date" name="start">
    	<input type="date" name="end">
    	<select name="checkinType">
    		<option value="1">标准</option>
    	</select>
    	<input type="checkbox" name="roomTypeNos" value="1">标准单间
		<input type="checkbox" name="roomTypeNos" value="2">标准双间
		<input type="checkbox" name="roomTypeNos" value="3">豪华单间
		<input type="checkbox" name="roomTypeNos" value="4">豪华双间
    	<input type="submit" value="查询">
    </form>
    <form action="${servletUrl}" action="GET">
    	<input type="hidden" name="byCus">
    	<input type="text" name="name">
    	<input type="text" name="roomId">
    	<select name="status">
    		<option value="1">可用</option>
    	</select>
    	<select name="cusTypeNo">
    		<option valude="1">普通用户</option>
    	</select>
    	<input type="submit" value="查询">
    </form>
