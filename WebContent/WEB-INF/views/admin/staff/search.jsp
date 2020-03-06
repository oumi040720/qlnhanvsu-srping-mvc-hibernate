<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div class="main-content">
	<div class="container-fluid">
		<h3 class="page-title">
			<s:message code="staff.title" />
		</h3>
		<div class="form-group">
			<div class="row">
				<div class="col-md-2">
					<a class="btn btn-success btn-toastr" href="<c:url value="/admin/staff/add" />"><s:message code="staff.add" /></a>
				</div>
				<div class="col-md-4"></div>
				<div class="col-md-6">
					<form action="<c:url value="/admin/staff/search" />" method="post">
						<div class="col-md-9">
							<input class="form-control" style="border-radius: 14px;" type="text" name="k" value="">
						</div>
						<div class="col-md-3">
							<button class="btn btn-primary">
								<s:message code="record.search" />
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<form id="form-submit" action='<c:url value="/admin/staff/search" />'
			method="get">
			<div class="row">
				<div class="col-md-12">
					<div>
						<table class="table table-striped table-hover">
							<thead class="thead-dark">
								<tr>
									<th><s:message code="staff.id" /></th>
									<th><s:message code="staff.photo" /></th>
									<th><s:message code="staff.name" /></th>
									<th><s:message code="staff.gender" /></th>
									<th><s:message code="staff.email" /></th>
									<th><s:message code="staff.phone" /></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${staffs}" var="staff">
									<tr>
										<td>${staff.id}</td>
										<td><img class="img-thumbnail" src="<c:url value="/template/admin/img/staff/${staff.photo}" />" width="70px"></td>
										<td>${staff.name}</td>
										<td>
											<c:choose>
												<c:when test="${staff.gender}">Nam</c:when>
												<c:otherwise>Nữ</c:otherwise>
											</c:choose></td>
										<td>${staff.email}</td>
										<td>${staff.phone}</td>
										<td>
											<c:url var="editURL" value="/admin/staff/edit">
												<c:param name="id" value="${staff.id}" />
											</c:url> 
											<a class="btn btn-info btn-toastr" href="${editURL}"> <i class="fa fa-edit"></i> </a> 
											<c:url var="deleteURL" value="/admin/staff/delete">
												<c:param name="id" value="${staff.id}" />
											</c:url> 
											<a class="btn btn-danger btn-toastr" href="${deleteURL}"> <i class="fa fa-trash-o"></i> </a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<nav aria-label="Page navigation" style="text-align: center;">
							<ul class="pagination" id="pagination"></ul>
							<input type="hidden" id="k" name="k" value=""> 
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
	var limit = 3;

	var k = "${k}";

	$(function() {
		window.pagObj = $('#pagination').twbsPagination({
			totalPages : totalPages,
			visiblePages : 10,
			startPage : currentPage,
			onPageClick : function(event, page) {
				if (currentPage != page) {
					$('#k').val(k);
					$('#maxPageItems').val(limit);
					$('#page').val(page);
					$('#form-submit').submit();
				}
			}
		});
	});
</script>
