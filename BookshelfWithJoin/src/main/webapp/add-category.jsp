<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add A Category</title>
</head>
<body>
	<form action="addCategory" method="post">
		Category: <input type="text" name="name" size="25"/>
		Abbreviation: <input type="text" name="abbr" size="5"/>
		<input type="submit" value="Submit" />
	</form>

	<p><a href="index.jsp">Home</a></p>
	<p><a href="showCategory">Show All Categories</a></p>
	<p><a href = "showBook">Show All Books</a></p>
</body>
</html>