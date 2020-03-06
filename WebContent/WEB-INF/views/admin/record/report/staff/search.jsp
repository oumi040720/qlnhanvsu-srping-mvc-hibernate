<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div class="main-content">
	<div class="container-fluid">
		<h3 class="page-title">
			<s:message code="record.report.staff.title" /> ${year}
		</h3>
		<div class="row">
			<div class="form-group">
				<div class="col-md-6"></div>
				<div class="col-md-6">
					<form action="<c:url value="/admin/record/report/staff/search" />" method="post">
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
		<form id="form-submit" action='<c:url value="/admin/record/report/staff/search" />' method="get">
			<div class="row">
				<div class="col-md-12">
					<div>
						<table class="table table-striped table-hover">
							<thead class="thead-dark">
								<tr>
									<th><s:message code="staff.photo" /></th>
									<th><s:message code="record.depart" /></th>
									<th><s:message code="home.table.achievement" /></th>
									<th><s:message code="home.table.discipline" /></th>
									<th><s:message code="home.table.result" /></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="row">
									<tr>
										<c:set var="sum" value="${row[2] - row[3]}" />
										<td><img class="img-thumbnail" src="<c:url value="/template/admin/img/staff/${row[4]}" />" width="80px" /></td>
										<td>${row[0]}- ${row[1]}</td>
										<td>${row[2]}</td>
										<td>${row[3]}</td>
										<td>${sum}</td>
										<td>
											<c:if test="${sum > 0}"> <span class="text-success"><s:message code="home.table.result.rewarded" /></span> </c:if> 
											<c:if test="${sum < 0}"> <span class="text-danger"><s:message code="home.table.result.fined" /></span> </c:if> 
											<c:if test="${sum == 0}"> <span> </span> </c:if>
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

<%@ include file="/WEB-INF/views/admin/common/js.jsp"%>
<script type="text/javascript">
	var totalPages = ${totalPages};
	var currentPage = ${page};
	var limit = 3;

	var year = ${year};

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
