<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="table">
	<tr>
		<th>会员编号</th>
		<th>会员姓名</th>
		<th>性别</th>
		<th>身份证号</th>
		<th>联系电话</th>
		<th>详细地址</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${vips}" var="vip">
		<tr>
			<td>${vip.vipNo}</td>
			<td>${vip.name}</td>
			<td>${vip.sex}</td>
			<td>${vip.certNo}</td>
			<td>${vip.phone}</td>
			<td>${vip.address}</td>
			<td><a
				href="${vipUrl}/edit?vipNo=${vip.vipNo}"><span
					class="glyphicon glyphicon-edit"></span>
			</a> &nbsp;&nbsp;<a
				href="${vipUrl}?DELETE=&&vipNo=${vip.vipNo}"><span
					class="glyphicon glyphicon-trash"></span>
			</a></td>
		</tr>
	</c:forEach>
</table>