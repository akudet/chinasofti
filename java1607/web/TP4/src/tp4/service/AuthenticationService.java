package tp4.service;

import tp4.model.dao.UserDao;
import tp4.model.vo.User;

public class AuthenticationService {
	
	public static final int ADMIN_ACCESS = 0;
	public static final int OP_ACESS = 1;
	
	private final UserDao mUserDao = new UserDao();

	public User login(String username, String userpass) {
		User user = mUserDao.findByName(username);

		if(user != null && userpass.equals(user.getUserPass())){
			return user;
		};
		return null;
	}

	public boolean accept(String userId, int access) {
		User user = mUserDao.findById(userId);
		if (null == user) {
			return false;
		}
		
		switch (access) {
		case ADMIN_ACCESS:
			return user.getPrivilege() == User.ADMIN_PRIVILEGE;
		case OP_ACESS:
			return (user.getPrivilege() == User.OP_PRIVILEGE || user.getPrivilege() == User.ADMIN_PRIVILEGE);
		default:
			return false;
		}
	}
	
}
