<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="container-login100" style="background-image: url('<c:url value='/template/login/images/bg-01.jpg' />');">
	<div class="wrap-login100">
		<form class="login100-form validate-form" action='<c:url value="/login" />' method="post">
			<span class="login100-form-logo">
				<i class="zmdi zmdi-landscape"></i>
			</span>
			<span class="login100-form-title p-b-34 p-t-27">Login</span>
			<div class="wrap-input100 validate-input" data-validate = "Enter username">
				<input class="input100" type="text" name="username" value="" placeholder="Username">
				<span class="focus-input100" data-placeholder="&#xf207;"></span>
			</div>
			
			<div class="wrap-input100 validate-input" data-validate="Enter password">
				<input class="input100" type="password" name="password" value="" placeholder="Password">
				<span class="focus-input100" data-placeholder="&#xf191;"></span>
			</div>
					
			<div>
				<c:if test="${not empty message}">
					<div class="alert alert-danger alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							<i class="fa fa-times-circle"></i> ${message}
					</div>
				</c:if>
			</div>
						
			<div class="container-login100-form-btn">
				<button class="login100-form-btn" type="submit" name="action" value="login">Login</button>
			</div>
		</form>
	</div>
</div>
