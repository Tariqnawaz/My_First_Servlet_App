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
import javax.servlet.http.HttpSession;

import com.org.tariq.database.DatabaseConnection;
 
public class ValidateLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username ,password;
		Connection conn;
		Statement stmt;
		ResultSet res;
		DatabaseConnection dbconn;
		
		try{
			dbconn = new DatabaseConnection();
			conn = dbconn.setConnection();
			
			 username = request.getParameter("username");
			 password = request.getParameter("password");
			 HttpSession session = request.getSession();
			stmt = conn.createStatement();
			String query = "select * from login where username ='"+username+"' and password ='"+password+"'";
			//String query = "select email ,password from register where email = '"+username+"' and password = '"+password+"' " ;
			res = dbconn.getResult(query, conn);
			if(res.next())
			{
				System.out.println("inside");
				session.setAttribute("sessionUserName",username);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request,response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request,response);
			}
			
		}
		catch(Exception e)
		{
			request.setAttribute("Error", e);
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");

		}
		/*
		finally
		{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request,response);
			
		}*/
	}

}
