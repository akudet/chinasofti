<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form class="form-inline" action="${userUrl}" method="GET">
	<div class="col-md-2 text-left">
		<div class="form-group">
			<a class="btn btn-primary" href="${userUrl}/new"> <span
				class="glyphicon glyphicon-plus"></span>&nbsp;添加 </a>
		</div>
	</div>

	<div class="col-md-10 text-right">
		<div class="form-group">
			<label>用户名：</label> <input class="form-control" type="text"
				name="userName">
		</div>

		<div class="form-group">
			<button class="btn btn-primary" type="submit">查询</button>
		</div>
	</div>
</form>
