<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Category</title>
</head>
<body>
	<form action="updateCategory" method="post">
		Current Name: <input type="text" name="oldName" size="25"/>
		New Name: <input type="text" name="newName" size="25"/>
		New Abbreviation: <input type="text" name="abbr" size="25"/>	
		<input type="submit" value="Update" />
	</form>

</body>
</html>