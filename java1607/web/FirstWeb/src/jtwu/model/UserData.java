package jtwu.model;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.*;

import jtwu.model.db.DBConnection;

/** 
 * class used to generate some facked user data
 * @author Administrator
 *
 */
public class UserData {

	public static List<User> createUsers() {
		 List<User> users = new ArrayList<User>();
			
			users.add(new User("jtwu", "jtwu", User.AUTH_SUCC));
			users.add(new User("jtwu1", "jtwu", User.AUTH_REJECT));
			users.add(new User("jtwu2", "jtwu", User.AUTH_PENDING));
			
			return users;
	}
	
	public static boolean addUserDataToDB() {
		Connection conn = DBConnection.getConnection();
		try {
			conn.prepareStatement("drop table if exists users;").execute();
			conn.prepareStatement(User.createStatement()).execute();
			
			List<User> users = createUsers();
			for (User user : users) {
				user.saveToDB(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
