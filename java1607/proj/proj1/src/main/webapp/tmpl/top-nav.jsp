<%@ page language="java" import="java.util.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div style="color:#ACD6FF" class="navbar navbar-default"
	role="navigation">
	<div class="navbar-header">
		<a href=""><span class="navbar-brand"
			style="color: white;font-weight:bold;font-size: 1.4em;"> <span
				class="fa fa-paper-plane"><img width="140px" height="38px"
					src="http://cache.marriott.com/Images/DigitalFoundations/Header/logo-marriott-markonleft-2x.png"
					alt="Marriott Logo"> </span>酒店管理系统
		</span></a>
	</div>

	<div class="navbar-collapse collapse"
		style="height: 1px;background-color:#C4E1FF;">
		<ul id="main-menu" class="nav navbar-nav navbar-right">
			<li><a href="${logoutUrl}">登出</a></li>
		</ul>
	</div>
</div>