<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/admin.css" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/script/jquery-3.1.1.min.js"></script>

<script type="text/javascript">
	$(function() {

		//Close bootstrap alert
		$('.alert-dismissible .close').click(function(e) {
			e.preventDefault();
			$(this).closest('.alert-dismissible').slideUp();
		});

	});
</script>

<jsp:include page="header.jsp" />

</head>
<body>
	<table class="title">

		<tr>
			<td><div class="add-buton">
					<a href="<c:url  value="/newaccount"/>"><button type="button"
							class="btn btn-success  btn-md">Add user</button></a>
				</div></td>
			<td><h1>Administrator Page</h1></td>
			<td class="title-right-text"><c:if test="${not empty msg}">
					<div class="alert alert-${css} alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<strong>${msg}</strong>
					</div>
				</c:if></td>
		</tr>
	</table>

	<div class="all-user-tx">
		<h3>All users</h3>
	</div>

	<%-- 		<td><c:url var="logoutUrl" value="/logout" />
			<sf:form action="${logoutUrl}" method="post">
				<input type="submit" value="Log out" /> <input type="hidden"     //logout for button
					name="${_csrf.parameterName}" value="${_csrf.token}" />
			</sf:form></td>
--%>

	<table class="table table-striped">

		<thead>
			<tr>
				<th>Username</th>
				<th>Password</th>
				<th>Name</th>
				<th>Email</th>
				<th>Type of user</th>
				<th>Enabled</th>
			</tr>
		</thead>

		<c:forEach var="users" items="${usersList}">
			<tr>

				<td><c:out value="${users.username}"></c:out></td>
				<td><c:out value="${users.password}"></c:out></td>
				<td><c:out value="${users.name}"></c:out></td>
				<td><c:out value="${users.email}"></c:out></td>
				<td><c:out value="${users.authority}"></c:out></td>
				<td><c:choose>
						<c:when test="${users.enabled == true}">Yes</c:when>
						<c:otherwise>No</c:otherwise>
					</c:choose></td>


				<td><a href="<c:url  value="/edit?id=${users.id}"/>"><button
							type="button" class="btn btn-primary  btn-block">Edit</button></a></td>

				<td><a href="<c:url value="/delete?id=${users.id}"/>">
						<button type="button" class="btn btn-danger  btn-block"
							onclick="if (confirm('Are you sure you want to delete?')) { form.action='/Config?pg=FIBiller&amp;cmd=delete'; } else { return false; }">Delete</button>
				</a></td>
			</tr>
		</c:forEach>
	</table>
</body>

<jsp:include page="footer.jsp" />

</html>