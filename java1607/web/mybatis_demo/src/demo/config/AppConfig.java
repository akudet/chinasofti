package demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import demo.dao.MessageDAO;
import demo.dao.UserDAO;

@Configuration
public class AppConfig {
	
	@Bean
	@Autowired
	public MapperFactoryBean<UserDAO> getUserDAO(SqlSessionFactory ssf) {
		return getMapper(ssf, UserDAO.class);
	}
	
	@Bean
	@Autowired
	public MapperFactoryBean<MessageDAO> getMessageDAO(SqlSessionFactory ssf) {
		return getMapper(ssf, MessageDAO.class);
	}
	
	private <T> MapperFactoryBean<T> getMapper(SqlSessionFactory ssf, Class<T> c) {
		MapperFactoryBean<T> mfb =  new MapperFactoryBean<T>();
		mfb.setSqlSessionFactory(ssf);
		mfb.setMapperInterface(c);
		return mfb;
	}

}
