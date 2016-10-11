package hibernate_demo.dao;

import java.util.List;

import hibernate_demo.db.DBHelper;
import hibernate_demo.db.SessionWrapper;
import hibernate_demo.db.TransactionWork;
import hibernate_demo.vo.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDao extends AbstractDao<User> {
	
	public UserDao() {
		super(User.class);
	}

	public static void main(String[] args) {
		
		UserDao dao = new UserDao();
		dao.add(new User(1, "ASDAS", 12));
		dao.add(new User(1, "SADAS", 33));
		
		System.out.println(dao.find(2));
		dao.delete(dao.find(2));
		
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
