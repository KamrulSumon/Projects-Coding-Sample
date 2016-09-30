package com.sumon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	private static final String URL = "jdbc:mysql://localhost:3306/emp_db";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error in loading JDBC Driver");
		}
	}

	public static Connection connect() {
		Connection con = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error in getting JDBC Connection");
		}

		return con;
	}
}
