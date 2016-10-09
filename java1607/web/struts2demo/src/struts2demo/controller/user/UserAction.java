package struts2demo.controller.user;

import java.util.*;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User("ASD");

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
		return "success";
	}

	public String edit() {
		mUsersMap.put(user.getId(), user);
		return "success";
	}

	@Override
	public User getModel() {
		return user;
	}

	public Collection<User> getUsers() {
		return mUsersMap.values();
	}

	public String login() {
		if ("admin".equals(user.getUsername()) && "123".equals("123")) {
			return "succ";
		}
		return "error";
	}

	public String logout() {
		return "";
	}

}
