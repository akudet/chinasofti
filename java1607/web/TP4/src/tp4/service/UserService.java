package tp4.service;

import java.util.*;

import tp4.model.dao.UserDao;
import tp4.model.vo.User;

/**
 * 
 * @author 马厦伟
 * 
 */
public class UserService {

	// 参考 2.11 操作员管理

	private UserDao dao = new UserDao();
	public static final int ERR_USER_NOT_FOUND = 1;

	public int add(String username, String userpass, int privilege) {
		User user = new User(username, userpass, privilege);
		return dao.add(user);
	}

	public int deleteById(String userId) {
		User user = dao.findById(userId);
		if (user.getPrivilege() == User.ADMIN_PRIVILEGE) {
			throw new RuntimeException("不能删除系统管理员");
		}
		
		return dao.deleteById(userId);
	}

	public List<User> findAll() {
		return dao.findAll();
	}

	public User findByName(String username) {
		return dao.findByName(username);
	}

	public int updateById(String userId, String userName, String userPass,
			int privilege) {
		User user = dao.findById(userId);
		if (null == user) {
			return ERR_USER_NOT_FOUND;
		}
		user.setUserName(userName);
		user.setUserPass(userPass);
		user.setPrivilege(privilege);
		return dao.update(user);
	}

	public User findById(String id) {
		return dao.findById(id);
	}
}
