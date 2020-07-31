<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Registration Confirmation</title>

<style>
h2 {
	text-align: center;
}
</style>
</head>
<body>

	<h2>User registered successfully!</h2>

	<hr>

	<p>
		<security:authorize access="isAuthenticated()">  
        User: <security:authentication property="principal.username" />
        | Role: <security:authentication
				property="principal.authorities" />
		</security:authorize>

		<!-- Add a logout button -->
		<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">

			<input type="submit" class="btn btn-danger" value="Logout" />

		</form:form>

	</p>

	<a href="${pageContext.request.contextPath}/admin/admin-home">Go to
		home page</a>

</body>
</html>