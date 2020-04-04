<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tour Package Form</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style3.css">


</head>
<body>
<h1>Add Tour Package</h1>
<form:form action="savePackageDetails" modelAttribute="tourPackage" method="POST">
<form:hidden path="id"/>
<div class="add">
<table>
<tbody>
<tr>
<td><label>Tour Package Name</label></td>
<td><form:input path="name"/></td>
<td><form:errors path="name" cssClass="error"></form:errors></td>
</tr>
<tr>
<td><label>From Location</label></td>
<td><form:input path="fromLocation"/></td>
<td><form:errors path="fromLocation" cssClass="error"></form:errors></td>
</tr>
<tr>
<td><label>To Location</label></td>
<td><form:input path="toLocation"/></td>
<td><form:errors path="toLocation" cssClass="error"></form:errors></td>
</tr>
<tr>
<td><label>Number Of Days</label></td>
<td><form:input path="noOfDays"/></td>
<td><form:errors path="noOfDays" cssClass="error"></form:errors></td>
</tr>
<tr>
<td><label>Price</label></td>
<td><form:input path="price"/></td>
<td><form:errors path="price" cssClass="error"></form:errors></td>
</tr>
<tr>
<td><label></label></td>
<td><input type="submit" value="save" class="save"/></td>
</tr>
</tbody>
</table>

<p>
<a href="${pageContext.request.contextPath}/tourPackage/list">back to list</a>
</p>
</div>
</form:form>
</body>
</html>