package demo.controller.service.impl;

import demo.controller.service.UserService;
import demo.model.dao.impl.UserDAO;
import demo.model.vo.User;

public class UserServiceImpl extends AbstractCRUDService<User> implements UserService {
	
	public UserDAO mUserDAO;

	public UserServiceImpl() {
		mUserDAO = new UserDAO();
		init(mUserDAO);
	}
	
	public User login(String name, String password) {
		User user = mUserDAO.findOneByName(name);
		if (null != user) {
			return user;
		}
		return null;
	}

}
