<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
	    <title>Header</title>
	    <style>
	    	ul {
	          list-style-type: none;
	          margin: 0;
	          padding: 0 0 0 45%;
	          overflow: hidden;
	          background-color: #f3f3f3;
	        }
	        li {
	          float: left;
	        }
	        li a {
	          display: block;
	          color: black;
	          text-align: center;
	          padding: 14px 16px;
	          text-decoration: none;
	        }
	        li a:hover {
	          background-color: #ddd;
	        }
	    </style>
	</head>
	<body>
	    <header>
	        <nav>
	        	<c:if test="${not empty sessionScope.user}">
	        		<ul>
		        		<li><a href="/springMvc">Home</a></li>
		        		<li><a href='/springMvc/users/${sessionScope.user.id}'>Profile</a></li>
					    <li><a href="/springMvc/logout">Logout</a></li>
					</ul>
	        	</c:if>
				<c:if test="${empty sessionScope.user}">
					<ul>
						<li><a href="/springMvc">Home</a></li>
					   	<li><a href="/springMvc/login">Login</a></li>
					</ul>
				</c:if>
	        </nav>
	    </header>
	</body>
</html>
