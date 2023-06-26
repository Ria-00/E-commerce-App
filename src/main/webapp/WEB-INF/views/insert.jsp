<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
</head>
<body>
	<h1>Registration Page</h1>
	<br>
	<br>
	<form:form action="insert-process" method="post" modelAttribute="user">
		<label for="fname"> First Name:</label>
		<form:input type="text" path="fname" />
		<br>
		<br>
		<label for="lname">Last Name:</label>
		<form:input type="text" path="lname" />
		<br>
		<br>
		<label for="username">Username:</label>
		<form:input type="text" path="username" />
		<br>
		<br>
		<label for="pass">Password:</label>
		<form:input type="password" path="pass" />
		<br>
		<br>
		<label for="email">Email:</label>
		<form:input type="text" path="email" />
		<br>
		<br>
		<label for="type">Category:</label>
		<form:select path="type">
			<form:options items='${user.types}' />
		</form:select>
		<br>
		<br>

		<input type="submit" value="Submit">
	</form:form>




</body>
</html>