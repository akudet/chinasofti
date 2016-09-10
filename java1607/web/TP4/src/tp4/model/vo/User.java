package tp4.model.vo;

/**
 * 
 * @author 马厦伟
 * 
 */
public class User {
	protected String userId;
	protected String userName;
	protected String userPass;
	protected int privilege;

	public User() {

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
