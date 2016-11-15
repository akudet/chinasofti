package exam3.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exam3.model.db.DBConnection;
import exam3.model.vo.User;

public class UserDao {

	
	public User findUserByName(String name) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM user WHERE username=?;";
		
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, name);
			rs = pre.executeQuery();
			
			if (rs.next()) {
				return map(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private User map(ResultSet rs) throws SQLException {
		User user = new User();
		user.setUsername(rs.getString("username"));
		user.setUserpass(rs.getString("userpass"));
		return user;
	}
	
}
