package struts2demo.controller.user;

public class User {

	String username;
	String id;

	public User(String username) {
		super();
		this.username = username;
	}

	public User(String id, String username) {
		super();
		this.username = username;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", id=" + id + "]";
	}

}
