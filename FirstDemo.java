package org.oar.firstApp;

import java.sql.*;


public class FirstDemo 
{
public static void main(String []args)
{
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("loaded and registered");
		
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");
			System.out.println("connection established");
			
		  stmt= con.createStatement();  
		  
		   String sql="create table employee(eid int,ename varchar(20),address varchar(30),phone int)";
		   String sql1="insert into employee values(300,'CGI','WHITEFIELD',119568)";
		   System.out.println("inserted");
		   
		   stmt.execute(sql1);
		   System.out.println("executed");
		   
		   rs=stmt.executeQuery("select * from employee"); 
		   while(rs.next()){  
			   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));  
			   }  
		   
		   
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
