<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>update User Details</title>
    <style>
        #createUser table {
            margin: 0 auto;
        }
        #createBtn{
            display: block;
            margin-left: 20%;
            margin-top: 10px;
        }
        #addresses table {
            border-collapse: collapse;
        }

        #addresses th, #addresses td {
            text-align: left;
            padding: 8px;
            border: 1px solid black;
        }

        #addresses th {
            background-color: #dddddd;
        }
        #addresses{
            margin-top: 50px;
        }
        #userDetails{
            margin-left: 50px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<div>
    <jsp:include page="fragments/header.jsp" /> 
    <c:if test="${update != null}">
	<div id="userDetails">
		<div>
			<form action="" method="post">
				<table>
					<thead>
						<tr>
							<th colspan="2"><h1>Update User Details</h1></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><label for="name">Name:</label></td>
							<td><input type="text" name="name" value="${user.name}"></td>
						</tr>
						<tr>
							<td><label for="email">Email:</label></td>
							<td><input type="email" name="email" value="${user.email}"></td>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<td colspan="2"><button type="submit">Update User</button></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		<div id="addresses">
			<h1>Address List</h1>
			<table>
				<tr>
					<th>id</th>
					<th>Street</th>
					<th>City</th>
					<th></th>
					<th></th>
				</tr>
				<c:forEach items="${user.addresses}" var="address">
					<tr>
						<td>${address.id}</td>
						<td>${address.street}</td>
						<td>${address.city}</td>
						<td><a href="<c:url value='/users/${user.id}/address/${address.id}'/>">Edit</a></td>
						<td>
							<button type="button" onclick="deleteAddress('${user.id}', '${address.id}')">Delete</button>
							<script>
								function deleteAddress(userId, addressId) {
									if (confirm('Are you sure you want to delete this address?')) {
										fetch('address/' + addressId, {
											method: 'DELETE'
										})
										.then(response => {
											if (response.ok) {
												location.reload();
												console.log('Address deleted successfully');
											} else {
												console.log('Error deleting address');
											}
										})
										.catch(error => {
											console.log('Error deleting address');
										});
									}
								}
							</script>
						</td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<a href="<c:url value='/users/${user.id}/address'/>">Add New Address</a>
		</div>
	</div>
</c:if>
    
		<div id="createUser">
		    <c:if test="${empty update}">
		        <form action="users" method="post">
		            <table>
		                <thead>
		                    <tr>
		                        <th colspan="2">
		                            <h1>User Form</h1>
		                        </th>
		                    </tr>
		                </thead>
		                <tbody>
		                    <tr>
		                        <td><label for="name">Name:</label></td>
		                        <td><input type="text" name="name"/></td>
		                    </tr>
		                    <tr>
		                        <td><label for="email">Email:</label></td>
		                        <td><input type="email" id="email" name="email"></td>
		                    </tr>
		                    <tr>
		                        <td><label for="password">Password:</label></td>
		                        <td><input type="password" id="password" name="password"></td>
		                    </tr>
		                    <tr>
		                        <td></td>
		                        <td><button id="createBtn" type="submit">Create</button></td>
		                    </tr>
		                </tbody>
		            </table>
		        </form>
		    </c:if>
		</div>
</div>
</body>
</html>
			            