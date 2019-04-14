<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.org.tariq.controller.ValidateLogin"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<%
	String user = (String) session.getAttribute("sessionUserName");
	%>
	hello  <%= user %>..!!
	<h4>:::::::Employees:::::::</h4>
	<ul>
		<li><a href="InsertRecord.jsp">Create New Employee</a></li>
		<li><a href="DisplayDataPath">Display Employee</a></li>
	</ul>
	
	<h4>:::::::here i have used a new tutorail program:::::::</h4>
	<ul>
		<li><a href="Register.jsp">Registration Form</a></li>
		<li><a href="Login1.jsp">Login Form</a></li>
		
	</ul>
	
</body>
</html>