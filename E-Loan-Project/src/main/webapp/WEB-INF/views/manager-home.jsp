<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Manager Home</title>
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

	<div class="container">
		<br />

		<!-- Add a logout button -->
		<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">

			<input type="submit" class="btn btn-danger" value="Logout" />

		</form:form>
		<br />


		<!-- display user name and role -->

		<p>

			<security:authorize access="isAuthenticated()">  
        User: <security:authentication property="principal.username" />
        | Role: <security:authentication
					property="principal.authorities" />
			</security:authorize>
		<hr>
		<p>
			<a href="${pageContext.request.contextPath}/manager/loanDetails">Loan Details</a>
		</p>

		<p>
			<a href="${pageContext.request.contextPath}/manager/seePendingList">Pending
				Loans</a>
		</p>
	</div>
</body>
</html>