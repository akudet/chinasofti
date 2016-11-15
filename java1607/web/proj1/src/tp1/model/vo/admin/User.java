package tp1.model.vo.admin;

import java.sql.ResultSet;
import java.sql.SQLException;

import tp1.model.vo.ValueObject;

/**
 * 
 * @author 马厦伟
 * 
 */
public class User extends ValueObject {
	protected String userId;
	protected String userName;
	protected String userPass;
	protected int privilege;
	
	public static int ADMIN_PRIVILEGE = 0;
	public static int OP_PRIVILEGE = 1;
	
	public User() {

	}

	public User(String userName, String userPass, int privilege) {
		super();
		this.userId = randomId();
		this.userName = userName;
		this.userPass = userPass;
		this.privilege = privilege;
	}

	public User(String userId, String userName, String userPass, int privilege) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.privilege = privilege;
	}

	public int getPrivilege() {
		return privilege;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPass() {
		return userPass;
	}

	@Override
	public void map(ResultSet rs) throws SQLException {
		userId = rs.getString("user_id");
		userName = rs.getString("username");
		userPass = rs.getString("userpass");
		privilege = rs.getInt("privilege");
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	@Override
	public String toString() {
		return "UserDao [userId=" + userId + ", userName=" + userName
				+ ", userPass=" + userPass + ", privilege=" + privilege + "]";
	}

}
