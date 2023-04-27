<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
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
    </style>
</head>
<body>
	<form action="forgotPassword" method="POST">
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
		      <td><label for="email">Email:</label></td>
		      <td><input type="email" id="email" name="email" ></td>
		      <td><span id="emailError" style="color: red; display: none;">Invalid email address</span></td>
		    </tr>
		    <tr>
		      <td><label for="password">Current Password:</label></td>
		      <td><input type="password" id="password" name="password" ></td>
		      <td><span id="emailError" style="color: red; display: none;">Invalid password</span></td>
		    </tr>
		    <tr>
		      <td><label for="new_password">New Password:</label></td>
		      <td><input type="password" id="newPassword" name="newPassword" ></td>
		    </tr>
		    <tr>
		      <td><label for="confirm_password">Confirm New Password:</label></td>
		      <td><input type="password" id="confirmPassword" name="confirmPassword" ></td>
		      <td><span id="emailError" style="color: red; display: none;">New Password not match with new Password</span></td>
		    </tr>
		    <tr>
		    	<td><button id="resetBtn" type="submit">Reset Password</button></td>
		    </tr>
	    </tbody>
	  </table>
  	
</form>
</body>
</html>
  