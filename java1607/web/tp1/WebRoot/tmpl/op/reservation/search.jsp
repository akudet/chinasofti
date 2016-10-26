<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="tab-content">
<div class="tab-pane active">

<form action="${servletUrl}" action="GET">
	<input type="hidden" name="search">

	<div class="form-group">
		<label>客户姓名</label>
		<input class="form-control" type="text" name="name">
	</div>

	<div class="form-group">
	 	<label>客户电话</label>
	 	<input class="form-control" type="text" name="phone">
	 </div>
	 
	
	<div class="form-group">
		<label>预订到达时间</label>
		<input class="form-control" type="date" name="arriveTime">
	</div>
	
	<div class="form-group">
		<button type="submit" class="btn btn-primary">查询</button>
	</div>
</form>
</div>
</div>
