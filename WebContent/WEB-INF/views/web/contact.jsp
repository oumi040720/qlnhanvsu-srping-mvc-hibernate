<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ include file="/WEB-INF/views/web/common/header2.jsp" %>

<section class="site-section">
	<div class="container-fluid">
		<div class="col-md-12 text-center">
			<h2 class="section-title mb-2">
				<s:message code="global.menu.contact" />
			</h2>
		</div>
		<br>
		<br>
		<div class="col-md-12 text-center">
			<div class="row mb-5 justify-content-center">
				<div class="col-md-8 text-center">
					<div>
						<c:if test="${not empty messageMail}">
							<div class="alert alert-${alertMail} alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<c:set var="success" value="success" />
								<c:set var="danger" value="danger" />
								<c:if test="${alertMail eq success}"> <i class="fa fa-check-circle"></i> </c:if>
								<c:if test="${alertMail eq danger}"> <i class="fa fa-times-circle"></i> </c:if>
								&nbsp;&nbsp; <s:message code="${messageMail}" />
							</div>
							<br>
							<br>
						</c:if>
					</div>
					<form action="<c:url value="/contact/send" />" method="post">
						<div class="form-group row">
							<div class="col-md-2">
								<label class="text-black"><s:message code="global.mail.from" /></label>
							</div>
							<div class="col-md-10">
								<input type="email" class="form-control" name="from" placeholder="From">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-2">
								<label class="text-black"><s:message code="global.mail.to" /></label>
							</div>
							<div class="col-md-10">
								<input type="email" class="form-control" name="to" placeholder="To">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-2">
								<label class="text-black"><s:message code="global.mail.subject" /></label>
							</div>
							<div class="col-md-10">
								<input type="text" class="form-control" name="subject" placeholder="Subject">
							</div>
						</div>
	
						<div class="form-group row">
							<div class="col-md-2">
								<label class="text-black"><s:message code="global.mail.content" /></label>
							</div>
							<div class="col-md-10">
								<textarea name="content" rows="10"></textarea>
								<script src="<c:url value="/template/ckeditor/ckeditor.js" />"></script>
								<script type="text/javascript">
									CKEDITOR.replace('content');
								</script>
							</div>
						</div>
						<br>
						<br>
						<div class="form-group row">
							<div class="col-md-12">
								<button type="submit" class="btn btn-primary">
									<s:message code="global.mail.send" />
								</button>
								<button type="reset" class="btn btn-warning">
									<s:message code="global.mail.reset" />
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>