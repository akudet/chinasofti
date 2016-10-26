package demo.model.dao.impl;

import org.springframework.stereotype.Repository;

import demo.model.dao.abst.AbstractDAO;
import demo.model.vo.User;

@Repository
public class UserDAO extends AbstractDAO<User> {
	
	public UserDAO() {
		super(User.class);
	}
	
	public User findOneByName(String name) {
		return findOne("FROM User where name = ?", name);
	}

}
