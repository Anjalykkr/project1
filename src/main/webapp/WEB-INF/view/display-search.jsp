<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Result</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style4.css">

</head>
<body>
<h1>Your Search Results</h1>
	<div class = "container">
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>FROM-LOCATION</th>
			<th>TO-LOCATION</th>
			<th>NO:OFDAYS</th>
			<th>PRICE</th>
			
		</tr>
		<c:forEach var = "tempEntry" items = "${resultList}" >
			<tr>
				<td>${tempEntry.id}</td>
				<td>${tempEntry.name}</td>
				<td>${tempEntry.fromLocation}</td>
				<td>${tempEntry.toLocation}</td>
				<td>${tempEntry.noOfDays}</td>
				<td>${tempEntry.price}</td>
			</tr>
		</c:forEach>
		</table>
		</div>
</body>
</html>