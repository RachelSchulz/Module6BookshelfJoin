<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categories</title>
</head>
<body>
	All Categories:
	<table>
		<c:forEach items="${requestScope.allItems}" var="currentCategory">
			<tr>
				<td>${currentCategory.categoryName}|</td>
				<td>${currentCategory.abbreviation}</td>
			</tr>
		</c:forEach>
	</table>
	<p><a href="index.jsp">Home</a></p>
	<p><a href="add-category.jsp">Add Another Category</a></p>
	<p><a href="update-category.jsp">Update A Category</a></p>
</body>
</html>