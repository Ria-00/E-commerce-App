<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
<style >table, th, td {
  border: 1px solid black;
}</style>
</head>
<body>
	<h1>Products</h1>
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
				</tr>
			</c:forEach>
		</tbody>

	</table>
	<a href="/E-commerce/"><button>Back to home</button></a>
</body>
</html>