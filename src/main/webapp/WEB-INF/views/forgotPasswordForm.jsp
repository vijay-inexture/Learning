<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Forgot Password</title>
    <style>
        table {
            margin: 0 auto;
        }
        #resetBtn{
		  display: block;
		  margin-left: 80%;
		  margin-top: 10px;
		}
		.error {
	        color: red; font-weight: bold;
	    }
    </style>
</head>
<body>
	<jsp:include page="fragments/header.jsp" /> 
	<form:form action="forgotPassword" method="POST" modelAttribute="passwordReset">
	  <table>
	  <thead>
            <tr>
                <th colspan="2">
                    <h1>Reset Password</h1>
                </th>
            </tr>
        </thead>
        <tbody>
        	<tr>
            	<td colspan="2">
            		<c:if test="${not empty errorMessage}">
				        <label class="error">${errorMessage}</label>
				    </c:if>
				</td>
            	</tr>
		    <tr>
		      <td><label for="email">Email:</label></td>
		      <td><input type="email" id="email" name="email" value="${passwordReset.email}"></td>
		    </tr>
		    <tr>
		    	<td></td>
		    	<td><form:errors path="email" cssClass="error" /></td>
		    </tr>
		    <tr>
		      <td><label for="password">Current Password:</label></td>
		      <td><input type="password" id="password" name="password" value="${passwordReset.password}"></td>
		    </tr>
		    <tr>
		    	<td></td>
		    	<td><form:errors path="password" cssClass="error" /></td>
		    </tr>
		    <tr>
		      <td><label for="new_password">New Password:</label></td>
		      <td><input type="password" id="newPassword" name="newPassword" value="${passwordReset.newPassword}"></td>
		    </tr>
		    <tr>
		    	<td></td>
		    	<td><form:errors path="newPassword" cssClass="error" /></td>
		    </tr>
		    <tr>
		      <td><label for="confirm_password">Confirm New Password:</label></td>
		      <td><input type="password" id="confirmPassword" name="confirmPassword" value="${passwordReset.confirmPassword}"></td>
		    </tr>
		    <tr>
		    	<td></td>
		    	<td><form:errors path="confirmPassword" cssClass="error" /></td>
		    </tr>
		    <tr>
		    	<td><button id="resetBtn" type="submit">Reset Password</button></td>
		    </tr>
	    </tbody>
	  </table>
  	
</form:form>
</body>
</html>
  