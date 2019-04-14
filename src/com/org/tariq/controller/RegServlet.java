package com.org.tariq.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.tariq.controller.dto.GetsSets;
import com.org.tariq.service.DbManager;


public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StringBuilder csvSkills = new StringBuilder();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hdnParam = request.getParameter("pagename");
		if(hdnParam.equals("register"))
		{
			String fname = request.getParameter("txtFName");
			String lname = request.getParameter("txtLName");
			String gender = request.getParameter("rdoGender");
			String email = request.getParameter("txtEmail");
			String state = request.getParameter("cboStates");
			String password = request.getParameter("txtPassword");
			String age = request.getParameter("cboAge");
			String address = request.getParameter("txtarAddress");
			String skill[] = request.getParameterValues("chkSkills");
			
			for(String skills : skill)
			{
				if(csvSkills.length()>0)
					csvSkills.append(",");
				
				csvSkills.append(skills);
					
				
			}
			String csvSkill = csvSkills.toString();
			
			GetsSets sets = new GetsSets();
			
			sets.setFname(fname);
			sets.setLname(lname);
			sets.setGender(gender);
			sets.setEmail(email);
			sets.setState(state);
			sets.setPassword(password);
			sets.setAge(age);
			sets.setAddress(address);
			sets.setSkill(csvSkill);
			
			try {
				DbManager.Insert(sets);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(hdnParam.equals("login")){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			GetsSets set = new GetsSets();
			set.setEmail(username);
			set.setPassword(password);
			try {
				int checkUser = DbManager.checkUser(set);
				if(checkUser == 1)
				{
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request,response);
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
					rd.forward(request,response);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
