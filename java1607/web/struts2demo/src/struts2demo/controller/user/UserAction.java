package struts2demo.controller.user;

import java.util.*;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	
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
		System.out.println(user);
		if ("admin".equals(username) && "123".equals(userpass)) {
			return "succ";
		}
		msg = "登录失败";
		
		
		return "error";
	}
	
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, User> getUsers() {
		return users;
	}

	public void setUsers(Map<String, User> users) {
		UserAction.users = users;
	}

	private static Map<String, User> users = new HashMap<String, User>();
	
	static {
		users.put("1", new User("1", "jtwu"));
		users.put("2", new User("2", "kyo"));
		users.put("3", new User("3", "kyo"));
		users.put("4", new User("4", "kyo"));
		users.put("5", new User("5", "kyo"));
	}
	
	public String edit() {
		user = new User(id, getUsername());
		users.put(id, user);
		return "success";
	}
	
	public String delete() {
		users.remove(id);
		return "success";
	}
	
	public String logout() {
		return "";
	}

}
