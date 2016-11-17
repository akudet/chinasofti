package team4.proj1.model.dao.hb.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import team4.proj1.model.dao.impl.hb.abst.db.HibernateConfig;

public class TestUtil {
	
	public static ApplicationContext getContext() {
		return new AnnotationConfigApplicationContext(HibernateConfig.class);
		
	}

}
