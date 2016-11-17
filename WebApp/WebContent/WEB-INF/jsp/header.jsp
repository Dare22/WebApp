<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<head>
<title>Spring MVC Form Handling Example</title>

<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
</head>



<spring:url value="/" var="urlHome" />



<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>



<nav class="navbar navbar-inverse">
	<div class="container">

		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Home Page</a>
		</div>

		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><c:if
						test="${pageContext.request.userPrincipal.name != null}">
						<a href="javascript:document.getElementById('logout').submit()">Logout</a>
					</c:if></li>
			</ul>
		</div>
	</div>
</nav>