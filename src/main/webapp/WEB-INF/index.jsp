<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Paginations</title>
	</head>
	<body>
		<div id="ninjas">
		    <h1>Ninjas</h1>
		    
		    <form action="/fake-ninja" method="post">
		    	<input type="submit" value="Insert 1000 Ninja">
		    </form>

		    <c:forEach begin="1" end="${totalPages}" var="index">
		        <a href="/pages/${index}">${index}</a>
		    </c:forEach>

		    <table class="table">
		        <thead>
		            <tr>
			            <th>First Name</th>
			            <th>Last Name</th>
		            </tr>
		        </thead>

		        <tbody>
		            <c:forEach var="ninja" items="${ninjas.content}">                 
			            <tr>
			                <td><c:out value="${ninja.firstName}"></c:out></td>
			                <td><c:out value="${ninja.lastName}"></c:out></td>
			            </tr>
		            </c:forEach>
		        </tbody>
		    </table>
		</div>
	</body>
</html>