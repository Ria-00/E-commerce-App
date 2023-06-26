<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<link rel="stylesheet" href="/src/main/webapp/resources/style.css">
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>

	<h1>Products</h1>
	<form:form action="checkout" method="post" modelAttribute="product">
		<table>
			<thead>
				<tr>
					<th>Product</th>
					<th>Price</th>
					<th>Category</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="m">
					<tr>
						<td>${m.pname }</td>
						<td>${m.price}</td>
						<td>${m.category}</td>
						<td>${m.desc}</td>
						<td><form:checkbox path="products" value="${m.pname}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<br>
		<input type="submit" value="Buy" />
		<input type="reset" value="clear" />
	</form:form>
	<a></a>
</body>
</html>