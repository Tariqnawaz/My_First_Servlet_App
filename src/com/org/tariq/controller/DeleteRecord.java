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

 
public class DeleteRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn;
		Statement stmt;
		ResultSet res ;
		DatabaseConnection dbconn;
		
		String id , query;
		
		try
		{
			id = request.getParameter("id");
			dbconn = new DatabaseConnection();
			conn = dbconn.setConnection();
			stmt = conn.createStatement();
			query = "delete from emp where id ='" +id+"' ";
			//res = dbconn.getResult(query, conn);
			int i = stmt.executeUpdate(query);
			
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			//request.setAttribute("EditData",res);
			RequestDispatcher rd = request.getRequestDispatcher("DisplayDataPath");
			rd.forward(request,response);
		}
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	}

}
