<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div class="main-content">
	<div class="container-fluid">
		<h3 class="page-title">
			<s:message code="depart.title" />
		</h3>
		<div class="form-group">
			<a class="btn btn-success btn-toastr" href="<c:url value="/admin/depart/add" />">
				<s:message code="depart.add" />
			</a>
		</div>
		<div>
			<c:if test="${not empty message}">
				<div class="alert alert-${alert} alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<c:set var="success" value="success" />
					<c:set var="danger" value="danger" />
					<c:if test="${alert eq success}"> <i class="fa fa-check-circle"></i> </c:if>
					<c:if test="${alert eq danger}"> <i class="fa fa-times-circle"></i> </c:if>
					&nbsp;&nbsp; <s:message code="${message}" />
				</div>
			</c:if>
		</div>
		<form id="form-submit" action='<c:url value="/admin/depart/list" />' method="get">
			<div class="row">
				<div class="col-md-12">
					<div>
						<table class="table table-striped table-hover">
							<thead class="thead-dark">
								<tr>
									<th><s:message code="depart.id" /></th>
									<th><s:message code="depart.name" /></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${departs}" var="depart">
									<tr>
										<td>${depart.id}</td>
										<td>${depart.name}</td>
										<td>
											<c:url var="editURL" value="/admin/depart/edit">
												<c:param name="id" value="${depart.id}" />
											</c:url> 
											<a class="btn btn-info btn-toastr" href="${editURL}"> <i class="fa fa-edit"></i> </a> 
											<c:url var="deleteURL" value="/admin/depart/delete">
												<c:param name="id" value="${depart.id}" />
											</c:url> 
											<a class="btn btn-danger btn-toastr" href="${deleteURL}"> <i class="fa fa-trash-o"></i> </a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
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
<script type="text/javascript">
	var totalPages = ${totalPages};
	var currentPage = ${page};
	var limit = 7;

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
