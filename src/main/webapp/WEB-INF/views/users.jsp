<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>User List</title>
    <style>
    	#users {
    		margin-top: 50px;
    		margin-left: 50px;
    	}
    	table {
	        border-collapse: collapse;
	    }
	    
	    th, td {
	        text-align: left;
	        padding: 8px;
	        border: 1px solid black;
	    }
	    
	    th {
	        background-color: #dddddd;
	    }	 
    </style>
</head>
<body>
	<jsp:include page="fragments/header.jsp" /> 
	<div id="users">
	<h1>User List </h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Role</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id}" /></td>
            <td><c:out value="${user.name}" /></td>
            <td><c:out value="${user.email}" /></td>
            <td><c:out value="${user.role}" /></td>
            <td>
                <a href="<c:url value='/users/' /><c:out value='${user.id}' />">View</a>
                <a href="<c:url value='/users/' /><c:out value='${user.id}' />/updateUser">Edit</a>
                
				<button type="button" onclick="deleteUser(${user.id})">Delete</button>
				
				<!-- AJAX function to delete user -->
				<script>
				    function deleteUser(userId) {
				        if (confirm('Are you sure you want to delete this user?')) {
				            fetch('users/'+userId+'/deleteUser', {
				                method: 'DELETE'
				            })
				            .then(response => {
				                if (response.ok) {
				                	location.reload();
				                    console.log('User deleted successfully');
				                } else {
				                    console.log('Error deleting user');
				                }
				            })
				            .catch(error => {
				                console.log('Error deleting user');
				            });
				        }
				    }
				</script>
                
                <!-- <a href="<c:url value='/users/' /><c:out value='${user.id}' />/deleteUser">Delete</a> -->
            </td>
        </tr>
        </c:forEach>
    </table>
    <br>
    <a href="<c:url value='/userform' />">Create New User</a>
    </div>
</body>
</html>
