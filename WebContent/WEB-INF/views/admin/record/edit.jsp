<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="main-content">
	<div class="container-fluid">
		<h3 class="page-title">
			<s:message code="record.edit.title" />
		</h3>
		<div class="row">
			<div class="col-md-12">
				<div>
					<c:url var="action" value="/admin/record/save" />
					<form:form action="${action}" modelAttribute="record">
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label><s:message code="record.staff" /></label>
								</div>
								<div class="col-md-10">
									<form:select cssClass="form-control" path="staff.id">
										<form:option value="">
											<s:message code="record.staff.choose" />
										</form:option>
										<c:forEach items="${staffs}" var="item">
											<form:option value="${item.id}">${item.id} - ${item.name}</form:option>
										</c:forEach>
									</form:select>
									<form:errors path="staff" cssClass="text-danger" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label><s:message code="record.type" /></label>
								</div>
								<div class="col-md-10">
									<div class="row">
										<div class="col-md-2">
											<label class="fancy-radio"> 
												<form:radiobutton path="type" value="1" /> <span><i></i>
												<s:message code="record.type.achievement" /></span>
											</label>
										</div>
										<div class="col-md-10">
											<label class="fancy-radio"> 
												<form:radiobutton path="type" value="0" /> <span><i></i>
												<s:message code="record.type.discipline" /></span>
											</label>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label><s:message code="record.reason" /></label>
								</div>
								<div class="col-md-10">
									<form:textarea cssClass="form-control" path="reason" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<form:hidden path="id" />
							<button class="btn btn-primary">
								<s:message code="record.save" />
							</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
