<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<div id="sidebar-nav" class="sidebar">
	<div class="sidebar-scroll">
		<nav>
			<ul class="nav">
				<li>
					<a href="<c:url value="/admin/home" />"><i class="lnr lnr-home"></i> <span><s:message code="global.menu.home"/></span></a>
				</li>
				<li>
					<a href="<c:url value="/admin/user/list?page=1&maxPageItems=7" />" class=""><i class="lnr lnr-user"></i> <span><s:message code="global.menu.user"/></span></a>
				</li>
				<li>
					<a href="<c:url value="/admin/depart/list?page=1&maxPageItems=7" />" class=""><i class="lnr lnr-apartment"></i> <span><s:message code="global.menu.depart"/></span></a>
				</li>
				<li>
					<a href="<c:url value="/admin/staff/list?page=1&maxPageItems=3" />" class=""><i class="lnr lnr-users"></i> <span><s:message code="global.menu.staff"/></span></a>
				</li>
				<li>
					<a href="<c:url value="/admin/record/list?page=1&maxPageItems=7" />" class=""><i class="lnr lnr-file-empty"></i> <span><s:message code="global.menu.record"/></span></a>
				</li>
				<li>
					<a href="#subPages" data-toggle="collapse" class="collapsed">
					<i class="lnr lnr-chart-bars"></i> <span><s:message code="global.menu.report"/></span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
					<div id="subPages" class="collapse ">
						<ul class="nav">
							<li><a href="<c:url value="/admin/record/report/staff?page=1&maxPageItems=3" />" class=""><s:message code="global.menu.staff"/></a></li>
							<li><a href="<c:url value="/admin/record/report/depart?page=1&maxPageItems=7" />" class=""><s:message code="global.menu.depart"/></a></li>
						</ul>
					</div>
				</li>
				<li>
					<a href="<c:url value="/admin/email" />" class=""><i class="lnr lnr-envelope"></i> E-mail </a>
				</li>
				<li>
					<a href="<c:url value="/home" />" class=""><i class="lnr lnr-code"></i> Web </a>
				</li>
			</ul>
		</nav>
	</div>
</div>