package misc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.model.vo.Message;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		User user = context.getBean(User.class);
		System.out.println(user.getPass());
		
		Message message = context.getBean(Message.class);
		System.out.println(message);
		
//		TestService ts = context.getBean(TestService.class);
//		System.out.println(ts.test());
		
		TestService ts1 = context.getBean("tsByCons", TestService.class);
		System.out.println(ts1.test());
		
		TestService ts2 = context.getBean("testServiceBean", TestService.class);
		System.out.println(ts2.getList());
		
		TestService ts3 = context.getBean("tsfb", TestService.class);
		System.out.println(ts3.getList());

		System.out.println(ts3.getMap());
		System.out.println(ts3.getSet());
		System.out.println(ts3.getDate());
		
	}
}
