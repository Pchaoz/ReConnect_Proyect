package com.reConnect.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	private String connectionURL =  "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11415013";
	private	String user = "sql11415013";
	private String password = "xMclkcp8AF";
	/**
	 * Metode encarregat de connectar a la base de dades alocada en una pagina externa
	 * @return
	 * @throws SQLException
	 */
	public Connection connection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(connectionURL, user, password);
		return conn;
	}
}