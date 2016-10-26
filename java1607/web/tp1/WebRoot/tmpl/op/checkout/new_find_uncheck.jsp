<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form class="form-inline" action="${checkoutUrl }/new" method="GET">
	<div class="form-group">
		<label>房间号：</label> <input type="text" name="roomId">
	</div>
	<div class="form-group">
		<button class="btn btn-primary" type="submit">查询</button>
	</div>
</form>