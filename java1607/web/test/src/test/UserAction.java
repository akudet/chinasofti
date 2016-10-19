package test;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import test.vo.User;

@Controller
public class UserAction {
	
	@Autowired
	SessionFactory sf;
	
	@Autowired
	UserService serv;

	public String add() {
		User user = new User();
		user.setName("jtwu");
		sf.openSession().save(user);
		
		System.out.println("Hello");
		return "index";
	}
	
}
