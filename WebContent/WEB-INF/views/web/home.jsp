<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ include file="/WEB-INF/views/web/common/header.jsp" %>

<section class="site-section">
	<div class="container-fluid">
		<div class="col-md-12 text-center">
			<h2 class="section-title mb-2">
				<s:message code="home.title" /> ${year}
			</h2>
		</div>
		<br>
		<div class="col-md-12 text-center">
			<div class="row mb-5 justify-content-center">
				<div class="col-md-9 text-center">
					<div class="form-group">
						<div class="row">
							<div class="col-md-5"></div>
							<div class="col-md-6">
								<form action="<c:url value="/home/search" />" style="width: 100%;" method="post">
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
		<div class="col-md-12 text-center">
			<div class="row mb-5 justify-content-center">
				<div class="col-md-9 text-center">
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
</section>