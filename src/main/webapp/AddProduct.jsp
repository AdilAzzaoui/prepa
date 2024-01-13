<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ProductServlet?action=add" method="post">
	Libelle : <input type="text" name="libelle">
	<input type="submit" value="Ajouter">
</form>
<a href="ProductServlet?action=list">List</a>
</body>
</html>