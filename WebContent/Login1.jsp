<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login1 Page</title>
</head>
<body>
<!-- 
	<script type="text/javascript">
		function validateUsername(){
			var text = document.getElementById("username").value;
			if(text=="")
				{
				document.getElementById("errorusername").innerHTML = Provide UserName ;
				document.getElementById("errorusername").style.color = red;
				}
			else
				{
				document.getElementById("errorusername").innerHTML =  Ok;
				document.getElementById("errorusername").style.color = green;
				}
		}
	
		function validatePassword(){
			var text = document.getElementById("password").value;
			if(text=="")
				{
				document.getElementById("errorpassword").innerHTML = Provide Password ;
				document.getElementById("errorpassword").style.color = red;
				}
			else
				{
				document.getElementById("errorpassword").innerHTML =  Ok;
				document.getElementById("errorpassword").style.color = green;
				}
		}
	</script>
 -->

	<form action="ValidateLogin1Path" name="Adminlogin1" method="post">
		<table>
			<tr>
				<td>User Name :</td>
				<td><input type="text" id="username" name="username"></td>
				
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="text" id="password" name="password"></td>
				
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></td>
				<td></td>
			</tr>
			
		</table>
	</form>
</body>
</html>