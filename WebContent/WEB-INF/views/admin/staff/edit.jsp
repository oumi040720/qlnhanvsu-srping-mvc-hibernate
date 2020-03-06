<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="main-content">
	<div class="container-fluid">
		<h3 class="page-title">
			<s:message code="staff.edit.title" />
		</h3>
		<div class="row">
			<div class="col-md-12">
				<div>
					<c:url var="action" value="/admin/staff/save" />
					<form:form action="${action}" modelAttribute="staff" enctype="multipart/form-data">
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label><s:message code="staff.id" /></label>
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
									<label><s:message code="staff.name" /></label>
								</div>
								<div class="col-md-10">
									<form:input cssClass="form-control" path="name" />
									<form:errors path="name" cssClass="text-danger" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label><s:message code="staff.gender" /></label>
								</div>
								<div class="col-md-10">
									<div class="row">
										<div class="col-md-2">
											<label class="fancy-radio"> <form:radiobutton path="gender" value="true" /> 
												<span><i></i> <s:message code="staff.male" /></span>
											</label>
										</div>
										<div class="col-md-2">
											<label class="fancy-radio"> <form:radiobutton path="gender" value="false" /> 
												<span><i></i> <s:message code="staff.female" /></span>
											</label>
										</div>
									</div>
									<form:errors path="gender" cssClass="text-danger" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label><s:message code="staff.birthday" /></label>
								</div>
								<div class="col-md-10">
									<form:input cssClass="form-control" path="birthDay" />
									<form:errors path="birthDay" cssClass="text-danger" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label><s:message code="staff.photo" /></label>
								</div>
								<div class="col-md-10">
									<div class="input-group input-file" name="fichier">
										<span class="input-group-btn">
											<button class="btn btn-default btn-choose" type="button">
												<s:message code="staff.choose" />
											</button>
										</span>
										<form:input cssClass="form-control" path="photo"
											placeholder='Choose a file...' />
										<span class="input-group-btn">
											<button class="btn btn-warning btn-reset" type="button">
												<s:message code="staff.reset" />
											</button>
										</span>
									</div>
									<form:errors path="photo" cssClass="text-danger" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label><s:message code="staff.email" /></label>
								</div>
								<div class="col-md-10">
									<form:input cssClass="form-control" path="email" />
									<form:errors path="email" cssClass="text-danger" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label><s:message code="staff.phone" /></label>
								</div>
								<div class="col-md-10">
									<form:input cssClass="form-control" path="phone" />
									<form:errors path="phone" cssClass="text-danger" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label><s:message code="staff.salary" /></label>
								</div>
								<div class="col-md-10">
									<form:input cssClass="form-control" path="salary" />
									<form:errors path="salary" cssClass="text-danger" />
									<span class="text-danger" id="salary-number-error"></span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label><s:message code="staff.notes" /></label>
								</div>
								<div class="col-md-10">
									<form:textarea cssClass="form-control" path="notes" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label><s:message code="staff.depart" /></label>
								</div>
								<div class="col-md-10">
									<form:select cssClass="form-control" path="depart.id">
										<form:option value="">
											<s:message code="staff.depart.choose" />
										</form:option>
										<c:forEach items="${departs}" var="row">
											<form:option value="${row.id}">${row.name}</form:option>
										</c:forEach>
									</form:select>
									<form:errors path="depart" cssClass="text-danger" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<button class="btn btn-primary">
								<s:message code="staff.save" />
							</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	function bs_input_file() {
		$(".input-file").before(function() {
			if (!$(this).prev().hasClass('input-ghost')) {
				var element = $("<input type='file' class='input-ghost' accept='image/*' style='visibility:hidden; height:0'>");
				element.attr("name", $(this).attr("name"));
				element.change(function() {
					element.next(element).find('input').val((element.val()).split('\\').pop());
				});
								
				$(this).find("button.btn-choose").click(function() {
					element.click();
				});
								
				$(this).find("button.btn-reset").click(function() {
					element.val(null);
					$(this).parents(".input-file").find('input').val('');
				});
								
				$(this).find('input').css("cursor", "pointer");
								
				$(this).find('input').mousedown(function() {
					$(this).parents('.input-file').prev().click();
						return false;
					});
					
				return element;
			}
		});
	}

	$(function() {
		bs_input_file();
	});
</script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#salary").attr({
			"type" : "number",
		});
	});
</script>

