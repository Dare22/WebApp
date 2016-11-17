<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/home.css" />

<jsp:include page="header.jsp" />

</head>
<body>
	<h3>Home Page</h3>

	<sec:authorize url="/admin">
		<div>
			<a href="<c:url value='/admin'/>"><input value="Admin"
				type="Submit" /></a>
		</div>
	</sec:authorize>


</body>

<jsp:include page="footer.jsp" />

</html>