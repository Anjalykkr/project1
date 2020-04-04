<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogIn page</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style2.css">

</head>
<body>
<form:form action="validate" modelAttribute="user" method="POST">
<div class="middle">
<h1>WELCOME</h1>
<h5>${errorMsg}</h5>
<div class="login">
<table>
<tbody>
<!-- <tr><th>Log In</th>
</tr> -->
<tr><th> </th></tr>
<tr>
<td><label>User Name</label></td></tr>
<tr>
<td><form:input path="userName"/></td>
</tr>
<tr>
<td><label>Password</label></td></tr>
<tr>
<td><form:password path="password" /></td>
</tr>
<tr>
<td><label> </label></td>
</tr>
<tr>
<td><input type="submit" value="SUBMIT" class="save"/></td>
</tr>
</tbody>
</table>
</div>
</div>
</form:form>
<%-- <footer style="background-image:url('${pageContext.request.contextPath}/resources/images/bg.jpg'); background-repeat:no-repeat;">
<table>
<tr>
<th>CONTACT US</th>
</tr>
<tr>
<td>
<address>
	Tourism Service<br>
	Skywalk Street,<br>
	M.G.Road,<br>
	Thiruvananthapuram-695001<br>
	Kerala<br>
	India<br><br>
	+91 987 6543217<br>
	+91 471 4251777<br>
<a href="#">tourism@gmail.com</a>
</address>
</td>
</tr>
</table>
</footer> --%>
</body>
</html>