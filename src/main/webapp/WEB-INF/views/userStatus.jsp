<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
    <title>User</title>
    <style>
        #userStatus {
            margin-left: 50px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
    <div id="userStatus">  
        <h1>User created with ID: <span>${userId}</span></h1>
        <p>View user details <a href="users/${userId}">click here</a></p>
    </div>
</body>
</html>
