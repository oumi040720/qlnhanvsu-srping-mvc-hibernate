<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<header class="site-navbar mt-3">
	<div class="container-fluid">
		<div class="row align-items-center">
			<div class="site-logo col-6"><a href="<c:url value="/home" />">ABC Group</a></div>
			<nav class="mx-auto site-navigation">
				<ul class="site-menu js-clone-nav d-none d-xl-block ml-0 pl-0">
					<li><a href="<c:url value="/home" />"><s:message code="global.menu.home"/></a></li>
					<li><a href="<c:url value="/depart/list?page=1&maxPageItems=10" />"><s:message code="global.menu.depart"/></a></li>
					<li><a href="<c:url value="/record/list?page=1&maxPageItems=5" />"><s:message code="global.menu.record"/></a></li>
					<li class="has-children">
						<a href=""><s:message code="global.menu.report"/></a>
						<ul class="dropdown">
							<li><a href="<c:url value="/record/report/depart/list?page=1&maxPageItems=10" />"><s:message code="global.menu.depart"/></a></li>
							<li><a href="<c:url value="/record/report/staff/list?page=1&maxPageItems=5" />"><s:message code="global.menu.staff"/></a></li>
						</ul>
					</li>
					<li><a href="<c:url value="/contact" />"><s:message code="global.menu.contact"/></a></li>
					<li class="d-lg-none"><a href="<c:url value="/login" />"><s:message code="global.login"/></a></li>
					<li class="has-children">
						<a><s:message code="global.language"/></a>
						<ul class="dropdown">
							<li><a href="#" data-lang="en"><s:message code="global.language.english"/></a></li>
							<li><a href="#" data-lang="vi"><s:message code="global.language.vietnamese"/></a></li>
						</ul>
					</li>
				</ul>
			</nav>
			<div class="right-cta-menu text-right d-flex aligin-items-center col-6">
				<div class="ml-auto">
					<c:if test="${not empty USER}">
						<a href="<c:url value="/admin/home" />">
							<span class="text-success"> ${USER}, </span>
						</a>
						<a href="<c:url value="/logout" />">
							<span class="text-warning"> <s:message code="global.logout" /></span>
						</a>
					</c:if>
					<c:if test="${empty USER}">
						<a href="<c:url value="/login" />" class="btn btn-primary border-width-2 d-none d-lg-inline-block">
							<span class="mr-2 icon-lock_outline"></span> <s:message code="global.login"/>
						</a>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</header>
