package demo.controller.service;

import demo.model.vo.User;

public interface UserService extends CRUDService<User> {
	
	public User login(String name, String password);
	
}
