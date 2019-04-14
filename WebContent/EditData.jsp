<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Data</title>
</head>
<body>
	<form action="UpdateDataPath" method="post">
	<table align="center" border="1px" widht="80%">
		
			<%ResultSet res = (ResultSet) request.getAttribute("EditData"); %>
			<%if(res.next()){
				%>
				<tr>
					<td>ID</td>
					<td><input type ="text" name ="id" value=<%= res.getString("id") %>></td>
				<tr>
				<tr>
					<td>Name</td>
					<td><input type ="text" name ="ename" value=<%= res.getString("ename") %>></td>
				<tr>
				<tr>
					<td>Designation</td>
					<td><input type ="text" name ="desg" value=<%= res.getString("desg") %>></td>
				<tr>
				<tr>
					<td>Salary</td>
					<td><input type ="text" name ="sal" value=<%= res.getString("sal") %>></td>
				<tr>
				<tr>
					<td></td>
					<td><input type ="submit" name ="update" value="Update"></td>
				<tr>
			<%} %>
		
	</table>
	</form>
</body>
</html>