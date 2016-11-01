package springMVC_mybatis_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chinasofti.dao.UserDao;
import com.chinasofti.vo.User;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		UserDao dao = (UserDao) context.getBean("userMapper");
		User user = dao.selectById(1);
		System.out.println(user.getName());
	}
}
