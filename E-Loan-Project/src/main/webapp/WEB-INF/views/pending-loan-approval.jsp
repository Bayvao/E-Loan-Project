<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Pending List</title>

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
			<h2>List of Pending Approvals</h2>
			</div>
			<br/>
			
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th scope="col">Loan ID</th>
					<th scope="col">Loan Type</th>
					<th scope="col">Loan Amount</th>
					<th scope="col">Loan Date</th>
					<th scope="col">View Details</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listPendingLoan}" var="pLoan">
					<tr>
						<td scope="row">${pLoan.loan.loanId}</td>
						<td>${pLoan.loan.loanType}</td>
						<td>${pLoan.loan.loanAmount}</td>
						<td>${pLoan.loan.loanDate}</td>
						<td><a
							href="${pageContext.request.contextPath}/manager/detailView?id=${pLoan.statusId}">View
								Details</a></td>
						<td><a
							href="${pageContext.request.contextPath}/manager/approveLoan?id=${pLoan.statusId}">Approve</a>
							| <a
							href="${pageContext.request.contextPath}/manager/rejectLoan?id=${pLoan.statusId}">Reject</a>

						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>