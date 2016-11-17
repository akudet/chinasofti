package team4.proj1.service.impl.security;

import team4.proj1.model.dao.impl.jdbc.UserDAOImpl;
import team4.proj1.model.vo.admin.User;
import team4.proj1.service.include.security.AuthenticationService;

/**
 * 
 * @author 巫金桐
 *
 */
public class AuthenticationServiceImpl implements AuthenticationService {
	
	private final UserDAOImpl mUserDao = new UserDAOImpl();

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
