<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Loan List</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>


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
		<div>
			<h2>List Of All Loans</h2>
		</div>

		<form:form action="${pageContext.request.contextPath}/manager/searchLoan"
			method="POST" class="form-inline mr-auto">
			<input class="form-control mr-sm-2" type="text" placeholder="Search"
				aria-label="Search" name="search" id="search">
			<button class="btn btn-outline-success btn-rounded btn-sm my-0"
				type="submit">Search</button>
		</form:form>
		
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th scope="col">Loan Number</th>
					<th scope="col">Term Of Loan</th>
					<th scope="col">Payment Start Date</th>
					<th scope="col">Loan End Date</th>
					<th scope="col">Interest Rate</th>
					<th scope="col">Monthly Payment Amount</th>
					<th scope="col">View Acceptance Details</th>
					<th scope="col">View Payment Details</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listLoan}" var="loan">
					<tr>
						<td scope="row">${loan.loanNumber}</td>
						<td>${loan.termOfLoan}</td>
						<td>${loan.repaymentStartDate}</td>
						<td>${loan.loanClosureDate}</td>
						<td>${loan.interestRate}</td>
						<td>${loan.monthlyPaymentAmount}</td>
						<td><a
							href="${pageContext.request.contextPath}/manager/loanAcceptanceDetail?id=${loan.loanNumber}">View
								Details</a></td>
						<td><a
							href="${pageContext.request.contextPath}/manager/viewPaymentDetails?id=${loan.loanNumber}">View
								Details</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>