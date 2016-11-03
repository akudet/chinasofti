package test.model.dao;

import java.util.List;

import demo.model.dao.impl.UserDAO;
import demo.model.vo.User;

public class UserDAOTest {
	public static void main(String[] args) {	
		UserDAO dao = new UserDAO();
		
		dao.add(new User(1, "Akjkjksjdf", 12));
		dao.add(new User(1, "SADAS", 33));
		
		dao.delete(new User(7, "SADAS", 33));
		
		System.out.println(dao.findOneByName("SADAS"));
		
		User u1 = dao.find(4);
		
		u1.setName("jtwu");
		
		dao.update(u1);
		
		List<User> users = dao.findAll();
		for (User u : users) {
			System.out.println(u);
		}
	}
}
