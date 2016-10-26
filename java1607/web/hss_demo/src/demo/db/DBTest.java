package demo.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DBTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				DBConfig.class);
		
		context = new ClassPathXmlApplicationContext("demo/db/dbconfig.xml");

		DriverManagerDataSource ds = context.getBean("ds",
				DriverManagerDataSource.class);

		try {
			Connection conn = ds.getConnection();
			ResultSet rs = conn.prepareStatement("select * from user")
					.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("username"));
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
