package team4.proj2.model.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import team4.proj2.model.dao.impl.hb.abst.db.HibernateConfig;
import team4.proj2.model.vo.User;

public class UserDAOTest {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
		UserDAO ud = context.getBean(UserDAO.class);
		
		User u = new User();
		u.setName("jtwu");
		u.setAge(10);
		ud.add(u);
		
		u = ud.findOneByName("jtwu");
		System.out.println(u);
		ud.delete(u);
		
		User u2 = ud.find(1000);
		
		u2.setName("helloworld");
		ud.update(u2);
		
		System.out.println(ud.findAll());
	}

}
