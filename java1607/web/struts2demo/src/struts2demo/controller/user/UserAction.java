package struts2demo.controller.user;

import java.util.*;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User("ASD");

	private String mErrMsg;
	
	public String getErrMsg() {
		return mErrMsg;
	}

	public User getUser() {
		return user;
	}

	private static Map<String, User> mUsersMap = new HashMap<String, User>();

	static {
		mUsersMap.put("1", new User("1", "jtwu"));
		mUsersMap.put("2", new User("2", "kyo"));
		mUsersMap.put("3", new User("3", "kyo"));
		mUsersMap.put("4", new User("4", "kyo"));
		mUsersMap.put("5", new User("5", "kyo"));
	}

	public String delete() {
		mUsersMap.remove(user.getId());
		return index();
	}

	// return an edit page for editing a user
	// the user to edit can obtains by getUser
	public String edit() {
		user = mUsersMap.get(user.getId());
		return "edit";
	}

	@Override
	public User getModel() {
		System.out.println(user.getUsername());
		return user;
	}
	
	public String put() {
		mUsersMap.put(user.getId(), user);
		return index();
	}

	public Collection<User> getUsers() {
		return mUsersMap.values();
	}
	
	// return an page to show users
	public String index() {
		return "index";
	}

	public String login() {
		System.out.println(user);
		if ("admin".equals(user.getUsername())) {
			return "index";
		}
		
		mErrMsg = "登录失败";
		return "login";
	}

	public String logout() {
		return "";
	}

}
