<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div class="main-content">
	<div class="container-fluid">
		<h3 class="page-title">
			<s:message code="record.title" />
		</h3>
		<div class="row">
			<div class="form-group">
				<div class="col-md-2">
					<a class="btn btn-success btn-toastr" href="<c:url value="/admin/record/add" />"><s:message code="record.add" /></a>
				</div>
				<div class="col-md-4"></div>
				<div class="col-md-6">
					<form action="<c:url value="/admin/record/search" />" method="post">
						<div class="col-md-8">
							<select class="form-control" name="year">
								<option value="0"><s:message code="record.year" /></option>
								<c:forEach items="${years}" var="year">
									<option value="${year}">${year}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-4">
							<button class="btn btn-primary">
								<s:message code="record.search" />
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<br>
		<form id="form-submit" action='<c:url value="/admin/record/list/search" />' method="get">
			<div class="row">
				<div class="col-md-12">
					<div>
						<table class="table table-striped table-hover">
							<thead class="thead-dark">
								<tr>
									<th><s:message code="record.staff" /></th>
									<th><s:message code="record.type" /></th>
									<th><s:message code="record.reason" /></th>
									<th><s:message code="record.date" /></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${records}" var="record">
									<tr>
										<td>${record.staff.name}</td>
										<td><c:choose>
												<c:when test="${record.type == 1}">
													<span class="text-success"><s:message code="home.table.result.rewarded" /></span>
												</c:when>
												<c:otherwise>
													<span class="text-danger"><s:message code="home.table.result.fined" /></span>
												</c:otherwise>
											</c:choose></td>
										<td>${record.reason}</td>
										<td>${record.date}</td>
										<td>
											<c:url var="editURL" value="/record/edit">
												<c:param name="id" value="${record.id}" />
											</c:url> 
											<a class="btn btn-info btn-toastr" href="${editURL}"> <i class="fa fa-edit"></i> </a> 
											<c:url var="deleteURL" value="/record/delete">
												<c:param name="id" value="${record.id}" />
											</c:url> 
											<a class="btn btn-danger btn-toastr" href="${deleteURL}"> <i class="fa fa-trash-o"></i> </a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
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

<script type="text/javascript">
	var totalPages = ${totalPages};
	var currentPage = ${page};
	var limit = 7;
	
	var year = ${year};

	$(function() {
		window.pagObj = $('#pagination').twbsPagination({
			totalPages : totalPages,
			visiblePages : 10,
			startPage : currentPage,
			onPageClick : function(event, page) {
				if (currentPage != page) {
					$('#maxPageItems').val(limit);
					$('#year').val(year);
					$('#page').val(page);
					$('#form-submit').submit();
				}
			}
		});
	});
</script>
