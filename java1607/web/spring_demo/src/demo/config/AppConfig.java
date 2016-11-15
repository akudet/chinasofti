package demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("demo")
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
