package com.reConnect.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostDAO {
	
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
	
	public ArrayList<PostVO> obtainAllPosts(){
		PostVO postVOAux;
		ArrayList<PostVO> postVO = null;
		try {
			postVO = new ArrayList<PostVO>();
			connection = getConnection();
			ps = connection.prepareStatement("SELECT * FROM POST");
			rs = ps.executeQuery();
			System.out.println("Connected sucessfully");
			while(rs.next()) {
				postVOAux = new PostVO();
				postVOAux.setPid(rs.getInt(1));
				postVOAux.setUid(rs.getInt(2));
				postVOAux.setTitle(rs.getString(3));
				postVOAux.setMessage(rs.getString(4));
				postVOAux.setDate(rs.getDate(5));
				postVO.add(postVOAux);
			}
			return postVO;
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
		return postVO;
	}
	
}
