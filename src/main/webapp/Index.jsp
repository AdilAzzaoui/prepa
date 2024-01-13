<%@page import="java.util.*"%>
<%@page import ="Models.ProductModel" %>

<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(request.getAttribute("list") != null){ %>
		<%ArrayList<ProductModel> list =  (ArrayList<ProductModel>)request.getAttribute("list");%>
		<ul>
		<%for(ProductModel model : list){ %>
			<li>
				<%= model.getId() + " " + model.getLibelle() %>
			</li>
		<%} %>
		</ul>
	<%} %>
</body>
</html>