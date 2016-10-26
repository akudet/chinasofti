<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${checkins != null }">
入住信息：
<table class="table">
	<tr>
		<th>入住单号</th>
		<th>房间号</th>
		<th>房间类型</th>
		<th>客户名称</th>
		<th>入住时间</th>
		<th>计费方式</th>
		<th>单价</th>
		<th>预住天数</th>
		<th>押金</th>
	</tr>
	<c:forEach items="${requestScope.checkins }" var="checkin">
		<tr>
			<td>${checkin.checkinId }</td>
			<td>${checkin.roomId }</td>
			<td>${checkin.roomTypeDesc }</td>
			<td>${checkin.name }</td>
			<td>${checkin.checkinTime }</td>
			<td>${checkin.checkinTypeDesc }</td>
			<td>${checkin.price }</td>
			<td>${checkin.numOfDays }</td>
			<td>${checkin.deposit }</td>
		</tr>
	</c:forEach>
</table>

客户信息：
<table class="table">
	<tr>
		<th>入住单号</th>
		<th>客户名称</th>
		<th>客户类型</th>
		<th>性别</th>
		<th>证件类型</th>
		<th>证件编号</th>
		<th>地址信息</th>
		<th>备注</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${requestScope.checkins }" var="checkin">
		<tr>
			<td>${checkin.checkinId }</td>
			<td>${checkin.name }</td>
			<td>${checkin.cusTypeDesc }</td>
			<td>${checkin.sex }</td>
			<td>${checkin.certType }</td>
			<td>${checkin.certNumber }</td>
			<td>${checkin.address }</td>
			<td>${checkin.comment }</td>
			<td><a href="${editUrl}${checkin.checkinId}">修改</a></td>
		</tr>
	</c:forEach>
</table>
</c:if>