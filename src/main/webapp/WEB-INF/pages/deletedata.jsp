<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Delete Data</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	</head>

	<body>
		<form:form action="deleterecord" method="post" modelAttribute="deleterId">
			ID = <form:input path="uid" id="uid"/>
			<input type="submit" value="Delete" id="btn"/>
		</form:form>
	</body>
</html>