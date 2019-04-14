<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Record</title>
</head>
<body>
	<form action="InsertDataPath" method="post">
	<table>
		<tr>
			<td align="right">ID :</td>
			<td><input type="text" name ="id"></td>	
		</tr>
		<tr>
			<td align="right">Name :</td>
			<td><input type="text" name ="ename"></td>	
		</tr>
	    <tr>
			<td align="right">Designation :</td>
			<td><input type="text" name ="desg"></td>	
		</tr>
		<tr>
			<td align="right">Salary :</td>
			<td><input type="text" name ="sal"></td>	
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value ="submit"></td>	
		</tr>
	</table>
	</form>
</body>
</html>