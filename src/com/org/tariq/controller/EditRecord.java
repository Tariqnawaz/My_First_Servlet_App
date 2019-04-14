package com.org.tariq.controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.tariq.database.DatabaseConnection;


public class EditRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn;
		Statement stmt;
		ResultSet res = null;
		DatabaseConnection dbconn;
		
		String id , query;
		 
		try
		{
			id = request.getParameter("id");
			dbconn = new DatabaseConnection();
			conn = dbconn.setConnection();
			stmt = conn.createStatement();
			query = "select * from emp where id = " +id;
			res = dbconn.getResult(query, conn);
			
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			request.setAttribute("EditData",res);
			RequestDispatcher rd = request.getRequestDispatcher("EditData.jsp");
			rd.forward(request,response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
