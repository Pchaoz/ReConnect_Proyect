package com.reConnect.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
	private Connection connection = null;
	private PreparedStatement ps = null; 
	private ResultSet rs = null; 
	//private UserDAO updater;
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		ConnectionDB connDB = new ConnectionDB();
		conn = connDB.connection();
		return conn;
	}
	
	public ArrayList<UserVO> obtainAllUsers(){
		UserVO userVOAux;
		ArrayList<UserVO> userVO = null;
		try {
			userVO = new ArrayList<UserVO>();
			connection = getConnection();
			ps = connection.prepareStatement("SELECT * FROM USER");
			rs = ps.executeQuery();
			System.out.println("Connected sucessfully");
			while(rs.next()) {
				userVOAux = new UserVO();
				userVOAux.setUid(rs.getInt(1));
				userVOAux.setUsername(rs.getString(2));
				userVOAux.setEmail(rs.getString(3));
				userVOAux.setPassword(rs.getString(4));
				userVOAux.setName(rs.getString(5));
				userVOAux.setSurname(rs.getString(6));
				userVO.add(userVOAux);
			}
			return userVO;
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				System.out.println("SQLException ERROR");
			} 
			catch (Exception e) {
				System.out.println("ERROR");
			} 
		}
		return userVO;
	}
	
	public void createUser(UserVO user) {
		try {
			connection = getConnection();
			PreparedStatement psCreateUser = connection.prepareStatement("INSERT INTO USER(USERNAME, EMAIL, PASSWORD, NAME, SURNAME, IMGURL)"
					+ "VALUES(?, ?, ?, ?, ?, ?)");
			psCreateUser.setString(1, user.getUsername());
			psCreateUser.setString(2, user.getEmail());
			psCreateUser.setString(3, user.getPassword());
			psCreateUser.setString(4, user.getName());
			psCreateUser.setString(5, user.getSurname());
			psCreateUser.setString(6, user.getImgUrl());
			psCreateUser.executeUpdate();
		} catch (SQLException e) {
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				System.out.println("SQLException ERROR");
			} 
			catch (Exception e) {
				System.out.println("ERROR");
			} 
		}
	}
	
	public void validateUser(UserVO user) {
		
		try {
			
			connection = getConnection();
			
			PreparedStatement psValidateUser = connection.prepareStatement("SELECT * FROM USER WHERE USERNAME = ? AND PASSWORD = ?");
			
			psValidateUser.setString(1, user.getUsername());
			psValidateUser.setString(2, user.getPassword());
			
			ResultSet rs = psValidateUser.executeQuery();
			
			if (rs.next()) {
				
				System.out.println("Si");
			}else {
				 
				System.out.println("No");
			}
			
		} catch (SQLException e) {
			
			
		}
		
	}
}
