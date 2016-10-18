package concert;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		context = new ClassPathXmlApplicationContext("concert/aopconfig.xml");
		
		Performance p = context.getBean(Performance.class);
		
		p.perform("ASD");
		
		p.perform();
	}
	
}
