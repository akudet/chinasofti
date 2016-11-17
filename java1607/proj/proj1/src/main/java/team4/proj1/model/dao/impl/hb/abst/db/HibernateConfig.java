package team4.proj1.model.dao.impl.hb.abst.db;

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
@ComponentScan(basePackages={HibernateConfig.ROOT_DIR})
public class HibernateConfig {
	
	public static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "root";

	public static final String ROOT_DIR = "team4/proj1/model/dao/impl/hb";
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
		dmds.setUrl(DB_URL);
		dmds.setUsername(DB_USERNAME);
		dmds.setPassword(DB_PASSWORD);
		lsfb.setDataSource(dmds);

		// setup mapping
		lsfb.setMappingDirectoryLocations(new ClassPathResource(HBM_DIR));

		return lsfb;
	}
}
