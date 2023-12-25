<%@page import="entitiess.User"%>
<%@page import="java.util.Iterator"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Complete Data</title>
	</head>
	<body>
		<h1>Details</h1>
		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
			</tr>
			<%
				Iterator i = (Iterator) request.getAttribute("data");
				while(i.hasNext()){
					User user = (User)i.next();
				
			%>
			<tr>
				<td><%= user.getUid() %></td>
				<td><%= user.getUname() %></td>
				<td><%= user.getUemail() %></td>
			</tr>
			<%
				}
			%>
		</table>
	</body>
</html>