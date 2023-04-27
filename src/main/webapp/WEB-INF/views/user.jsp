<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>User Details</title>
    <style>
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
        #userDetails{
          margin-left: 50px;
          margin-top: 50px;
        }
        #addresses{
            margin-top: 50px;
        }
    </style>
</head>
<body>
    <jsp:include page="fragments/header.jsp" /> 
    <div id="userDetails">
        <div>
            <h1>User Details </h1> <p><a href="<c:url value='/users/${user.id}/updateUser' />">Edit User Details</a></p>
            <p><strong>ID:</strong> <span><c:out value="${user.id}" /></span></p>
            <p><strong>Name:</strong> <span><c:out value="${user.name}" /></span></p>
            <p><strong>Email:</strong> <span><c:out value="${user.email}" /></span></p>
            <p><strong>Role:</strong> <span><c:out value="${user.role}" /></span></p>
        </div>
        <div id="addresses">
            <h1>Address List</h1>
            <table>
                <tr>
                    <th>id</th>
                    <th>Street</th>
                    <th>City</th>
                </tr>
                <c:forEach var="address" items="${user.addresses}">
                    <tr>
                        <td><c:out value="${address.id}" /></td>
                        <td><c:out value="${address.street}" /></td>
                        <td><c:out value="${address.city}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
