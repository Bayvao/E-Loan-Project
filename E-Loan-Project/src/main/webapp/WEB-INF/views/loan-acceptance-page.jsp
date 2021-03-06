<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Loan Acceptance</title>
<style>
.error {
	color: red;
}
</style>
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
		<br />
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

		<h2>Loan Acceptance Form</h2>
		<br />
		<form:form
			action="${pageContext.request.contextPath}/manager/processLoanAcceptance"
			modelAttribute="lAcc">

			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Regional Office:</label>
				<div class="col-sm-10">
					<form:input path="regOffice" placeholder="Regional Office"
						class="form-control" />
					<form:errors path="regOffice" cssClass="error" />
				</div>
			</div>
			<br>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Sanctioning Date:</label>
				<div class="col-sm-10">
					<form:input path="sancDate" value="${d}"
						placeholder="Sanctioned Date" id="sandate" readonly="true" />
				</div>
			</div>
			<br>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Sanctioning Official:</label>
				<div class="col-sm-10">
					<form:input path="sancOffical"
						placeholder="Sanctioning Offical(User name)" class="form-control" />
					<form:errors path="sancOffical" cssClass="error" />
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Application Number:</label>
				<div class="col-sm-10">
					<form:input path="loanId" value="${loanStatus.loan.loanId}"
						placeholder="Loan Id" class="form-control" readonly="true" />
				</div>
			</div>
			<br />
			<div class="form-group row">
				<div class="col-sm-10">
					<button type="submit" class="btn btn-success">Submit</button>
				</div>
			</div>
		</form:form>
	</div>

</body>
</html>