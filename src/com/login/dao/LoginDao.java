package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class LoginDao {
	String sql="select * from login where uname=? and pass=?";
	String url="jdbc:mysql://localhost:3306/db";
	String username="root";
	String password="Ta@123";
     public boolean ischeck(String uname,String pass) throws ClassNotFoundException, SQLException {
    	 Class.forName("com.mysql.jdbc.Driver");
    	 
    	Connection con=(Connection) DriverManager.getConnection(url,username,password);
    	PreparedStatement st=((java.sql.Connection) con).prepareStatement(sql);
    	st.setString(1,uname);
    	st.setString(2, pass);
    	ResultSet rs=st.executeQuery();
    	if(rs.next()) {
    		return true;
    	}
    	return false; 
     }
}
