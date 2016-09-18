<%@ page pageEncoding="UTF-8"%>
	
<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
	<ul class="nav menu">
		<li class="active">
			<a href="${checkinUrl}/new">
				<span class="glyphicon glyphicon-dashboard"></span>
				 开设房间
			</a>
		</li>
		<li>
			<a href="${checkoutUrl}/new">
				<span class="glyphicon glyphicon-th"></span>
				客户结账
			</a>
		</li>
		<li>
			<a href="${reservationUrl}">
				<span class="glyphicon glyphicon-stats"></span>
				预定管理
			</a>
		</li>
		<li>
			<a href="${checkoutUrl}">
				<span class="glyphicon glyphicon-list-alt"></span>
				营业查询
			</a>
		</li>
		<li>
			<a href="${vipUrl}">
				<span class="glyphicon glyphicon-user"></span>
				会员管理
			</a>
		</li>
		<li>
			<a href="${adminUrl}"><span class="glyphicon glyphicon-info-sign"></span>
			系统管理</a>
		</li>
	</ul>
</div>