package com.org.tariq.controller;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.tariq.database.DatabaseConnection;

/**
 * Servlet implementation class DisplayData
 */
public class DisplayData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query;
		Connection conn;
		Statement stmt;
		ResultSet res;
		DatabaseConnection dbconn;
		List lst = new ArrayList();
		
		try{
			dbconn = new DatabaseConnection();
			conn = dbconn.setConnection();
			stmt =conn.createStatement();
			query = "select * from emp";
			res = dbconn.getResult(query, conn);
			while(res.next())
			{
				lst.add(res.getString("id"));
				lst.add(res.getString("ename"));
				lst.add(res.getString("desg"));
				lst.add(res.getString("sal"));
			}
			
			res.close();
			
		}
		catch(Exception e)
		{
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request,response);
			
		}
		finally
		{
			request.setAttribute("EmpData", lst);
			RequestDispatcher rd = request.getRequestDispatcher("DisplayRecord.jsp");
			rd.forward(request,response);
			
			lst.clear();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}
