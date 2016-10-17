package demo.test.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DBConfig {

	public static final String URL = "jdbc:mysql://localhost:3306/tp4";
	public static final String NAME = "root";
	public static final String PASS = "jtwu";
	
	@Bean(name = "ds")
	DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl(URL);
		ds.setUsername(NAME);
		ds.setPassword(PASS);
		return ds;
	}
}
