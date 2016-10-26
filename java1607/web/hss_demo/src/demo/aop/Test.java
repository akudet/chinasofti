package demo.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("demo/aop/aopconfig.xml");
		Worker worker = context.getBean("worker", Worker.class);
		worker.doWork();
	}
	
}
