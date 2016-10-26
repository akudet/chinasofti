package tp1.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import tp1.model.db.DBConnection;
import tp1.model.vo.User;

/**
 * 
 * @author 马厦伟
 * 
 */
public class UserDAO extends DAO<User>{
	private static final int DATE_PAGE = 5;
	Connection con = null;
	PreparedStatement pre = null;
	ResultSet res = null;
	@Override
	public List<User> findAll(int pageNo) {
		List<User> list = new ArrayList<User>();
		
		String sql = "select * from user limit ?,?";
		
		try {
			con = DBConnection.getConnection();
			pre = con.prepareStatement(sql);
			pre.setInt(1, (pageNo - 1) * DATE_PAGE);
			pre.setInt(2, DATE_PAGE);
			
			res = pre.executeQuery();
			while(res.next()){
				User user = new User();
				user.setUserId(res.getString(1));
				user.setUserName(res.getString(2));
				user.setUserPass(res.getString(3));
				user.setPrivilege(res.getInt(4));
				list.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


	

	@Override
	public int getTotalPage() {
		int count = 0;
		String sql = "select count(*) from user";
		
		try {
			con = DBConnection.getConnection();
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			
			while (res.next()) {
				count = res.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count = (int) Math.ceil((count + 1.0 - 1.0) / DATE_PAGE);
		return count;
	}

	// 添加数据
	public int add(User user) {
		con = DBConnection.getConnection();
		String sql = "insert into user values(?,?,?,?)";

		try {
			pre = con.prepareStatement(sql);

			pre.setString(1, user.getUserId());
			pre.setString(2, user.getUserName());
			pre.setString(3, user.getUserPass());
			pre.setInt(4, user.getPrivilege());

			int i = pre.executeUpdate();

			if (i > 0) {
				return i;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre);
		}
		return 0;
	}

	public int addAll(Collection<User> users) {
		for (User user : users) {
			if (0 != add(user)) {
				return -1;
			}
		}
		return 0;
	}

	public int deleteAll() {
		con = DBConnection.getConnection();
		String sql = "delete from user";

		try {
			pre = con.prepareStatement(sql);
			int i = pre.executeUpdate();
			if (i > 0) {
				return i;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre);
		}

		return 0;
	}

	public int deleteById(String userId) {
		con = DBConnection.getConnection();
		String sql = "delete from user where userid = ?";

		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, userId);
			int i = pre.executeUpdate();
			if (i > 0) {
				return i;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre);
		}

		return 0;
	}

	// 查询数据
	public ArrayList<User> findAll() {
		con = DBConnection.getConnection();
		String sql = "select * from user";
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			ArrayList<User> list = new ArrayList<User>();
			while (res.next()) {
				User user = new User(res.getString("userid"),
						res.getString("username"), res.getString("userpass"),
						res.getInt("privilege"));

				list.add(user);
			}
			return list;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, res);
		}

		return null;

	}

	// 删除数据
	// 单查询
	public User findById(String userId) {
		con = DBConnection.getConnection();
		String sql = "select * from user where userid=?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, userId);
			res = pre.executeQuery();
			if (res.next()) {
				User user = new User(res.getString("userid"),
						res.getString("username"), res.getString("userpass"),
						res.getInt("privilege"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, res);
		}
		return null;
	}

	public User findByName(String userName) {
		con = DBConnection.getConnection();
		String sql = "select * from user where username=?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, userName);
			res = pre.executeQuery();
			if (res.next()) {
				User user = new User(res.getString("userid"),
						res.getString("username"), res.getString("userpass"),
						res.getInt("privilege"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, res);
		}
		return null;
	}

	// 修改
	public int update(User user) {
		con = DBConnection.getConnection();
		String sql = "update user set username = ?,userpass = ?,privilege=? where userid= ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, user.getUserName());
			pre.setString(2, user.getUserPass());
			pre.setInt(3, user.getPrivilege());
			pre.setString(4, user.getUserId());

			int i = pre.executeUpdate();
			if (i > 0) {
				return i;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre);
		}
		return 0;
	}

}
