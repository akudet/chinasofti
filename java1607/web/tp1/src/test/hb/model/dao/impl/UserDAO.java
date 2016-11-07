package test.hb.model.dao.impl;

import test.hb.model.vo.User;
import tp1.model.dao.abst.hb.AbstractDAO;

public class UserDAO extends AbstractDAO<User> {
	
	public UserDAO() {
		super(User.class);
	}
	
	public User findOneByName(String name) {
		return findOne("FROM User WHERE name = ?", name);
	}

}
