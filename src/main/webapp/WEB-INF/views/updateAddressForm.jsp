<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Address Form</title>
    <style>
        table {
            margin: 0 auto;
        }
        #createBtn{
		  display: block;
		  margin: 0 auto;
		  margin-top: 10px;
		}
		#createAddress{
			padding-top: 20px;
			margin-right: 0px;
		}
    </style>
</head>
<body>
	<jsp:include page="fragments/header.jsp" />
	<div id="createAddress">
	    <form action="" method="post">
	    	<input type="hidden" name="_method" value="put" />
		    <table>
			    <thead>
		            <tr>
		                <th colspan="2"><h1>Update Address Form</h1></th>
		            </tr>
	        	</thead>
	        	<tbody>
			        <tr>
			            <td><label for="streat">Street:</label></td>
			            <td><input type="text"  name="street" value="${address.street}"/></td>
			        </tr>
			        <tr>
			            <td><label for="city">City:</label></td>
			            <td><input type="text" name="city" value="${address.city}"/></td>
			        </tr>
			        <tr></tr>
			        <tr>
			           <td colspan="2" >
			               <button id="createBtn" type="submit">Update Address</button>
			           </td>
			        </tr>
		        </tbody>
		    </table>    
	     </form>
     </div>
</body>
</html>
