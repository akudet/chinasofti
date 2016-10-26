package demo.controller.service.impl;

import demo.model.dao.impl.UserDAO;
import demo.model.vo.User;

public class UserServiceImpl extends AbstractCRUDService<User> {
	
	public UserDAO mUserDao;

	public UserServiceImpl() {
		super(User.class);
		mUserDao = new UserDAO();
	}
	
	public User login(String name, String password) {
		User user = mUserDao.findOneByName(name);
		if (null != user) {
			return user;
		}
		return null;
	}

}
