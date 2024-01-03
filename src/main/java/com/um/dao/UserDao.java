package com.um.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;
import com.um.model.User;

public class UserDao 
{
	private static String url ="jdbc:mysql://localhost:3306/03dec";
	private static String username="root";
	private static String password ="Jaya@9866";
	private static String insert="insert into user(name,email,city) values(?,?,?)";
	private static String display="select * from user";
	private static String delete="delete from user where id = ?";
	private static String selectUserById="select * from user where id = ?";
	private  static Connection cn = null;
	private  static PreparedStatement ps = null;
	private static java.sql.Statement s= null;
	
	public static void insert(User u)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url,username,password);
			ps=cn.prepareStatement(insert);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getCity());
			ps.executeUpdate();	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null)
			{
				try 
				{
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(cn!=null)
			{
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	public static ArrayList<User> display()
	{
		ArrayList<User> al= new ArrayList<User>();

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url,username,password);
			s= cn.createStatement();
			ResultSet rs= s.executeQuery(display);
			while(rs.next())
			{
				int id =rs.getInt("id");
				String name =rs.getString("name");
				String email=rs.getString("email");
				String city=rs.getString("city");
				User u = new User(id, name, email, city);
				al.add(u);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null)
			{
				try 
				{
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(cn!=null)
			{
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return al;
		
	}
	public static void delete(int id)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url,username,password);
			ps=cn.prepareStatement(delete);
			ps.setInt(1,id);
			ps.executeUpdate();	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null)
			{
				try 
				{
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(cn!=null)
			{
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	public  static User selectUserById( int id )
	{
		 User u= null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url,username,password);
			ps=cn.prepareStatement(selectUserById);
			ps.setInt(1,id);
	        ResultSet rs= ps.executeQuery();
	        int id1 =rs.getInt("id");
	        String name=rs.getString("name");
	        String email=rs.getString("email");
	        String city=rs.getString("city");
	       u= new User(id,name,email,city);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null)
			{
				try 
				{
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(cn!=null)
			{
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return u;
		
		
	
		
	}
	
		
		

}
