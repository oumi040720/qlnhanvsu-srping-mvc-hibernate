<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ABC Group | Admin</title>
		
		<%@ include file="/WEB-INF/views/admin/common/js.jsp" %>
		
		<%@ include file="/WEB-INF/views/admin/common/css.jsp" %>
	</head>

	<body>
		<div id="wrapper">
			<%@ include file="/WEB-INF/views/admin/common/header.jsp" %>
			
			<%@ include file="/WEB-INF/views/admin/common/nav.jsp" %>
			
			<div class="main">
				<jsp:include page="${param.view}" />
			</div>
		</div>
	</body>
</html>