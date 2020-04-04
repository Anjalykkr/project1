<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style3.css">

</head>
<body>
<form:form action="processSearch" modelAttribute="formData" method="POST">
<div class="add">
<table>
<tbody>
<tr>
<td><label>From Location</label></td>
<td><form:input path="locationA"/></td>
</tr>
<tr>
<td><label>To Location</label></td>
<td><form:input path="locationB"/></td>
</tr>
<tr>
<td><label></label></td>
<td><input type="submit" value="search" class="save"/></td>
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