package demo.model.dao;

import java.util.*;

import org.springframework.stereotype.Repository;

import demo.model.vo.User;

@Repository
public class UserDAO {
	
	private int id = 0;
	private Map<Integer, User> users = new HashMap<Integer, User>();
	
	public UserDAO() {
		super();
		User u = new User();
		u.setId(1);
		u.setName("jtwu");
		u.setAge(27);
		users.put(u.getId(), u);
	}

	public User get(int id) {
		return users.get(id);
	}
	
	public void add(User user) {
		users.put(id++, user);
	}
	
	public void update(User user) {
		users.put(user.getId(), user);
	}
	
	public void delete(User user) {
		if (users.containsKey(user.getId())) {
			users.remove(user.getId());
		}
	}

}
