package demo;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.dao.MessageDAO;
import demo.dao.UserDAO;

public class SpringTest {
	
	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
		
		DataSource ds = context.getBean(DataSource.class);
		System.out.println(ds.getConnection());
		
		MessageDAO md = context.getBean(MessageDAO.class);
		System.out.println(md.findOne(1));
		
		UserDAO ud = context.getBean(UserDAO.class);
		System.out.println(ud.findAll());
	}

}
