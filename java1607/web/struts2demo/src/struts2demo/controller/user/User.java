package struts2demo.controller.user;

public class User {
	
	String username;
	String id;

	public String getId() {
		return id;
	}


	public User(String id, String username) {
		super();
		this.username = username;
		this.id = id;
	}

	public User(String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", id=" + id + "]";
	}



}
