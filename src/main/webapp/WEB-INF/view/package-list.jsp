<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tour Packages</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style1.css">

</head>
<body>
<div class="middle">

<input type="button" value="Add Tour Package" onclick="window.location.href='showFormForAdd';return false;" class="add-button"/>
<input type="button" value="Search Location" onclick="window.location.href='showFormForSearch';return false;" class="add-button"/>

<table>
<tr>
<th>Package Name</th>
<th>From Location</th>
<th>To Location</th>
<th>Number Of Days</th>
<th>Price</th>
<th>Action</th>
</tr>

<c:forEach var="tempPackage" items="${tourPackage}">
<c:url var="updateLink" value="/tourPackage/showFormForUpdate">
<c:param name="id" value="${tempPackage.id}"></c:param>
</c:url>
<c:url var="deleteLink" value="/tourPackage/showFormForDelete">
<c:param name="id" value="${tempPackage.id}"></c:param>
</c:url>
<tr>
<td>${tempPackage.name}</td>
<td>${tempPackage.fromLocation}</td>
<td>${tempPackage.toLocation}</td>
<td>${tempPackage.noOfDays}</td>
<td>${tempPackage.price}</td>
<td><a href="${updateLink}">Update </a>|<a href="${deleteLink}"> Delete</a></td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>