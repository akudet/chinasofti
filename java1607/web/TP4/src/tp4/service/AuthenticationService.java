package tp4.service;

import tp4.model.dao.UserDao;
import tp4.model.vo.User;

public class AuthenticationService {
	
	private final UserDao mUserDao = new UserDao();

	public User login(String username, String userpass) {
		User user = mUserDao.findByName(username);

		if(user != null && userpass.equals(user.getUserPass())){
			return user;
		};
		return null;
	}
	
}
