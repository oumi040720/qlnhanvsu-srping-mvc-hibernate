<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ include file="/WEB-INF/views/web/common/header3.jsp" %>

<section class="site-section">
	<div class="container-fluid">
		<div class="col-md-12 text-center">
			<h2 class="section-title mb-2">
				<s:message code="record.title" /> ${year}
			</h2>
		</div>
		<br>
		<br>
		<div class="col-md-12 text-center">
			<div class="row mb-5 justify-content-center">
				<div class="col-md-9 text-center">
					<div class="form-group">
						<div class="row">
							<div class="col-md-5"></div>
							<div class="col-md-6">
								<form action="<c:url value="/record/search" />" style="width: 100%;" method="post">
									<div class="row" style="width: 100%;">
										<div class="col-md-9">
											<select class="form-control" name="year">
												<option value=""><s:message code="record.year" /></option>
												<c:forEach items="${years}" var="year">
													<option value="${year}">${year}</option>
												</c:forEach>
											</select>
										</div>
										<div class="col-md-3">
											<button class="btn btn-primary">
												<s:message code="record.search" />
											</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<br>
		<div class="col-md-12 text-center">
			<div class="row mb-5 justify-content-center">
				<div class="col-md-9 text-center">
					<form id="form-submit"
						action='<c:url value="/record/list/search" />' method="get">
						<div class="row">
							<div class="col-md-12">
								<div>
									<table class="table table-striped table-hover">
										<thead class="thead-dark">
											<tr>
												<th><s:message code="staff.photo" /></th>
												<th><s:message code="record.staff" /></th>
												<th><s:message code="record.type" /></th>
												<th><s:message code="record.reason" /></th>
												<th><s:message code="record.date" /></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${records}" var="record">
												<tr>
													<td><img class="img-thumbnail"src="<c:url value="/template/admin/img/staff/${record.staff.photo}" />"width="70px"></td>
													<td>${record.staff.name}</td>
													<td>
														<c:choose>
															<c:when test="${record.type == 1}"> 
																<span class="text-success"><s:message code="home.table.result.rewarded" /></span>
															</c:when>
															<c:otherwise>
																<span class="text-danger"><s:message code="home.table.result.fined" /></span>
															</c:otherwise>
														</c:choose></td>
													<td>${record.reason}</td>
													<td>${record.date}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<br>
									<nav aria-label="Page navigation" style="text-align: center;">
										<ul class="pagination" id="pagination"></ul>
										<input type="hidden" id="year" name="year" value=""> 
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
	var limit = 5;

	var year = ${year}

	$(function() {
		window.pagObj = $('#pagination').twbsPagination({
			totalPages : totalPages,
			visiblePages : 10,
			startPage : currentPage,
			onPageClick : function(event, page) {
				if (currentPage != page) {
					$('#year').val(year);
					$('#maxPageItems').val(limit);
					$('#page').val(page);
					$('#form-submit').submit();
				}
			}
		});
	});
</script>
