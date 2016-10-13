package demo.controller.service.impl;

import demo.model.dao.impl.UserDao;
import demo.model.vo.User;

public class UserServiceImpl extends AbstractCRUDService<User> {
	
	public UserDao mUserDao;

	public UserServiceImpl() {
		super(User.class);
		mUserDao = new UserDao();
	}
	
	public User login(String name, String password) {
		User user = mUserDao.findOneByName(name);
		if (null != user) {
			return user;
		}
		return null;
	}

}
