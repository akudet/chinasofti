package demo.model.dao.test.context;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@Configuration
@ComponentScan(basePackages = "demo.model.dao")
public class SessionFactoryConfig {

	@Bean
	public LocalSessionFactoryBean getSF() {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();

		// setup datasource
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/ssh");
		dmds.setUsername("root");
		dmds.setPassword("jtwu");
		lsfb.setDataSource(dmds);

		// setup dialect
		Properties pros = new Properties();
		pros.setProperty("hibernate.dialect",
				"org.hibernate.dialect.MySQLDialect");
		pros.setProperty("hibernate.show_sql", "true");
		pros.setProperty("hibernate.hbm2ddl.auto", "update");
		lsfb.setHibernateProperties(pros);

		// setup mapping
		lsfb.setPackagesToScan("demo.model.vo");
		String[] mres = { "demo/model/vo/User.hbm.xml",
				"demo/model/vo/Room.hbm.xml" };
		lsfb.setMappingResources(mres);

		return lsfb;
	}

}
