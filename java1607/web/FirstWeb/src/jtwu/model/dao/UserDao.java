package jtwu.model.dao;

import java.sql.*;

import jtwu.model.User;
import jtwu.model.db.DBConnection;

// i kind of understand how this may use(seems good usage for me
// I try to think dao as a way to represent the User mode in database
// so the User model may be a subset, or so projection of the actual
// representation
// actually there got two way of using it, first the customer use the
// User class to talk to database, not the UserDAO e.g.
// we can provide the save, create in the user class,
// the other way is the customer(programmer) use UserDAO class and
// User class, this is the I state at previous, which is the user
// use the DAO to get a projection of actual representation, and use
// User class to wrap the result, em. use DAO to get a User object.
// @ref http://www.corej2eepatterns.com/DataAccessObject.htm
// ok I know the 1st one is not right, the second is a litte wrong
// i think the User is depends on the DAO, which is not, not that much wrong
// this first one just ignore the meaning of dao completely, just try to
// merge this two things together, maybe it's not that bad,
// in User we wrap the operation of data access, we use dao to get this
// this is the projection and representation problem, which I don't know 
// which is better.
public class UserDao {

	// return one user by name, null if not found
	public static User findUserByName(String name) {
		Connection conn = DBConnection.getConnection();
		User user = null;
		
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE name = ?");
			stmt.setString(1, name);
			ResultSet results = stmt.executeQuery();
			if (results.next()) {
				user = new User(results.getString("name"), results.getString("pass"), results.getInt("status"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	// add a user, 0 for sucess
	public int add(User user) {
		Connection conn = DBConnection.getConnection();
		int res = 0;
		
		try {
			
			res = conn.prepareStatement(user.toValues()).executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (res == 1) {
			return 0;
		}
		return 1;
	}
}
