<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Data</title>
</head>

<body>
	<h1>Insert Data</h1>
	<form:form action="insertrecord" method="post" modelAttribute="userdata">
		ID = <form:input path="uid" id="uid" />
		Name = <form:input path="uname" id="uname" />
		Email = <form:input path="uemail" id="uemail" />
		<input type="submit" id="btn" value="INSERT" />
	</form:form>
</body>
</html>