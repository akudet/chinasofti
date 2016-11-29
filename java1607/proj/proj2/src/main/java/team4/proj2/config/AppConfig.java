package team4.proj2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import team4.proj2.model.dao.impl.hb.abst.db.HibernateConfig;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"team4.proj2.control", "team4.proj2.service"})
@Import(HibernateConfig.class)
public class AppConfig {

	@Bean
	public ViewResolver getViewSolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		
		vr.setPrefix("/views/");
		vr.setSuffix(".jsp");

		return vr;
	}
	

	@Bean(name="multipartResolver")
	public MultipartResolver getMultipartResolver() {
		CommonsMultipartResolver cmr = new CommonsMultipartResolver();
		
		cmr.setMaxUploadSize(1024*1024*1024);
		cmr.setDefaultEncoding("UTF-8");
		
		return cmr;
	}

}