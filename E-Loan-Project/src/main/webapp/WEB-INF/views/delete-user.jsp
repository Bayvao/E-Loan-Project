<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Delete User</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>
h2 {
	text-align: center;
}
</style>
</head>
<body>

	<div class="container">
		<br />
		<!-- Add a logout button -->
		<form:form class="form-inline"
			action="${pageContext.request.contextPath}/logout" method="POST">

			<input type="submit" class="btn btn-danger" value="Logout" />

		</form:form>
		<br /> <br />
		<!-- display user name and role -->

		<p>

			<security:authorize access="isAuthenticated()">
                User:
                <security:authentication property="principal.username" />
                | Role:
                <security:authentication
					property="principal.authorities" />
			</security:authorize>
		</p>

		<hr>
		<h2>Delete User</h2>


		<form:form
			action="${pageContext.request.contextPath}/admin/processDeleteUser"
			modelAttribute="deleteUser">

			<br>

			<div>
				<!-- Check for registration error -->
				<c:if test="${deleteError != null}">

					<div class="alert alert-danger col-xs-offset-1 col-xs-10">
						${deleteError}</div>

				</c:if>

			</div>

			<br>

			<div class="form-group row">
				<label class="col-sm-2 col-form-label">UserName To Delete</label>
				<div class="col-sm-10">
					<form:input path="userName" placeholder="UserName to delete"
						class="form-control" value="" />
				</div>
			</div>

			<br>

			<div class="form-group row">
				<div class="col-sm-10">
					<button type="submit" class="btn btn-success">Delete User</button>
				</div>
			</div>

		</form:form>
	</div>
</body>
</html>