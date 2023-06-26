<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
</head>
<body>
<h1>Posting new Advertisement</h1>
<br>
<br>
<form:form action="add-process" method="post" modelAttribute="product">
<label for="sname"> Seller Name:</label>
		<form:input type="text" path="sname" />
		<br>
		<br>
		<label for="category">Category:</label>
		<form:input type="text" path="category" />
		<br>
		<br>
		<label for="pname">Product name:</label>
		<form:input type="text" path="pname" />
		<br>
		<br>
		<label for="qty">Quantity:</label>
		<form:input type="text" path="qty" />
		<br>
		<br>
		<label for="desc">Product Desc:</label>
		<form:input type="text" path="desc" />
		<br>
		<br>
		<label for="price">Product Price:</label>
		<form:input type="text" path="price" />
		<br>
		<br>
		
		<input type="submit" value="Post Advert">
</form:form>




</body>
</html>