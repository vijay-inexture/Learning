<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    </style>
</head>
<body>
    <form action="login" method="post">
        <table>
            <thead>
                <tr>
                    <th colspan="2"><h1>Login</h1></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><label for="email">Email:</label></td>
                    <td><input type="email" id="email" name="email"></td>
                </tr>
                <tr>
                    <td><label for="password">Password:</label></td>
                    <td><input type="password" id="password" name="password"></td>
                </tr>
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
    </form>
</body>
</html>
