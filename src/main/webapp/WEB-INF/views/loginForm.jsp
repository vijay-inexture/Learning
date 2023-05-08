<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        table {
            margin: 0 auto;
        }
        #loginBtn{
            display: block;
            margin: 0 auto;
            margin-top: 10px;
        }
        #createUser{
            padding-top: 20px;
            margin-right: 0px;
        }
        .error {
	        color: red; font-weight: bold;
	    }
    </style>
</head>
<body>
    <form:form action="login" method="post" modelAttribute="credential">
        <table>
            <thead>
                <tr>
                    <th colspan="2"><h1>Login</h1></th>
                </tr>
            </thead>
            <tbody>
            	<tr>
            	<td colspan="2">
            		<c:if test="${not empty param.error}">
				        <label class="error">Invalid username and password.</label>
				    </c:if>
				    <c:if test="${not empty param.logout}">
				        <label class="error">You have been logged out.</label> 
				    </c:if>
				    <c:if test="${not empty message}">
				        <label class="success">${message}</label> 
				    </c:if>
				</td>
            	</tr>
            	
                <tr>
                    <td><label for="username">Username:</label></td>
                    <td><input type="text" name="username" /></td>
                </tr>
                <tr>
                	<td></td>
                	<td><form:errors path="username" cssClass="error" /></td></tr>
                <tr>
                    <td><label for="password">Password:</label></td>
                    <td><input type="password" name="password" /></td>
                </tr>
                <tr>
                	<td></td>
                	<td><form:errors path="password" cssClass="error" /></td></tr>
                <tr></tr>
                <tr></tr>
                <tr>
                    <td colspan="2" ><button id="loginBtn" type="submit">Login</button></td>
                </tr>
                <tr>
                    <td id="createUser" colspan="2" ><a href="createNew">Create New User</a></td>
                </tr>
                <tr>
                    <td colspan="2" ><a href="forgotPassword">Forgot password</a></td>
                </tr>
            </tbody>
        </table>
    </form:form>
</body>
</html>
