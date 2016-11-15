package team4.proj1.model.dao.impl.hb.abst.db;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

@Configuration
@ComponentScan(basePackages={"tp1.model.dao.impl.hb"})
public class HibernateConfig {
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		
		// setup dialect
		Properties pros = new Properties();
		pros.setProperty("hibernate.dialect",
				"org.hibernate.dialect.MySQLDialect");
		pros.setProperty("hibernate.show_sql", "true");
		pros.setProperty("hibernate.hbm2ddl.auto", "create");
		lsfb.setHibernateProperties(pros);

		// setup datasource
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/ssh");
		dmds.setUsername("root");
		dmds.setPassword("root");
		lsfb.setDataSource(dmds);

		// setup mapping
		String[] mres = { "tp1/model/dao/impl/hb/mapping/Vip.hbm.xml" };
		lsfb.setMappingResources(mres);

		return lsfb;
	}
}
