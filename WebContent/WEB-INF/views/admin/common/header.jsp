<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<nav class="navbar navbar-default navbar-fixed-top">
	<div class="brand">
		<a href="<c:url value="/admin/home" />">
			<img width="139px" height="21" src="<c:url value="/template/admin/img/abc.png"/>" alt="Logo" class="img-responsive logo">
		</a>
	</div>
	<div class="container-fluid">
		<div class="navbar-btn">
			<button type="button" class="btn-toggle-fullwidth">
				<i class="lnr lnr-arrow-left-circle"></i>
			</button>
		</div>
		<div id="navbar-menu">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="fas fa-globe"></i> <span><s:message code="global.language"/></span> <i class="icon-submenu lnr lnr-chevron-down"></i>
					</a>
					<ul class="dropdown-menu">
						<li><a href="#" data-lang="en"><s:message code="global.language.english"/></a></li>
						<li><a href="#" data-lang="vi"><s:message code="global.language.vietnamese"/></a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<img src="<c:url value="/template/admin/img/user.png"/>" class="img-circle" alt="Avatar"> 
						<span>${USER}</span> 
						<i class="icon-submenu lnr lnr-chevron-down"></i>
					</a>
					<ul class="dropdown-menu">
						<li><a href="#"><i class="lnr lnr-user"></i> <span><s:message code="global.profile"/></span></a></li>
						<li><a href="<c:url value="/logout" />"><i class="lnr lnr-exit"></i> <span><s:message code="global.logout"/></span></a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>