package struts2demo.controller.user;

public class UserAction {
	
	private String msg;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private String username;
	private String userpass;
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String login() {
		if ("admin".equals(username) && "123".equals(userpass)) {
			return "succ";
		}
		msg = "登录失败";
		
		System.out.println(user);
		return "error";
	}
	
	public String logout() {
		return "";
	}

}
