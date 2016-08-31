package jtwu.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jtwu.model.UserData;


public class DBConnection {
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(DBInfo.URL, DBInfo.NAME, DBInfo.PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public static void main(String[] args) {
		UserData.addUserDataToDB();
	}
}
