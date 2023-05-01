<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<title>Address Form</title>
	<style>
		table {
			margin: 0 auto;
		}
		#createBtn{
			display: block;
			margin: 0 auto;
			margin-top: 10px;
		}
		#createAddress{
			padding-top: 20px;
			margin-right: 0px;
		}
	</style>
</head>
<body>
	<jsp:include page="fragments/header.jsp"></jsp:include>
	<div id="createAddress">
		<form action="" method="post">
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
						<td><input type="text" id="street" name="street"/></td>
					</tr>
					<tr>
						<td><label for="city">City:</label></td>
						<td><input type="text" id="city" name="city"/></td>
					</tr>
					<tr></tr>
					<tr>
						<td colspan="2" >
							<button id="createBtn" type="submit">Create Address</button>
						</td>
					</tr>
				</tbody>
			</table>    
		</form>
	</div>
</body>
</html>
