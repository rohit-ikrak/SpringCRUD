<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SearchById</title>
</head>
<body>
	<form:form action="searchrecord" method="post" modelAttribute="userid">
		ID = <form:input path="uid" />	
		<input type="submit" value="Search" id="btn"/>
	</form:form>
</body>
</html>