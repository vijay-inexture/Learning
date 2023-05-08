<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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
		        <ul>
		            <li><a href="<c:url value="/"/>">Home</a></li>
		            <sec:authorize access="!isAuthenticated()">
		                <li><a href="<c:url value="/login"/>">Login</a></li>
		            </sec:authorize>
		            <sec:authorize access="isAuthenticated()">
		                <li><a href="<c:url value="/logout" />" onclick="event.preventDefault(); document.getElementById('logout-form').submit();">Logout</a></li>
		            </sec:authorize>
		        </ul>
		    </nav>
		    <form id="logout-form" action="<c:url value='/logout' />" method="post">
		        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		    </form>
	    </header>
	</body>
</html>
