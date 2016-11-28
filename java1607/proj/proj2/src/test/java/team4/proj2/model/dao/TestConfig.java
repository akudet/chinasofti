package team4.proj2.model.dao;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

/**
 * 
 * Setup a session factory used by SpringAbstract dao<br>
 * by default it search your DAO impls in ROOT_DIR and mapping files in HBM_DIR<br>
 * if you already set up a session factory this class is useless
 * 
 * @author Jintong Wu
 *
 */
@Configuration
@ComponentScan(basePackages={TestConfig.ROOT_DIR})
public class TestConfig {

	public static final String ROOT_DIR = "team4/proj2/model/dao/impl/hb";
	public static final String HBM_DIR = ROOT_DIR + "/hbm";
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		
		// setup dialect
		Properties pros = new Properties();
		pros.setProperty("hibernate.dialect",
				"org.hibernate.dialect.MySQLDialect");
		pros.setProperty("hibernate.show_sql", "true");
		pros.setProperty("hibernate.hbm2ddl.auto", "update");
		lsfb.setHibernateProperties(pros);

		// setup datasource
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/proj2_test");
		dmds.setUsername("root");
		dmds.setPassword("root");
		lsfb.setDataSource(dmds);

		// setup mapping
		lsfb.setMappingDirectoryLocations(new ClassPathResource(HBM_DIR));
		
		lsfb.setAnnotatedPackages("team4.proj2.model.vo");
		lsfb.setPackagesToScan("team4.proj2.model.vo");

		return lsfb;
	}
}
