package tp4.model.vo;
/**
 * 
 * @author 马厦林
 *
 */
public class User {
	protected String userId;
	protected String userName;
	protected String userPass;
	protected int privilege;
	public User() {
		
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public int getPrivilege() {
		return privilege;
	}
	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}
	@Override
	public String toString() {
		return "UserDao [userId=" + userId + ", userName=" + userName
				+ ", userPass=" + userPass + ", privilege=" + privilege + "]";
	}
	public User(String userId, String userName, String userPass,
			int privilege) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.privilege = privilege;
	}
	
}
