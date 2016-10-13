package demo.model.dao.impl;

import java.util.List;

import demo.model.vo.User;

public class UserDao extends AbstractDAO<User> {
	
	public UserDao() {
		super(User.class);
	}
	
	public User findOneByName(String name) {
		return findOne("FROM User where name = ?", name);
	}
	
	public static void main(String[] args) {
		
		UserDao dao = new UserDao();
		dao.add(new User(1, "ASDAS", 12));
		dao.add(new User(1, "SADAS", 33));
		
		System.out.println(dao.findOneByName("SADAS"));
		
		User u1 = dao.find(1);
		
		u1.setName("jtwu");
		
		dao.update(u1);
		
		dao.add(new User(1,"kyo", 23));
		
		List<User> users = dao.findAll("FROM User");
		for (User u : users) {
			System.out.println(u);
		}
	
		System.out.println(dao.find(3));
	}

}
