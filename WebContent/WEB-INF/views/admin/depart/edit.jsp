<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="main-content">
	<div class="container-fluid">
		<h3 class="page-title">
			<s:message code="depart.edit.title" />
		</h3>
		<div class="row">
			<div class="col-md-12">
				<div>
					<c:url var="action" value="/admin/depart/save" />
					<form:form action="${action}" modelAttribute="depart">
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label><s:message code="depart.id" /></label>
								</div>
								<div class="col-md-10">
									<c:choose>
										<c:when test="${check}">
											<form:input cssClass="form-control" readonly="true" path="id" />
										</c:when>
										<c:otherwise>
											<form:input cssClass="form-control" path="id" />
											<form:errors path="id" cssClass="text-danger" />
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label><s:message code="depart.name" /></label>
								</div>
								<div class="col-md-10">
									<form:input cssClass="form-control" path="name" />
									<form:errors path="name" cssClass="text-danger" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<button class="btn btn-primary">
								<s:message code="depart.save" />
							</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
