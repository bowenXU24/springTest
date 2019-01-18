<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>List Customers</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>


	<div id="container">
		<div id="content">

			<div>
				<!-- button call spring controller mapping -->
				<input type="button" value="Add Customer"
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button" />
			</div>


			<table>

				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<!-- loop oever to print customers -->

				<c:forEach var="tempCustomer" items="${customers}">

					<!-- update link with customer id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
					</c:url>

					<!-- delete link with customer id -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
					</c:url>

					<tr>
						<td>${tempCustomer.firstName }</td>
						<!-- call tempCustomer.getFirstName() -->
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>

						<td>
							<a href="${updateLink}">Update</a> 
							<a href="${deleteLink}" onclick="if (!(confirm('Are u sure?'))) return false">Delete</a>
						</td>
					</tr>

				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>