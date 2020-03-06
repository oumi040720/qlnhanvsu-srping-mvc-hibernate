<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div class="main-content">
	<div class="container-fluid">
		<h3 class="page-title">
			<s:message code="home.title" /> ${year}
		</h3>
		<div class="row">
			<div class="form-group">
				<div class="col-md-6"></div>
				<div class="col-md-6">
					<form action="<c:url value="/admin/home/search" />" method="post">
						<div class="col-md-8">
							<select class="form-control" name="year">
								<option value=""><s:message code="record.year" /></option>
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
		<div class="row">
			<div class="col-md-12">
				<div>
					<table class="table table-striped table-hover">
						<thead class="thead-dark">
							<tr>
								<th><s:message code="home.table.photo" /></th>
								<th><s:message code="home.table.staff" /></th>
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
				</div>
			</div>
		</div>
	</div>
</div>
