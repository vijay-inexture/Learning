<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <style>
    	#error {
    		margin-left: 50px;
    		margin-top: 50px;
    	}
    </style>
</head>
<body>
	<div id="error">
	    <h1>Error</h1>
	    <p>${errorMessage}</p>
	    <p>${errorDescription}</p>
    </div>
</body>
</html>
