package com.org.tariq.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.tariq.database.DatabaseConnection;

/**
 * Servlet implementation class ValidateLogin1
 */
public class ValidateLogin1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username ,password;
		Connection conn;
		Statement stmt;
		ResultSet res;
		DatabaseConnection dbconn;
		
		try{
			dbconn = new DatabaseConnection();
			conn = dbconn.setConnection();
			stmt = conn.createStatement();
			
			 username = request.getParameter("username");
			 password = request.getParameter("password");
			
			
			stmt = conn.createStatement();
			String  query = "insert into login values ('"+username+"','"+password+"')";
			int i = stmt.executeUpdate(query);
			//String query = "select * from login where username ='"+username+"' and password ='"+password+"'";
			//String query = "select email ,password from register where email = '"+username+"' and password = '"+password+"' " ;
			
			
		}
		catch(Exception e)
		{
			request.setAttribute("Error", e);
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");

		}
		
		finally
		{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request,response);
			
		}
	}

}
