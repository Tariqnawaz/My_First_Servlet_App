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


public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id , ename ,desg ,sal;
		String query;
		
		Connection conn;
		Statement stmt;
		ResultSet res;
		DatabaseConnection dbconn;
		

		try{
			dbconn = new DatabaseConnection();
			
			
			id = request.getParameter("id");
			ename= request.getParameter("ename");
			desg = request.getParameter("desg");
			sal = request.getParameter("sal");
			
			conn = dbconn.setConnection();
			stmt = conn.createStatement();
			query = "update emp set ename ='"+ename+"', desg='"+desg+"', sal='"+sal+"' where id = '" +id+"' " ;
			int i = stmt.executeUpdate(query);
			
		}
		catch(Exception e)
		{
			request.setAttribute("Error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request,response);
		}
		finally
		{
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request,response);
			
		}
	}

}
