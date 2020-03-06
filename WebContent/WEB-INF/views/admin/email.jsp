<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<div class="main-content">
	<div class="container-fluid">
		<h3 class="page-title">
			<s:message code="global.mail.title" />
		</h3>
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
			</c:if>
		</div>
		<form action="<c:url value="/admin/email/send" />" method="post">
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<div class="row">
							<div class="col-md-2">
								<s:message code="global.mail.from" />
							</div>
							<div class="col-md-10">
								<input type="email" class="form-control" name="from" placeholder="From">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="row">
							<div class="col-md-2">
								<s:message code="global.mail.to" />
							</div>
							<div class="col-md-10">
								<input type="email" class="form-control" name="to" placeholder="To">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="row">
							<div class="col-md-2">
								<s:message code="global.mail.subject" />
							</div>
							<div class="col-md-10">
								<input type="text" class="form-control" name="subject" placeholder="Subject">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="row">
							<div class="col-md-2">
								<s:message code="global.mail.content" />
							</div>
							<div class="col-md-10">
								<textarea name="content" rows="10"></textarea>
								<script src="<c:url value="/template/ckeditor/ckeditor.js" />"></script>
								<script type="text/javascript">
									CKEDITOR.replace('content');
								</script>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="row">
							<div class="col-md-2"></div>
							<div class="col-md-10">
								<button type="submit" class="btn btn-primary">
									<s:message code="global.mail.send" />
								</button>
								<button type="reset" class="btn btn-warning">
									<s:message code="global.mail.reset" />
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
