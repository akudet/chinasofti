package jtwu.controller.service;


import jtwu.model.User;
import jtwu.model.dao.UserDao;

public class UpdateUserService {
	UserService mUserService;

	public int updateUserName(User user) {
		return mUserService.updateUser(user);
	}

	public UpdateUserService(UserService mUserService) {
		super();
		this.mUserService = mUserService;
	}
}
