<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout</title>
<link rel="stylesheet" href="/src/main/webapp/resources/style.css">
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>

	<h1>Products Bought</h1>
		<table>
			<thead>
				<tr>
					<th>Product</th>
					<th>Category</th>
					<th>Description</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="m">
					<tr>
						<td>${m.pname }</td>
						<td>${m.category}</td>
						<td>${m.desc}</td>
						<td>${m.price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		
	<a href="/E-commerce/"><button>Back to home</button></a>
</body>
</html>