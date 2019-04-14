package com.org.tariq.database;

import java.sql.*;

public class DatabaseConnection {
     Connection conn;
     Statement stmt;
     ResultSet res;
     
     public DatabaseConnection()
     {
    	 
     }
     public Connection setConnection()
     {
    	 try{
    		Class.forName("com.mysql.jdbc.Driver");
 			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","");
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
    	 return conn;
     }
     public ResultSet getResult(String sql , Connection conn)
     {
    	 try
    	 {
    		 stmt = conn.createStatement();
    		 res = stmt.executeQuery(sql);
    		 
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
    	 return res;
     }
}
