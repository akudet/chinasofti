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

public class UserDao {
	
	public void add(User u) {
		new SessionWrapper(DBHelper.newSession()).save(u);
	}
	
	public static void main(String[] args) {
		
		DBHelper.execute(new TransactionWork<Object>() {

			@Override
			public Object execute(Session session) {
				session.save(new User(1, "ASDAS", 12));
				return null;
			}
			
		});
		
		
		List<User> users = DBHelper.queryAll("FROM User");
		
		User user = DBHelper.execute(new TransactionWork<User>() {

			@Override
			public User execute(Session session) {
				return (User) session.get(User.class, 1);
			}
			
		});
		
		System.out.println(users.get(0));
		
		System.out.println(user);
	
		
	}

}
