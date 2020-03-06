<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ABC Group | Log in</title>
		
		<link rel="icon" type="image/png" href='<c:url value='/template/login/images/icons/favicon.ico' />' />
		<link rel="stylesheet" type="text/css" href='<c:url value='/template/login/vendor/bootstrap/css/bootstrap.min.css' />' >
		<link rel="stylesheet" type="text/css" href='<c:url value='/template/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css' />' >
		<link rel="stylesheet" type="text/css" href='<c:url value='/template/login/fonts/iconic/css/material-design-iconic-font.min.css' />' >
		<link rel="stylesheet" type="text/css" href='<c:url value='/template/login/vendor/animate/animate.css' />' >
		<link rel="stylesheet" type="text/css" href='<c:url value='/template/login/vendor/css-hamburgers/hamburgers.min.css' />' >
		<link rel="stylesheet" type="text/css" href='<c:url value='/template/login/vendor/animsition/css/animsition.min.css' />' >
		<link rel="stylesheet" type="text/css" href='<c:url value='/template/login/vendor/select2/select2.min.css' />' >
		<link rel="stylesheet" type="text/css" href='<c:url value='/template/login/vendor/daterangepicker/daterangepicker.css' />' >
		<link rel="stylesheet" type="text/css" href='<c:url value='/template/login/css/util.css' />' >
		<link rel="stylesheet" type="text/css" href='<c:url value='/template/login/css/main.css' />' > 
	</head>

	<body>
		<div class="limiter">
			<jsp:include page="${param.view}" />
		</div>
		
		<script src="<c:url value='/template/login/vendor/jquery/jquery-3.2.1.min.js' />"></script>
		<script src="<c:url value='/template/login/vendor/animsition/js/animsition.min.js' />"></script>
		<script src="<c:url value='/template/login/vendor/bootstrap/js/popper.js' />"></script>
		<script src="<c:url value='/template/login/vendor/bootstrap/js/bootstrap.min.js' />"></script>
		<script src="<c:url value='/template/login/vendor/select2/select2.min.js' />"></script>
		<script src="<c:url value='/template/login/vendor/daterangepicker/moment.min.js' />"></script>
		<script src="<c:url value='/template/login/vendor/daterangepicker/daterangepicker.js' />"></script>
		<script src="<c:url value='/template/login/vendor/countdowntime/countdowntime.js' />"></script>
		<script src="<c:url value='/template/login/js/main.js' />"></script>
	</body>
</html>