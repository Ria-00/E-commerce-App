<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Welcome to OLXLite</h1>
	<p>Signup or Login</p>
	<br>
	<a href="/E-commerce/user/insert"><button>Signup</button></a>
	<br>
	<br>
	<br>
	<form:form action="process" method="post" modelAttribute="user">

		<label for="username">Username:</label>
		<form:input type="text" path="username" />
		<label for="pass">Password:</label>
		<form:input type="password" path="pass" />
		<br>
		<br>
		<input type="submit" value="Login">
		
	</form:form>         

	

</body>
</html>
