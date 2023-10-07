<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bookshelf Home</title>
</head>
<body>

	<form action = "addBookServlet" method="post">
	Author: <input type ="text" name = "author">
	Title: <input type = "text" name = "title">
	Category: <input type = "text" name = "catName">
	<input type = "submit" value="Add Book">
	</form> <br />
	
	
	
	<p><a href = "showBook">Show All Books</a></p>
	<p><a href="showCategory">Show All Categories</a></p>
	<p><a href = "add-category.jsp">Add A Category</a></p>
	

</body>
</html>