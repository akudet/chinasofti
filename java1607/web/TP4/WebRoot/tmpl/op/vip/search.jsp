<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form class="form-inline" action="${vipUrl}" method="GET">
	<div class="col-md-2 text-left">
		<div class="form-group">
			<a class="btn btn-primary" href="${vipUrl}/new"><i
				class="glyphicon glyphicon-plus"></i> 添加</a>
		</div>
	</div>

	<div class="col-md-10 text-right">
		<div class="form-group">
			<label>会员编号：</label>
			<input type="text" name="vipNo">
		</div>

		<div class="form-group">
			<button class="btn btn-primary" type="submit">查询</button>
		</div>
	</div>
</form>
<form class="form-inline" action="${vipUrl}" method="GET">
	<div class="col-md-12 text-right">
		<div class="form-group">
			<label>用户名：</label>
			<input type="text" name="name">
		</div>

		<div class="form-group">
			<button class="btn btn-primary" type="submit">查询</button>
		</div>
	</div>
</form>