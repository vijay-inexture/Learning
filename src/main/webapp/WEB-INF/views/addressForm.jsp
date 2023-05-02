<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Address Form</title>
	<style>
		table {
			margin: 0 auto;
		}
		#submitBtn{
			display: block;
			margin: 0 auto;
			margin-top: 10px;
		}
		#address{
			padding-top: 20px;
			margin-right: 0px;
		}
		.error {
	        color: red; font-weight: bold;
	    }
	</style>
</head>
<body>
	<jsp:include page="fragments/header.jsp"></jsp:include>
	<div id="address">
		<form:form action="" method="post" modelAttribute="address">
			<table>
				<thead>
					<tr>
						<th colspan="2">
							<h1>Address Form</h1>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><label for="streat">Street:</label></td>
						<td><input type="text" id="street" name="street" value="${address.street}"/></td>
					</tr>
					 <tr>
	                	<td></td>
	                	<td><form:errors path="street" cssClass="error" /></td></tr>
	                <tr>
					<tr>
						<td><label for="city">City:</label></td>
						<td><input type="text" id="city" name="city" value="${address.city}"/></td>
					</tr>
					 <tr>
	                	<td></td>
	                	<td><form:errors path="city" cssClass="error" /></td></tr>
	                <tr>
					<tr></tr>
					<tr>
						<td colspan="2" >
							<button id="submitBtn" type="submit">Submit</button>
						</td>
					</tr>
				</tbody>
			</table>    
		</form:form>
	</div>
</body>
</html>
