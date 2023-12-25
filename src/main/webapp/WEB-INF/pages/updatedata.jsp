<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update data</title>
</head>
<body>
	<h1>Update Data</h1>
	
	<form:form action="updaterecord" method="post" modelAttribute="updateddata">
		ID = <form:input path="uid" id="uid"/>
		Name = <form:input path="uname" id="uname"/>
		Email = <form:input path="uemail" id="uemail"/>
		<input type="submit" id="btn" value="Update"/>
	</form:form>
</body>
</html>