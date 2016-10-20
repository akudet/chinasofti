package demo.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import demo.model.vo.User;

@Repository
public class UserDAO extends AbstractDAO<User> {
	
	public UserDAO() {
		super(User.class);
	}
	
	public User findOneByName(String name) {
		return findOne("FROM User where name = ?", name);
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
//		SessionFactory sf = context.getBean(SessionFactory.class);
//		sf.openSession().save(new User(1, "ASDAS", 12));
//		UserDAO ud = new UserDAO();
		
		UserDAO dao = context.getBean(UserDAO.class);
		
		dao.add(new User(1, "ASDAS", 12));
		dao.add(new User(1, "SADAS", 33));
		
		dao.delete(new User(5, "SADAS", 33));
		
		System.out.println(dao.findOneByName("SADAS"));
		
		User u1 = dao.find(1);
		
		u1.setName("jtwu");
		
		System.out.println(u1);
		
		dao.update(u1);
		
		dao.add(new User(1,"kyo", 23));
		
		List<User> users = dao.findAll("FROM User");
		for (User u : users) {
			System.out.println(u);
		}
	
		System.out.println(dao.find(3));
	}

}
