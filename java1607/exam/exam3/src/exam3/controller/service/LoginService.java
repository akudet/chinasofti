package exam3.controller.service;

import exam3.model.dao.UserDao;
import exam3.model.vo.User;

public class LoginService {
	
	public UserDao mUserDao = new UserDao();
	
	
	public User login(String username, String userpass) {
		User user = mUserDao.findUserByName(username);
		
		if (user != null && user.getUserpass().equals(userpass)) {
			return user;
		}
		
		return null;
	}

	
	public static void main(String[] args) {
		UserDao ud = new UserDao();
		System.out.println(ud.findUserByName("jtwu"));
	}
}
