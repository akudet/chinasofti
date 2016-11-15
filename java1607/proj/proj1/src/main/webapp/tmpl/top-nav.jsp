<%@ page language="java" import="java.util.*,team4.proj1.model.vo.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div  style="color:#ACD6FF" class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="" href="/TP4/main" ><span class="navbar-brand" style="color: white;font-weight:bold;font-size: 1.4em;">
		<span class="fa fa-paper-plane" ><img width="140px" height="38px" src="http://cache.marriott.com/Images/DigitalFoundations/Header/logo-marriott-markonleft-2x.png" alt="Marriott Logo">
		</span>酒店管理系统</span></a></div>

	<div class="navbar-collapse collapse" style="height: 1px;background-color:#C4E1FF;">
		<ul id="main-menu" class="nav navbar-nav navbar-right">
			<li class="dropdown hidden-xs">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
				</a>

				<ul class="dropdown-menu">
               	 <li><a href="./">My Account</a></li>
               	 <li class="divider"></li>
               	 <li class="dropdown-header">Admin Panel</li>
               	 <li><a href="./">Users</a></li>
               	 <li><a href="./">Security</a></li>
               	 <li><a tabindex="-1" href="./">Payments</a></li>
               	 <li class="divider"></li>
                	<li><a tabindex="-1" href="sign-in.html">Logout</a></li>
				</ul>
			</li>
			<li>
			<a href="${logoutUrl}">登出</a>
			</li>
		</ul>

        </div>
</div>