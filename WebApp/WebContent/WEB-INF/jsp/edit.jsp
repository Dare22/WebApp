<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Account</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/newaccount.css" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/script/jquery-3.1.1.min.js"></script>



<jsp:include page="header.jsp" />

</head>

<body>

	<h3>Edit Account</h3>

	<div class="content">
		<div class="container">
			<div class="center-all">
				<sf:form class="form-horizontal" method="post"
					action="${pageContext.request.contextPath}/edit"
					commandName="users">

					<sf:hidden accesskey="id" id="id" path="id" />

					<spring:bind path="username">

						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Username</label>
							<div class="col-sm-5">
								<sf:input path="username" type="text" class="form-control"
									id="username" placeholder="Username" />
								<sf:errors path="username" class="control-label" />
							</div>
						</div>
					</spring:bind>


					<spring:bind path="password">

						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Password</label>
							<div class="col-sm-5">
								<sf:input path="password" type="text" class="form-control"
									id="password" placeholder="Password" />
								<sf:errors path="password" class="control-label" />
							</div>
						</div>
					</spring:bind>


					<spring:bind path="confirmpass">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Confirm Password:</label>
							<div class="col-sm-5">
								<sf:input path="confirmpass" type="text" class="form-control"
									id="confirmpass" placeholder="Confirm Password" />
								<sf:errors path="confirmpass" class="control-label" />
							</div>
						</div>
					</spring:bind>



					<spring:bind path="name">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Name:</label>
							<div class="col-sm-5">
								<sf:input path="name" type="text" class="form-control" id="name"
									placeholder="Name" />
								<sf:errors path="name" class="control-label" />
							</div>
						</div>
					</spring:bind>




					<spring:bind path="email">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Email:</label>
							<div class="col-sm-5">
								<sf:input path="email" type="text" class="form-control"
									id="email" placeholder="Email" />
								<sf:errors path="email" class="control-label" />
							</div>
						</div>

					</spring:bind>



					<spring:bind path="authority">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Type of user:</label>
							<div class="col-sm-2">
								<sf:select path="authority" class="form-control">
									<sf:option value="" label="--- Select ---" />
									<sf:options items="${type}" />
								</sf:select>
								<sf:errors path="authority" class="control-label" />
							</div>
						</div>
					</spring:bind>



					<spring:bind path="enabled">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Enable user:</label>
							<div class="col-sm-10">
								<div class="checkbox">
									<label> <sf:checkbox path="enabled" id="enabled" />
									</label>
									<sf:errors path="enabled" class="control-label" />
								</div>
							</div>
						</div>
					</spring:bind>


					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button class="btn btn-primary">Update user</button>
						</div>
					</div>


				</sf:form>

			</div>
		</div>
	</div>

</body>

<jsp:include page="footer.jsp" />

</html>