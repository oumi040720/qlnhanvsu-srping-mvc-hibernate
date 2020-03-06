<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ include file="/WEB-INF/views/web/common/header2.jsp" %>

<section class="site-section">
	<div class="container-fluid">
		<div class="col-md-12 text-center">
			<h2 class="section-title mb-2">
				<s:message code="depart.title" />
			</h2>
		</div>
		<br>
		<br>
		<div class="col-md-12 text-center">
			<div class="row mb-5 justify-content-center">
				<div class="col-md-9 text-center">
					<form id="form-submit" action='<c:url value="/depart/list" />' method="get">
						<div class="row">
							<div class="col-md-12">
								<div>
									<table class="table table-striped table-hover">
										<thead class="thead-dark">
											<tr>
												<th><s:message code="depart.id" /></th>
												<th><s:message code="depart.name" /></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${departs}" var="depart">
												<tr>
													<td>${depart.id}</td>
													<td>${depart.name}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<br>
									<nav aria-label="Page navigation" style="text-align: center;">
										<ul class="pagination" id="pagination"></ul>
										<input type="hidden" id="page" name="page" value=""> 
										<input type="hidden" id="maxPageItems" name="maxPageItems" value="">
									</nav>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>

<script type="text/javascript">
	var totalPages = ${totalPages};
	var currentPage = ${page};
	var limit = 10;

	$(function() {
		window.pagObj = $('#pagination').twbsPagination({
			totalPages : totalPages,
			visiblePages : 10,
			startPage : currentPage,
			onPageClick : function(event, page) {
				if (currentPage != page) {
					$('#maxPageItems').val(limit);
					$('#page').val(page);
					$('#form-submit').submit();
				}
			}
		});
	});
</script>
