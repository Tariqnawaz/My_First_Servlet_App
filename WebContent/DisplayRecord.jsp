<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.Iterator" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Record Display Page</title>
</head>
<body>
	<script type="text/javascript">
	
	function editRecord(id)
	{
		url = "EditRecord";
		window.location.href="http://localhost:8080/My_First_Servlet_App/"+url+"?id="+id;
		
	}
	function deleteRecord(id)
	{
		url = "DeleteRecordPath";
		window.location.href="http://localhost:8080/My_First_Servlet_App/"+url+"?id="+id;
		
	}
	</script>
	<table align="center" border="1px" width ="80%">
		<%Iterator itr; %>	
		<%List data = (List) request.getAttribute("EmpData");
		for(itr = data.iterator(); itr.hasNext();){
		%>
		<tr>
		<% String s = (String) itr.next();%>
		<td><%=s %> </td>
		<td><%= itr.next() %> </td>
		<td><%= itr.next() %> </td>
		<td><%= itr.next() %> </td>
		<td><input type="submit" value="Edit" name="edit" onclick="editRecord(<%=s%>);"></td>
		<td><input type="submit" value="Delete" name="delete" onclick="deleteRecord(<%=s%>);"></td>
		<%} %>
		 </tr>
	</table>
</body>
</html>