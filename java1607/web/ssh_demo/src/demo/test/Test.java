package demo.test;

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
		
		TestService ts = context.getBean(TestService.class);
		System.out.println(ts.test());
	}
}
