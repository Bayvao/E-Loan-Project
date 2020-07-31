<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Payment Details</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<style>
caption {
	text-align: center;
}

h2 {
	text-align: center;
}
</style>
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

			<br />
		<div>
			<h2>Payment Details</h2>
		</div>
		<br />

		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th scope="col">Payment Id</th>
					<th scope="col">Loan Number</th>
					<th scope="col">Amount Paid</th>
					<th scope="col">Mode Of Payment</th>
					<th scope="col">Cheque Or Draft Number</th>
					<th scope="col">Date Of Payment</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pay}" var="pay">
					<tr>
						<td scope="row">${pay.paymentId}</td>
						<td>${pay.loanNumber}</td>
						<td>${pay.amountPaid}</td>
						<td>${pay.modeOfPayment}</td>
						<td>${pay.chequeOrDraftNumber}</td>
						<td>${pay.dateOfPayment}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>