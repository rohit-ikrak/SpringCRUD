<%@page import="entitiess.User"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
	<title>Search Result</title>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<script>
	$("document").ready(function(){
		$("#btn").click(function(){
			window.location.replace("searchbyid");
		});
	});
</script>
<body>
	
	<% 
		Iterator i = (Iterator) request.getAttribute("searchresult");
		while(i.hasNext()){
			User user = (User) i.next();
	%>		
	<h3>Search Result for ID(<%= user.getUid() %>) is here</h3>
		
	<% 
			out.println("User Id = " + user.getUid() + "<br>" +
					" User Name = "	+ user.getUname() + "<br>" + 
					" User Email = " + user.getUemail());
		
		}
	%>
	<br/><br />
	<input type="button" value="GO BACK"  id="btn" />
</body>
</html>