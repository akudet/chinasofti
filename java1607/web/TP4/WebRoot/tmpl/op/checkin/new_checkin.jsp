<%@ page language="java" import="tp4.model.vo.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	function getValue(xml, name) {
		return xml.getElementsByTagName(name)[0].innerHTML;
	}
	
	function setEmpty() {
						$("#name").val("");
					$("#sex").val("");
					$("#certNumber").val("");
					$("#address").val("");
					$("#comment").val("");
	}
	
	$(document).ready(function() {
		$("#vipNo").on("keyup", function() {
			var vipNo = $(this).val();
			$.get("${vipUrl}?vip_no="+vipNo).then(function(data) {
			console.log(data);
				if (!data.getElementsByTagName("ERROR")[0]) {
					$("#vipNo").val(getValue(data, "vip_no"));
					$("#name").val(getValue(data,"name"));
					$("#sex").val(getValue(data,"sex"));
					$("#certNumber").val(getValue(data,"cert_number"));
					$("#address").val(getValue(data,"address"));
					$("#comment").val(getValue(data,"comment"));
				} else {
					setEmpty();
				}
			});
		});
	});
	
	function a(){
				if($(this).val() == ("<%= CusType.VIP_CUS_TYPE_NO %>")){
					setAll(true);
					$("#certType").val("身份证");
				} else {
					setAll(false);
					$("#vipNo").val("");
					setEmpty();
				}
				
			}
	$(document).ready(function() {
		$("#cus_type").on("change",a);
	});

	function setAll(readonly){
		$("#vipNo").prop("readonly", !readonly);
		$("#name").attr("readonly",readonly);
		$("#sex").attr("disabled",readonly);
		$("#certType").attr("disabled",readonly);
		$("#certNumber").attr("readonly",readonly);
		$("#address").attr("readonly",readonly);
		$("#comment").attr("readonly",readonly);
	}
</script>
<c:if test="${room != null}">
	<form action="${checkinUrl}" method="POST">
		<input type="hidden" name="POST" />

		<div class="form-group">
			<label>房间号:</label> <input type="text" class="form-control"
				name="roomId" value="${room.roomId }" />
		</div>

		<div class="form-group">
			<label>用户类型</label> <select id="cus_type" class="form-control" name="cusTypeNo">
				<c:forEach items="${cusTypes}" var="cusType">
					<option id="op" value="${cusType.cusTypeNo}">${cusType.cusTypeDesc}</option>
				</c:forEach>
			</select>
		</div>

		<div class="form-group">
			<label>客户名称:</label> <input type="text" id="name" class="form-control"
				name="name" />
		</div>
		<div class="form-group">
			<label>会员编号:</label> <input type="number" id="vipNo" class="form-control"
				readonly name="vipNo" />
		</div>

		<div class="form-group">
			<label>性别:</label> <select name="sex" class="form-control" id="sex" >
				<option value="男">男</option>
				<option value="女">女</option>
			</select>
		</div>

		<div class="form-group">
			<label>证件类型:</label> <select name="certType" class="form-control" id="certType">
				<option value="身份证">身份证</option>
				<option value="军官证">军官证</option>
				<option value="护照">护照</option>
				<option value="其他">其他</option>
			</select>
		</div>

		<div class="form-group">
			<label>证件编号:</label> <input type="text" class="form-control"
				name="certNumber" id="certNumber"/>
		</div>

		<div class="form-group">
			<label>地址信息:</label> <input type="text" class="form-control"
				name="address" id="address" />
		</div>

		<div class="form-group">
			<label>备注:</label>
			<textarea class="form-control" name="comment" id="comment"></textarea>
		</div>

		<div class="form-group">
			<label>计费方式:</label> <input type="radio" name="checkinType"
				value="<%=RoomType.NORMAL_ROOM%>" checked />标准 <input
				<c:if test="${!room.roomType.isHourRoom()}">disabled</c:if>
				type="radio" name="checkinType" value="<%=RoomType.HOUR_ROOM%>" />钟点
		</div>

		<div class="form-group">
			<label>预住天数:</label> <input type="number" class="form-control"
				name="numOfDays" />
		</div>

		<div class="form-group">
			<label>押金:</label> <input type="number" class="form-control"
				name="deposit" />
		</div>

		<div class="form-group">
			<button class="btn btn-primary" type="submit">提交</button>
		</div>
	</form>
</c:if>