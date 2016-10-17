package soundsystem.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import soundsystem.CDPlayer;

@Component
public class CDPlayerTest {
	
	
	CDPlayer cdp;
	
	@Autowired
	public CDPlayerTest(CDPlayer cdp) {
		this.cdp = cdp;
	}
	
	public void play() {
		cdp.play();
	}
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
		
		CDPlayerTest test = context.getBean(CDPlayerTest.class);
		test.play();
	}

}
