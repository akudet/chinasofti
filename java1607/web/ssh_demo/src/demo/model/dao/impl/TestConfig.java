package demo.model.dao.impl;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import demo.model.db.DBHelper;


@Configuration
@ComponentScan(basePackages="demo.model.dao")
public class TestConfig {
	
	@Bean
	public LocalSessionFactoryBean getSF() {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/ssh");
		dmds.setUsername("root");
		dmds.setPassword("jtwu");
		lsfb.setDataSource(dmds);
		
		Properties pros = new Properties();
		pros.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		lsfb.setHibernateProperties(pros);
		
		lsfb.setPackagesToScan("demo.model.vo");
		String[] mres = {"demo/model/vo/User.hbm.xml", "demo/model/vo/Room.hbm.xml"};
		lsfb.setMappingResources(mres);
		
		return lsfb;
	}

}
