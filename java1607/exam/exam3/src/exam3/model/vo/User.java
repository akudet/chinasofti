package exam3.model.vo;

public class User {

	private String username;
	private String userpass;

	public User() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", userpass=" + userpass + "]";
	}

}
