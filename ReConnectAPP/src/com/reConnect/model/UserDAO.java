package com.reConnect.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
	/*
	 * Metode per a crear un ArrayList de UserVO amb tots el usuaris de la base de dades
	 */
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
		}
		return userVO;
	}
	/*
	 * Metode per a registrar el usuari a la base de dades
	 */
	public boolean createUser(UserVO user) {
		try {
			connection = getConnection();
			PreparedStatement psCreateUser = connection.prepareStatement("INSERT INTO USER(USERNAME, EMAIL, PASSWORD, NAME, SURNAME, IMGURL)" + " VALUES(?, ?, ?, ?, ?, ?)");
			psCreateUser.setString(1, user.getUsername());
			psCreateUser.setString(2, user.getEmail());
			psCreateUser.setString(3, user.getPassword());
			psCreateUser.setString(4, user.getName());
			psCreateUser.setString(5, user.getSurname());
			psCreateUser.setString(6, user.getImgUrl());
			psCreateUser.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return false;
		}
	}
	/*
	 * Metode per a validar el usuari a la hora de iniciar sessió
	 */
	public boolean validateUser(UserVO user) {
		
		boolean check = false;
		
		try {
			connection = getConnection();
			PreparedStatement psValidateUser = connection.prepareStatement("SELECT * FROM USER WHERE USERNAME = ? AND PASSWORD = ?");
			psValidateUser.setString(1, user.getUsername());
			psValidateUser.setString(2, user.getPassword());
			ResultSet rs = psValidateUser.executeQuery();
			if (rs.next()) {
				check = true;
			}else {
				check = false;
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return check;
	}
	
	/*
	 * Metode que actualitza al usuari en la base de dades
	 */
	public boolean userUpdater(UserVO user) {
	
		try {
			
			connection = getConnection();
			
			PreparedStatement psUpdateUser = connection.prepareStatement("UPDATE USER SET USERNAME = ?, EMAIL = ?, PASSWORD = ?, NAME = ?, SURNAME = ?, IMGURL = ? WHERE UID = ?");
			
			psUpdateUser.setString(1, user.getUsername());
			psUpdateUser.setString(2, user.getEmail());
			psUpdateUser.setString(3, user.getPassword());
			psUpdateUser.setString(4, user.getName());
			psUpdateUser.setString(5, user.getSurname());
			psUpdateUser.setString(6, user.getImgUrl());
			psUpdateUser.setInt(7, user.getUid());
			
			psUpdateUser.executeUpdate();
			return true;
		
		}catch (SQLException e) {
			
			System.out.println(e.getMessage());
			return false;

		}
		
	}
	/*
	 * Metode per a carregar tota la informació del usuari una vegada iniciada sessió o registrarse
	 */
	public UserVO loadUser(UserVO user) {
		try {
			connection = getConnection();
			PreparedStatement psLoadUser = connection.prepareStatement("SELECT * FROM USER WHERE USERNAME LIKE ?");
			psLoadUser.setString(1, user.getUsername());
			rs = psLoadUser.executeQuery();
			while(rs.next()) {
				user.setUid(Integer.parseInt(rs.getString(1)));
				user.setUsername(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setName(rs.getString(5));
				user.setSurname(rs.getString(6));
				user.setImgUrl(rs.getString(7));
			}
		} catch (SQLException e) {			
		}
		return user;
	}
}
