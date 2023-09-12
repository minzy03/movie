package test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import test01.User;

public class UserDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public UserDAO () {

		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory =(DataSource) envContext.lookup("jdbc/servletex");

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List selectUserList() {
		List userList = new ArrayList();
		try {
			conn = dataFactory.getConnection();
			String query = " select * from user order by joindate desc ";
			System.out.println("preparedStatement : " + query);
			
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				User user = new User(id,pwd,name,email,joinDate);
				 
				userList.add(user);
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return userList;
		
	}
	
	public void insertUser (User m) {
		try {
			conn = dataFactory.getConnection();
			String id = m.getId();
			String pwd = m.getPwd();
			String name = m.getName();
			String email = m.getEmail();
			String query = "insert into user(id,pwd,name,email)" + " values(?,?,?,?)";
			System.out.println("preparedStatement : " + query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public User selectUserById(String userId) {
		User userInfo = null;
		try {
			conn = dataFactory.getConnection();
			String query = "select * from user where id=?";
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, userId);
			System.out.println(query);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			String id = rs.getString("id");
			String pwd = rs.getString("pwd");
			String name = rs.getString("name");
			String email = rs.getString("email");
			Date joinDate = rs.getDate("joinDate");
			userInfo = new User(id,pwd,name,email,joinDate);
			pstmt.close();
			conn.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
	return userInfo;
}
	
	public void deleteUserById(String id) {
		try {
			conn=dataFactory.getConnection();
			String query = "delete from user where id=?";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

