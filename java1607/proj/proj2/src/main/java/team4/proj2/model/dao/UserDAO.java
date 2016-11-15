package team4.proj2.model.dao;

import team4.proj2.model.vo.User;

public interface UserDAO extends DAO<User> {
	
	public User findOneByName(String name);

}
