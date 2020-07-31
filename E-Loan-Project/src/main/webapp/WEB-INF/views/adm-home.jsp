<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Admin Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	Welcome ADMIN

	<div class="container">
		<br />

		<p>

			<!-- Add a logout button -->
			<form:form action="${pageContext.request.contextPath}/logout"
				method="POST">

				<input type="submit" class="btn btn-danger" value="Logout" />

			</form:form>
			<br />
		<p>

			<security:authorize access="isAuthenticated()">  
        User: <security:authentication property="principal.username" />
        | Role: <security:authentication
					property="principal.authorities" />
			</security:authorize>

		</p>
		<hr />
		<div>
			<a href="${pageContext.request.contextPath}/admin/regitserUserPage">Register
				New User</a>
		</div>
		<br>
		<div>
			<a href="${pageContext.request.contextPath}/admin/ChangePasswordPage">Change
				Password</a>
		</div>
		<br>
		<div>
			<a href="${pageContext.request.contextPath}/admin/DeleteUserPage">Delete
				User</a>
		</div>
	</div>

</body>
</html>