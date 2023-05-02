<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                    <td><label for="email">Email:</label></td>
                    <td><input type="text" name="email" /></td>
                </tr>
                <tr>
                	<td></td>
                	<td><form:errors path="email" cssClass="error" /></td></tr>
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
                    <td id="createUser" colspan="2" ><a href="userform">Create New User</a></td>
                </tr>
                <tr>
                    <td colspan="2" ><a href="forgotPasswordForm">Forgot password</a></td>
                </tr>
            </tbody>
        </table>
    </form:form>
</body>
</html>
