<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<footer class="site-footer">
    <div class="container">
    	<div class="row mb-5">
          	<div class="col-6 col-md-3 mb-4 mb-md-0">
           		<h3>ABC Group</h3>
            	<ul class="list-unstyled">
              		<li><a href="<c:url value="/home" />"><s:message code="global.menu.home"/></a></li>
	              	<li><a href="<c:url value="/depart/list?page=1&maxPageItems=10" />"><s:message code="global.menu.depart"/></a></li>
	              	<li><a href="<c:url value="/record/list?page=1&maxPageItems=5" />"><s:message code="global.menu.record"/></a></li>
	              	<li><a href="<c:url value="/contact" />"><s:message code="global.menu.contact"/></a></li>
            	</ul>
         	</div>
          	<div class="col-6 col-md-3 mb-4 mb-md-0">
            	<h3><s:message code="global.menu.report"/></h3>
            	<ul class="list-unstyled">
              		<li><a href="<c:url value="/record/report/depart/list?page=1&maxPageItems=10" />"><s:message code="global.menu.depart"/></a></li>
					<li><a href="<c:url value="/record/report/staff/list?page=1&maxPageItems=5" />"><s:message code="global.menu.staff"/></a></li>
            	</ul>
          	</div>
          	<div class="col-6 col-md-3 mb-4 mb-md-0">
            	<h3><s:message code="global.language"/></h3>
            	<ul class="list-unstyled">
              		<li><a href="#" data-lang="en"><s:message code="global.language.english"/></a></li>
					<li><a href="#" data-lang="vi"><s:message code="global.language.vietnamese"/></a></li>
            	</ul>
          	</div>
          	<div class="col-6 col-md-3 mb-4 mb-md-0">
            	<h3>Contact Us</h3>
            	<div class="footer-social">
              		<a href="#"><span class="icon-facebook"></span></a>
              		<a href="#"><span class="icon-twitter"></span></a>
              		<a href="#"><span class="icon-instagram"></span></a>
              		<a href="#"><span class="icon-linkedin"></span></a>
            	</div>
          	</div>
        </div>
	</div>
</footer>