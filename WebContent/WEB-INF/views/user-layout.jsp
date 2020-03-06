<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ABC Group</title>

		<%@ include file="/WEB-INF/views/web/common/js.jsp" %>
		
		<%@ include file="/WEB-INF/views/web/common/css.jsp" %>
	</head>

	<body>
		<%@ include file="/WEB-INF/views/web/common/nav.jsp" %>
		
		<jsp:include page="${param.view}" />
		
		<%@ include file="/WEB-INF/views/web/common/footer.jsp" %>
	</body>
</html>